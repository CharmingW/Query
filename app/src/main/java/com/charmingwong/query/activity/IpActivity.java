package com.charmingwong.query.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.charmingwong.query.R;
import com.charmingwong.query.entity.Base_info;
import com.charmingwong.query.entity.IpRoot;
import com.charmingwong.query.util.NetworkUtil;
import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpActivity extends AppCompatActivity {

    private static final String TAG = "IpActivity";
    private EditText mEt;
    private Button mBtn;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip);
        mEt = (EditText) findViewById(R.id.et_ip);
        mBtn = (Button) findViewById(R.id.btn_query);
        mTv = (TextView) findViewById(R.id.tv_result);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ipString = mEt.getText().toString();
                Pattern pattern = Pattern.compile("\\d+.\\d+.\\d+.\\d+");
                Matcher matcher = pattern.matcher(ipString);
                if (matcher.find()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String ipUrl = "http://apis.baidu.com/bdyunfenxi/intelligence/ip";
                            final String jsonResult = NetworkUtil.request(ipUrl, "ip=" + ipString);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.i(TAG, "onClick: " + jsonResult);
                                    Gson gson = new Gson();
                                    IpRoot root = gson.fromJson(jsonResult, IpRoot.class);
                                    Base_info base = root.getBase_info();
                                    mTv.setText(base.getCountry() +
                                            base.getProvince() +
                                            base.getCity() + base.getCounty() + "\n" +
                                            base.getIsp());
                                }
                            });
                        }
                    }).start();
                }

            }
        });

    }
}
