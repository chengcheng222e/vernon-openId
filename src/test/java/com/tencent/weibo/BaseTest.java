package com.tencent.weibo;

import com.tencent.weibo.api.TAPI;
import com.tencent.weibo.oauthv2.OAuthV2;
import net.ningmengcao.openid.core.TencentWeiboConstant;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 5/30/14
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */
public class BaseTest {

    public Logger logger = Logger.getLogger(TencentWeiboServiceApiTest.class);

    // -------------------------------- field names --------------------


    public String response;
    public String format = "json";
    public String clientip = "127.0.0.1";
    public String jing = "";
    public String wei = "";
    public String syncflag = "";
    public String pageflag = "0";
    public String pagetime = "0";
    public String reqnum = "5";
    public String lastid = "'0";
    public String contenttype = "0";
    public String content = "2";// 注意：因为后台会对微博内容进行判重，所以在重复测试时加上变换部分++++++++
    public String twitterid = "0";
    public String fopenids = "";
    public String fopenid = "";
    public String reid = null;
    public String ids = null;
    public String id = null;
    public String names = "api_weibo,t-qq-com,vvtest1";
    public String name = "t-qq-com";
    public String flag = "2";
    public String keyword = "微博";
    public String pagesize = "5";
    public String page = "0";
    public String searchtype = "0";
    public String msgtype = "0";
    public String sorttype = "0";
    public String type = "0";
    public String op = "0";
    public String starttime = "";
    public String endtime = "";
    public String province = "";
    public String city = "";
    public String longitue = "";
    public String latitude = "";
    public String radius = "";
    public String startindex = "0";
    public String mode = "0";
    public String install = "0";
    public String picpath = System.getProperty("user.dir") + "\\src\\main\\resources\\logo_QWeibo.jpg";

    public OAuthV2 oAuth = new OAuthV2();
    public TAPI tAPI;

    @Before
    public void init() {
        String clientId = TencentWeiboConstant.INSTANCE.getStr("clientId");
        String clientSecret = TencentWeiboConstant.INSTANCE.getStr("clientSecret");
        String redirectUri = TencentWeiboConstant.INSTANCE.getStr("redirectUri");
        // 二次获取
        String authorizeCode = TencentWeiboConstant.INSTANCE.getStr("authorizeCode");
        String accessToken = TencentWeiboConstant.INSTANCE.getStr("accessToken");
        String expiresIn = TencentWeiboConstant.INSTANCE.getStr("expiresIn");
        String refreshToken = TencentWeiboConstant.INSTANCE.getStr("refreshToken");
        String openId = TencentWeiboConstant.INSTANCE.getStr("openId");
        String openKey = TencentWeiboConstant.INSTANCE.getStr("openKey");

        oAuth.setRedirectUri(redirectUri);
        oAuth.setClientId(clientId);
        oAuth.setClientSecret(clientSecret);
        oAuth.setResponseType("code");// 默认
        oAuth.setType("default");// 默认
        oAuth.setAuthorizeCode(authorizeCode);
        oAuth.setAccessToken(accessToken);
        oAuth.setExpiresIn(expiresIn);
        oAuth.setGrantType("authorization_code");// 默认
        oAuth.setRefreshToken(refreshToken);
        oAuth.setOpenid(openId);
        oAuth.setOpenkey(openKey);
        oAuth.setMsg("");

        tAPI = new TAPI(oAuth.getOauthVersion());//根据oAuth配置对应的连接管理器
    }

    @After
    public void close() {
        tAPI.shutdownConnection();//关闭连接管理器
    }

}
