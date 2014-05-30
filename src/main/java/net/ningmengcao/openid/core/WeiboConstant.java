package net.ningmengcao.openid.core;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 5/29/14
 * Time: 17:35
 * To change this template use File | Settings | File Templates.
 */
public class WeiboConstant {

    private Logger logger = Logger.getLogger(WeiboConstant.class);

    public final static WeiboConstant INSTANCE = new WeiboConstant();
    private final Properties properties;

    public WeiboConstant() {
        properties = new Properties();
        try {
            properties.load(WeiboConstant.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            logger.error("e = {}", e);
        }
    }

    public String getStr(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public String getStr(String key) {
        return getStr(key, null);
    }

    public int getInt(String key) {
        return getInt(key, 0);
    }

    public int getInt(String key, int defaultValue) {
        String value = properties.getProperty(key, defaultValue + "");
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logger.error("e = {}", e);
        }
        return defaultValue;
    }

}
