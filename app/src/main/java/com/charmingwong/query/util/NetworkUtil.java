package com.charmingwong.query.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PrivateKey;

/**
 * Created by 56223 on 2017/2/23.
 */

public class NetworkUtil {

    private static final String API_KEY_BAIDU = "c58b256f3b2c3b79dad4320888b8e5e3";


    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        boolean isHeader = "http://apis.baidu.com/bdyunfenxi/intelligence/ip".equals(httpUrl);
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            if (isHeader) {
                connection.setRequestProperty("apikey", "c58b256f3b2c3b79dad4320888b8e5e3");
            }
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
