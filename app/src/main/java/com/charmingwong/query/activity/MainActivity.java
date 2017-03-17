package com.charmingwong.query.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.charmingwong.query.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private TextView t1, t2, t3, t4, t5, t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.no1);
        t2 = (TextView) findViewById(R.id.no2);
        t3 = (TextView) findViewById(R.id.no3);
        t4 = (TextView) findViewById(R.id.no4);
        t5 = (TextView) findViewById(R.id.no5);
        t6 = (TextView) findViewById(R.id.no6);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnClickListener(this);
        t6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.no1:
                intent.setClass(this, IpActivity.class);
                startActivity(intent);
                break;
            case R.id.no2:
                intent.setClass(this, DomainQueryActivity.class);
                startActivity(intent);
                break;
            case R.id.no3:
                intent.setClass(this, IdActivity.class);
                startActivity(intent);
                break;
            case R.id.no4:
                intent.setClass(this, PhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.no5:
                intent.setClass(this, RobotActivity.class);
                startActivity(intent);
                break;
            case R.id.no6:
                intent.setClass(this, WordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
