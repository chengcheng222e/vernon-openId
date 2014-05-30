package weibo4j.examples.account;

import net.ningmengcao.openid.core.WeiboConstant;
import weibo4j.Account;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.School;
import weibo4j.model.WeiboException;

import java.util.List;

public class GetAccountPrpfileSchoolList {

	public static void main(String[] args) {
        String access_token = WeiboConstant.INSTANCE.getStr("accessToken");
		Account am = new Account();
		am.client.setToken(access_token);
		try {
			List<School> schools = am.getAccountPrpfileSchoolList();
			for (School school : schools) {
				Log.logInfo(school.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
