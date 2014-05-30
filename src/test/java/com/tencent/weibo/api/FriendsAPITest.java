package com.tencent.weibo.api;

import com.tencent.weibo.BaseTest;
import com.tencent.weibo.constants.OAuthConstants;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 5/30/14
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */
public class FriendsAPITest extends BaseTest {

    private FriendsAPI friendsAPI = new FriendsAPI(OAuthConstants.OAUTH_VERSION_2_A);

    // 粉丝列表
    @Test
    public void testFanslist() throws Exception {
        String response = friendsAPI.fanslist(oAuth, format, reqnum, startindex, mode, install);
        logger.info("========================== ");
        logger.info("response = " + response);
    }

    @Test
    public void testIdollist() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testDel() throws Exception {

    }

    @Test
    public void testCheck() throws Exception {

    }

    @Test
    public void testUserFanslist() throws Exception {

    }

    @Test
    public void testUserIdollist() throws Exception {

    }

    @Test
    public void testUserSpeciallist() throws Exception {

    }

    @Test
    public void testFanslistS() throws Exception {

    }
}
