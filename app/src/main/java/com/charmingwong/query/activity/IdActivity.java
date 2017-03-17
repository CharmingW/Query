package com.charmingwong.query.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.charmingwong.query.R;
import com.charmingwong.query.entity.IdRoot;
import com.charmingwong.query.entity.Result;
import com.charmingwong.query.util.NetworkUtil;
import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdActivity extends AppCompatActivity {

    private static final String TAG = "IdActivity";
    private EditText mEtId;
    private Button mBtn;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);
        mEtId = (EditText) findViewById(R.id.et_id);
        mBtn = (Button) findViewById(R.id.btn_query);
        mTv = (TextView) findViewById(R.id.tv_result);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id = mEtId.getText().toString();
                final String httpUrl =
                        "http://apis.juhe.cn/idcard/index";
                Pattern idPattern = Pattern.compile("^\\d{18}$");
                Matcher idMatcher = idPattern.matcher(id);
                boolean im = idMatcher.find();
                if (im) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            final String jsonResult
                                    = NetworkUtil.request(
                                    httpUrl,
                                    "key=becf6e0017aa0b9c7b061589e8d40a9e&" + "cardno=" + id);
                            Log.i(TAG, "run: " + jsonResult);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Gson gson = new Gson();
                                    IdRoot root = gson.fromJson(jsonResult, IdRoot.class);
                                    if ("200".equals(root.getResultcode())) {
                                        Result result = root.getResult();
                                        mTv.setText("出生地：" + result.getArea() + "\n"
                                                + "性别：" + result.getSex() + "\n"
                                                + "生日：" + result.getBirthday());
                                    }

                                }
                            });

                        }
                    }).start();
                }
            }
        });
    }
}
