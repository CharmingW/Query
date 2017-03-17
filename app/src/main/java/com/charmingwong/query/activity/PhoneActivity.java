package com.charmingwong.query.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.charmingwong.query.R;
import com.charmingwong.query.entity_phone.Result;
import com.charmingwong.query.entity_phone.Root;
import com.charmingwong.query.util.NetworkUtil;
import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneActivity extends AppCompatActivity {

    private static final String TAG = "PhoneActivity";
    private static final String API_KEY_PHONE = "3edb6f2b85018ca0760eee90c827ff0e";
    private static final String PHONE_URL = "http://apis.juhe.cn/mobile/get";
    private EditText mEt;
    private Button mBtn;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        mEt = (EditText) findViewById(R.id.et_phone);
        mBtn = (Button) findViewById(R.id.btn_query);
        mTv = (TextView) findViewById(R.id.tv_result);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String phoneString = mEt.getText().toString();
                Pattern pattern = Pattern.compile("\\d{11}");
                Matcher matcher = pattern.matcher(phoneString);
                if (matcher.find()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            final String jsonResult = NetworkUtil.request(PHONE_URL, "key=" + API_KEY_PHONE + "&" + "phone=" + phoneString);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.i(TAG, "onClick: " + jsonResult);
                                    Gson gson = new Gson();
                                    Root root = gson.fromJson(jsonResult, Root.class);
                                    Result result = root.getResult();
                                    mTv.setText(
                                            "归属：" + result.getProvince() + result.getCity() + "\n"
                                                    + "区号：" + result.getAreacode() + "\n"
                                                    + "邮编：" + result.getZip() + "\n"
                                                    + "类型：" + result.getCompany() + result.getCard()
                                    );
                                }
                            });
                        }
                    }).start();
                }

            }
        });

    }
}
