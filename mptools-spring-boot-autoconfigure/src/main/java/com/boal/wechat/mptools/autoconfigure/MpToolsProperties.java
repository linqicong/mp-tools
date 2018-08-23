package com.boal.wechat.mptools.autoconfigure;

import com.boal.wechat.util.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/23<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
@ConfigurationProperties(prefix = MpToolsProperties.PREFIX)
public class MpToolsProperties {
    public static final String PREFIX = "wechat.mp-tools";

    private  String appid;
    private  String secret;
    private  String host;
    private  String password;
    private  int port;
    private  int timeout;
    private  int database;

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
        if (StringUtils.isEmpty(password)){
            return null;
        }
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
}
