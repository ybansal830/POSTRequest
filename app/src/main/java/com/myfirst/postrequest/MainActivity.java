package com.myfirst.postrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mEtEmail, mEtPassword, mEtTitle, mEtRequestType;
    private Button mBtnSubmit;
    private RequestBody requestBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void setRequestBody() {
        requestBody = new RequestBody(mEtEmail.getText().toString(), mEtPassword.
                getText().toString(), mEtTitle.getText().toString(), mEtRequestType.getText().toString());
        callApi();
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mEtTitle = findViewById(R.id.etTitle);
        mEtRequestType = findViewById(R.id.etRequestType);
        mBtnSubmit = findViewById(R.id.btnSubmit);
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRequestBody();
            }
        });
    }

    private void callApi() {
        ApiServices apiServices = Network.getInstance().create(ApiServices.class);
        apiServices.postData(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("title", mEtTitle.getText().toString());
                intent.putExtra("email", mEtEmail.getText().toString());
                intent.putExtra("requestType", mEtRequestType.getText().toString());
                intent.putExtra("id", response.body().getId() + "");
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}