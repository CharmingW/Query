package com.charmingwong.query.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.charmingwong.query.R;
import com.charmingwong.query.entity.DomainRoot;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomainQueryActivity extends AppCompatActivity {

    private static final String TAG = "DomainQueryActivity";
    private EditText mEt;
    private Button mBtn;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domain);
        mEt = (EditText) findViewById(R.id.et_domain);
        mBtn = (Button) findViewById(R.id.btn_query);
        mTv = (TextView) findViewById(R.id.tv_result);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String domainString = mEt.getText().toString();
                Pattern pattern = Pattern.compile("[0-9a-zA-Z]+\\.[a-zA-Z]+\\.*[a-zA-Z]*");
                Matcher matcher = pattern.matcher(domainString);
                final String[] fields = domainString.split("\\.");
                if (matcher.find()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String domainUrl = "http://www.yumingco.com/api";
                            String suffix = null;
                            String domain = fields[0];
                            Log.i(TAG, domain);
                            if (fields.length == 2) {
                                suffix = fields[1];
                            } else if (fields.length == 3) {
                                suffix = fields[1] + "." + fields[2];
                            }
                            Log.i(TAG, suffix);
                            final String jsonResult = request(domainUrl, "domain=" + domain + "&suffix=" + suffix);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Gson gson = new Gson();
                                    DomainRoot root = gson.fromJson(jsonResult, DomainRoot.class);
                                    if (root != null) {
                                        if (root.isStatus()) {
                                            if (root.isAvailable()) {
                                                mTv.setText(domainString + "未注册");
                                            } else {
                                                mTv.setText(domainString + "已注册");
                                            }
                                        }
                                    }
                                }
                            });
                        }
                    }).start();
                }

            }
        });

    }

    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
//            connection.setRequestProperty("apikey", "c58b256f3b2c3b79dad4320888b8e5e3");
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
