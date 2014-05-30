package com.tencent.weibo;

import com.tencent.weibo.api.TAPI;
import com.tencent.weibo.constants.OAuthConstants;
import com.tencent.weibo.oauthv2.OAuthV2;
import net.ningmengcao.openid.core.TencentWeiboConstant;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 5/30/14
 * Time: 9:05
 * To change this template use File | Settings | File Templates.
 */
public class TencentWeiboServiceApiTest extends BaseTest{


    @Test
    public void testAdd() throws Exception {
        //取得返回结果
        response = tAPI.add(oAuth, format, "#我跑testAdd#添加一条腾讯微博~" + content, clientip, jing, wei, syncflag);
        // json数据使用
        // response的结果可能是这样，{"data":{"id":"90221131024999","time":1333002978},"errcode":0,"msg":"ok","ret":0}
        // 下面的代码将取出 id 的对应值，并赋予 reid
        System.out.println("response = " + response);
        JSONObject responseJsonObject;
        JSONObject dataJsonObject;

        responseJsonObject = JSONObject.fromObject(response);
        dataJsonObject = (JSONObject) responseJsonObject.get("data");
        id = ids = reid = dataJsonObject.get("id").toString();//对后面用到的 reid 赋值
        System.out.println("reid = " + reid);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
    }

    @Test
    public void testReCount() throws Exception {
        tAPI.reCount(oAuth, format, ids, flag);
    }


    @Test
    public void testShow() throws Exception {
        tAPI.show(oAuth, format, id);
    }

    @Test
    public void testAddWithPic() throws Exception {
        response = tAPI.addPic(oAuth, format, "发表一条带网络图片的微博" + content, clientip, jing, wei, "http://t3.qpic.cn/mblogpic/d26d1168b2c6c25db192/460", syncflag);
        // json数据使用
        // response的结果可能是这样，{"data":{"id":"90221131024999","time":1333002978},"errcode":0,"msg":"ok","ret":0}
        // 下面的代码将取出 id 的对应值，并赋予 reid
        System.out.println("response = " + response);
        JSONObject responseJsonObject;
        JSONObject dataJsonObject;
        //取出返回的 id
        responseJsonObject = JSONObject.fromObject(response);
        dataJsonObject = (JSONObject) responseJsonObject.get("data");
        ids += "," + dataJsonObject.get("id").toString();//对后面用到的 ids 赋值
        System.out.println("ids = " + ids);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }

        tAPI.addPic(oAuth, format, "发表一条带本地图片的微博" + content, clientip, jing, wei, picpath, syncflag);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
    }

    @Test
    public void testForward() throws Exception {
        //更多微博相关API测试
        tAPI.reAdd(oAuth, format, "转播一条微博" + content, clientip, jing, wei, reid);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
    }

    @Test
    public void testComment() throws Exception {
        tAPI.comment(oAuth, format, "点评一条微博" + content, clientip, jing, wei, reid);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
    }

    @Test
    public void testReList() throws Exception {
        tAPI.reList(oAuth, format, flag, id, pageflag, pagetime, reqnum, twitterid);
    }

    @Test
    public void testDelete() throws Exception {
        tAPI.del(oAuth, format, id);
    }

    @Test
    public void testAddVideo() throws Exception {
        tAPI.addVideo(oAuth, format, "发表视频微博" + content, clientip, jing, wei, "http://www.tudou.com/programs/view/yx41TA6rQfE/?resourceId=0_03_05_07", syncflag);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
    }
}
