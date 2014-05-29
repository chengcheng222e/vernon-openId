package net.ningmengcao.openid.core;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 5/29/14
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */
public class TencentWeiboConstantTest {

    private Logger logger = Logger.getLogger(TencentWeiboConstantTest.class);

    //clientId=801510873
    //clientSecret=1e166b73cb38da2cc32e4c0116bdad69
    //redirectUri=http://tweet.ningmengcao.net

    private final String clientId = "clientId";
    private final String clientSecret = "clientSecret";
    private final String redirectUri = "redirectUri";

    @Test
    public void testGetStr() throws Exception {
        String result = TencentWeiboConstant.INSTANCE.getStr(clientId);
        logger.info("clientId = " + result);

        result = TencentWeiboConstant.INSTANCE.getStr(clientSecret);
        logger.info("clientSecret = " + result);

        result = TencentWeiboConstant.INSTANCE.getStr(redirectUri);
        logger.info("redirectUri = " + result);
    }

    @Test
    public void testGetStr1() throws Exception {

    }

    @Test
    public void testGetInt() throws Exception {

    }

    @Test
    public void testGetInt1() throws Exception {

    }
}
