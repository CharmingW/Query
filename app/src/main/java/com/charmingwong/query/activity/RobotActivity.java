package com.charmingwong.query.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.charmingwong.query.R;
import com.charmingwong.query.enity_robot.Result;
import com.charmingwong.query.enity_robot.Root;
import com.charmingwong.query.util.NetworkUtil;
import com.google.gson.Gson;


public class RobotActivity extends AppCompatActivity {

    private static final String TAG = "IdActivity";
    private EditText mEtInfo;
    private Button mBtn;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot);
        mEtInfo = (EditText) findViewById(R.id.et_info);
        mBtn = (Button) findViewById(R.id.btn_query);
        mTv = (TextView) findViewById(R.id.tv_result);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String httpUrl = "http://op.juhe.cn/robot/index";
                final StringBuilder httpArgs =
                        new StringBuilder("key=bfd49cf29bff4dcaff68f7a8dfb70d17&loc=广州&lon=113.392738&lat=23.056111&info=");
                String info = mEtInfo.getText().toString();
                httpArgs.append(info);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String jsonResult
                                = NetworkUtil.request(httpUrl,
                                httpArgs.toString());
                        Log.i(TAG, "run: " + jsonResult);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                Root root = gson.fromJson(jsonResult, Root.class);
                                if (0 == root.getError_code()) {
                                    Result result = root.getResult();
                                    mTv.setText(result.getText());
                                }

                            }
                        });

                    }
                }).start();
            }
        });
    }
}
