package com.boal.wechat.util;

import com.boal.wechat.exception.WechatMpApiException;
import com.boal.wechat.response.user.DownloadResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.*;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http工具类
 * author：Boal lin
 */
public class HttpsUtils {
    private static PoolingHttpClientConnectionManager	connMgr;
	private static RequestConfig				requestConfig;
	private static final int				MAX_TIMEOUT	= 7000;
 
	private static final Log logger		= LogFactory.getLog(HttpsUtils.class);
 
	static {
		// 设置连接池
		connMgr = new PoolingHttpClientConnectionManager();
		// 设置连接池大小
		connMgr.setMaxTotal(100);
		connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());
		// Validate connections after 1 sec of inactivity
		connMgr.setValidateAfterInactivity(1000);
		RequestConfig.Builder configBuilder = RequestConfig.custom();
		// 设置连接超时
		configBuilder.setConnectTimeout(MAX_TIMEOUT);
		// 设置读取超时
		configBuilder.setSocketTimeout(MAX_TIMEOUT);
		// 设置从连接池获取连接实例的超时
		configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
 
		requestConfig = configBuilder.build();
	}
 
	/**
	 * 发送 GET 请求（HTTP），不带输入数据
	 * 
	 * @param url
	 * @return
	 */
	public static String doGet(String url) {
		return doGet(url, null);
	}
 
	/**
	 * 发送 GET 请求（HTTP），K-V形式
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doGet(String url, Map<String, Object> params) {
		String apiUrl = url;
		if (params != null){
			StringBuffer param = new StringBuffer();
			int i = 0;
			for (String key : params.keySet()) {
				if (i == 0 && url.indexOf("?") == -1)
					param.append("?");
				else
					param.append("&");
				param.append(key).append("=").append(params.get(key));
				i++;
			}
			apiUrl += param;
		}
		String result = null;
		HttpClient httpClient = getHttpClient(url);
		HttpResponse response = null;
		try {
			HttpGet httpGet = new HttpGet(apiUrl);
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			logger.error(e);
		}finally {
			doFinally(response);
		}
		return result;
	}
 
	/**
	 * 发送 POST 请求（HTTP），不带输入数据
	 * 
	 * @param apiUrl
	 * @return
	 */
	public static String doPost(String apiUrl) {
		return doPost(apiUrl, new HashMap<String, Object>());
	}
 
	/**
	 * 发送 POST 请求，K-V形式
	 * 
	 * @param apiUrl
	 *            API接口URL
	 * @param params
	 *            参数map
	 * @return
	 */
	public static String doPost(String apiUrl, Map<String, Object> params) {
		CloseableHttpClient httpClient = getHttpClient(apiUrl);
		String httpStr = null;
		HttpPost httpPost = new HttpPost(apiUrl);
		CloseableHttpResponse response = null;
 
		try {
			httpPost.setConfig(requestConfig);
			List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
				pairList.add(pair);
			}
			httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			logger.error(e);
			throw new WechatMpApiException(e.getMessage());
		} finally {
			doFinally(response);
		}
		return httpStr;
	}
 
	/**
	 * 发送 POST 请求，JSON形式
	 * 
	 * @param apiUrl
	 * @param json
	 *            json对象
	 * @return
	 */
	public static String doPost(String apiUrl, String json) {
		CloseableHttpClient httpClient = getHttpClient(apiUrl);
		String httpStr = null;
		HttpPost httpPost = new HttpPost(apiUrl);
		CloseableHttpResponse response = null;
 
		try {
			httpPost.setConfig(requestConfig);
			// 解决中文乱码问题
			StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
			stringEntity.setContentEncoding("UTF-8");
			stringEntity.setContentType("application/json");
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			logger.error(e);
			throw new WechatMpApiException(e.getMessage());
		} finally {
			doFinally(response);
		}
		return httpStr;
	}
	public static String doPost(String url, Map<String, Object> params, File file){
		String apiUrl = url;
		if (params != null){
			StringBuffer param = new StringBuffer();
			int i = 0;
			for (String key : params.keySet()) {
				if (i == 0 && url.indexOf("?") == -1)
					param.append("?");
				else
					param.append("&");
				param.append(key).append("=").append(params.get(key));
				i++;
			}
			apiUrl += param;
		}
		CloseableHttpResponse httpResponse = null;
		CloseableHttpClient httpClient = getHttpClient(apiUrl);
		HttpPost httpPost = new HttpPost(apiUrl);
		String httpStr = null;
		try{
			MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
			multipartEntityBuilder.addBinaryBody("media",file);
			HttpEntity httpEntity = multipartEntityBuilder.build();
			httpPost.setEntity(httpEntity);
			httpResponse = httpClient.execute(httpPost);
			HttpEntity entity = httpResponse.getEntity();
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			logger.error(e);
			throw new WechatMpApiException(e.getMessage());
		} finally {
			doFinally(httpResponse);
		}
		return httpStr;

	}

	/**
	 * 下载文件
	 *
	 * @param url
	 */
	public static DownloadResponse httpDownloadFile(String url,Map<String, Object> params) {
		String apiUrl = url;
		if (params != null){
			StringBuffer param = new StringBuffer();
			int i = 0;
			for (String key : params.keySet()) {
				if (i == 0 && url.indexOf("?") == -1)
					param.append("?");
				else
					param.append("&");
				param.append(key).append("=").append(params.get(key));
				i++;
			}
			apiUrl += param;
		}
		String result = null;
		HttpClient httpClient = getHttpClient(url);
		HttpResponse response = null;
		DownloadResponse downloadResponse = null;
		try {
			HttpGet httpGet = new HttpGet(apiUrl);
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			Header disposition = response.getFirstHeader("Content-disposition");
			byte[] buffer = new byte[4096];
			int r = 0;
			while ((r = is.read(buffer)) > 0) {
				output.write(buffer, 0, r);
			}
			downloadResponse = new DownloadResponse();
			downloadResponse.setOutputStream(output);
			downloadResponse.setFileName(disposition.getElements()[0].getParameter(0).getValue());
		} catch (IOException e) {
			logger.error(e);
		}finally {
			doFinally(response);
		}
		return downloadResponse;
	}
	/**
	 * 创建SSL安全连接
	 *
	 * @return
	 */
	private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
		SSLConnectionSocketFactory sslsf = null;
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			sslsf = new SSLConnectionSocketFactory(sslContext, new HostnameVerifier() {

				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			});
		} catch (GeneralSecurityException e) {
			logger.error(e);
			throw new WechatMpApiException(e.getMessage());
		}
		return sslsf;
	}

	private static CloseableHttpClient getHttpClient(String url){
		if (url.startsWith("https")) {
			return HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory())
					.setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
		} else {
			return HttpClients.custom().setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
		}
	}

	private static void doFinally(HttpResponse response){
		if (response != null) {
			try {
				EntityUtils.consume(response.getEntity());
			} catch (IOException e) {
				logger.error(e);
				throw new WechatMpApiException(e.getMessage());
			}
		}
	}
}
