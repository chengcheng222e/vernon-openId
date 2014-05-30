package weibo4j.examples.account;

import net.ningmengcao.openid.core.WeiboConstant;
import weibo4j.Account;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.WeiboException;

public class GetAccountRateLimitStatus {

	public static void main(String[] args) {
        String access_token = WeiboConstant.INSTANCE.getStr("accessToken");
		Account am = new Account();
		am.client.setToken(access_token);
		try {
            RateLimitStatus json = am.getAccountRateLimitStatus();
			Log.logInfo(json.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
