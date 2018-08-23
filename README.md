# mp-tools
微信公众号API工具,是微信公众平台接口服务的JAVA 实现，按照微信公众号官方文档开发。


## 开发进度
mp-tools  已完成30%

* UserApi 
* ......

## maven

```xml
<dependency>
    <groupId>com.boal.wechat</groupId>
    <artifactId>mp-tools</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
## 方式一：直接调用
```java
WechatMpConfigs wechatMpConfigs = WechatMpConfigs.init("appid","secret","127.0.0.1",6379,3000,null,0);
WechatMpApi wechatMpApi = new WechatMpApi(wechatMpConfigs);
wechatMpApi.userApi().getUserInfo(openId,null);
```
## 方式二：使用配置文件 wechat-mp.properties
```
mp_appid =
mp_secret = 
redis_host = 127.0.0.1
redis_password =
redis_port = 6379
redis_timeout = 3000
redis_database = 0
```
```java
WechatMpConfigs wechatMpConfigs = WechatMpConfigs.init();
WechatMpApi wechatMpApi = new WechatMpApi(wechatMpConfigs);
wechatMpApi.userApi().getUserInfo(openId,null);
```
## 方式三：使用Spring-boot-starter
```xml
 <dependency>
    <groupId>com.boal.wechat</groupId>
    <artifactId>mptools-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
```xml
wechat:
  mp-tools:
    appid:
    secret:
    host: 127.0.0.1
    password:
    port: 6379
    timeout: 3000
    database: 0
```
```java
@Autowired
private WechatMpApi wechatMpApi;

@RequestMapping("getUserInfo")
public String getUserInfo(String openId){
   UserInfoResponse response = wechatMpApi.userApi().getUserInfo(openId,null);
   return GsonFactory.getGson().toJson(response);
}
```
