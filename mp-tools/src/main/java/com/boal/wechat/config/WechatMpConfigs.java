package com.boal.wechat.config;

import com.boal.wechat.util.StringUtils;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by liuyangkly on 15/6/27.
 */
public class WechatMpConfigs {
    private static Log log = LogFactory.getLog(WechatMpConfigs.class);

    private static final String DEFAULT_PATH = "wechat-mp.properties";

    private  String appid;
    private  String secret;
    private  String host;
    private  String password;
    private  int port;
    private  int timeout;
    private  int database;


    private WechatMpConfigs() {
        // No Constructor
    }

    // 根据文件名读取配置文件，文件后缀名必须为.properties
    public  static WechatMpConfigs init(String filePath) {
        WechatMpConfigs wechatMpConfigs = new WechatMpConfigs();
        Configuration configuration = null;
        if (StringUtils.isEmpty(filePath)){
            filePath = DEFAULT_PATH;
        }
        try {
            Configurations configurations = new Configurations();
            // setDefaultEncoding是个静态方法,用于设置指定类型(class)所有对象的编码方式。
            // 本例中是PropertiesConfiguration,要在PropertiesConfiguration实例创建之前调用。
            FileBasedConfigurationBuilder.setDefaultEncoding(PropertiesConfiguration.class, "UTF-8");
            configuration = configurations.properties(filePath);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        if (configuration == null) {
            throw new IllegalStateException("can`t find file by path:" + filePath);
        }

        wechatMpConfigs.appid = configuration.getString("mp_appid");
        wechatMpConfigs.secret = configuration.getString("mp_secret");
        wechatMpConfigs.host = configuration.getString("redis_host");
        wechatMpConfigs.password = configuration.getString("redis_password");
        wechatMpConfigs.port = configuration.getInt("redis_port");
        wechatMpConfigs.timeout = configuration.getInt("redis_timeout");
        wechatMpConfigs.database = configuration.getInt("redis_database");
        wechatMpConfigs.password = StringUtils.isEmpty( wechatMpConfigs.password )?null: wechatMpConfigs.password ;
        log.info("配置文件名: " + filePath);
        log.info(wechatMpConfigs.toString());
        return wechatMpConfigs;
    }
    public  static WechatMpConfigs init() {
        return init(DEFAULT_PATH);
    }
    public  static WechatMpConfigs init(String appid, String secret, String host, Integer port, Integer timeout, String password, Integer database) {
        WechatMpConfigs wechatMpConfigs = new WechatMpConfigs();
        wechatMpConfigs.appid = appid;
        wechatMpConfigs.secret = secret;
        wechatMpConfigs.host = host;
        wechatMpConfigs.password = password;
        wechatMpConfigs.port = port;
        wechatMpConfigs.timeout = timeout;
        wechatMpConfigs.database = database;
        log.info(wechatMpConfigs.toString());
        return wechatMpConfigs;
    }
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "WechatMpConfigs{" +
                "appid='" + appid + '\'' +
                ", secret='" + secret + '\'' +
                ", host='" + host + '\'' +
                ", password='" + password + '\'' +
                ", port=" + port +
                ", timeout=" + timeout +
                ", database=" + database +
                '}';
    }
}

