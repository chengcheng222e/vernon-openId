package weibo4j.examples.account;

import net.ningmengcao.openid.core.WeiboConstant;
import weibo4j.Account;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;

public class GetUid {

	public static void main(String[] args) {
        String access_token = WeiboConstant.INSTANCE.getStr("accessToken");
		Account am = new Account();
		am.client.setToken(access_token);
		try {
			JSONObject uid = am.getUid();
			Log.logInfo(uid.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
