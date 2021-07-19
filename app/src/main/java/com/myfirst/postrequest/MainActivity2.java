package com.myfirst.postrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView mTvTitle,mTvEmail,mTvRequestType,mTvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
    }

    private void initViews() {
        mTvTitle = findViewById(R.id.tvTitle);
        mTvEmail = findViewById(R.id.tvEmail);
        mTvRequestType = findViewById(R.id.tvRequestType);
        mTvId = findViewById(R.id.tvId);
        setData();
    }

    private void setData() {
        mTvTitle.setText(getIntent().getStringExtra("title"));
        mTvEmail.setText(getIntent().getStringExtra("email"));
        mTvRequestType.setText(getIntent().getStringExtra("requestType"));
        mTvId.setText(getIntent().getStringExtra("id"));
    }
}