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
import com.charmingwong.query.entity_word.Result;
import com.charmingwong.query.entity_word.Root;
import com.charmingwong.query.util.NetworkUtil;
import com.google.gson.Gson;

import java.util.List;


public class WordActivity extends AppCompatActivity {

    private static final String TAG = "IdActivity";
    private EditText mEtWord;
    private Button mBtn;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        mEtWord = (EditText) findViewById(R.id.et_word);
        mBtn = (Button) findViewById(R.id.btn_query);
        mTv = (TextView) findViewById(R.id.tv_result);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String httpUrl = "http://v.juhe.cn/chengyu/query";
                final StringBuilder httpArgs =
                        new StringBuilder("key=7449c801c2fea622f2b3c36220abcc76&word=");
                String info = mEtWord.getText().toString();
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
                                    StringBuilder sb = new StringBuilder();
                                    Result result = root.getResult();
                                    sb.append("拼音：");
                                    sb.append(result.getPinyin());
                                    sb.append("\n");
                                    sb.append("\n");
                                    sb.append("成语解释：");
                                    sb.append(result.getChengyujs());
                                    sb.append("\n");
                                    sb.append("\n");
                                    sb.append("出自：");
                                    sb.append(result.getFrom_());
                                    sb.append("\n");
                                    sb.append("\n");
                                    sb.append("例子：");
                                    sb.append(result.getExample());
                                    sb.append("\n");
                                    sb.append("\n");
                                    sb.append("语法：");
                                    sb.append(result.getYufa());
                                    sb.append("\n");
                                    sb.append("\n");
                                    sb.append("词语解释：");
                                    sb.append(result.getCiyujs());
                                    sb.append("\n");
                                    sb.append("\n");
                                    sb.append("引证解释：");
                                    sb.append(result.getYinzhengjs());
                                    sb.append("\n");
                                    sb.append("\n");
                                    sb.append("同义：");
                                    List<String> tongyi = result.getTongyi();
                                    if (tongyi != null) {
                                        for (String s : tongyi) {
                                            sb.append(s);
                                            sb.append(" ");
                                        }
                                    }
                                    sb.append("\n");
                                    sb.append("\n");
                                    sb.append("反义：");
                                    List<String> fanyi = result.getFanyi();
                                    if (fanyi != null) {
                                        for (String s : fanyi) {
                                            sb.append(s);
                                            sb.append(" ");
                                        }
                                    }
                                    sb.append("\n");
                                    mTv.setText(sb.toString());
                                } else {
                                    mTv.setText("暂无该词条，换个试试吧！");
                                }
                                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                manager.hideSoftInputFromWindow(mEtWord.getWindowToken(), 0);

                            }
                        });

                    }
                }).start();
            }
        });
    }
}
