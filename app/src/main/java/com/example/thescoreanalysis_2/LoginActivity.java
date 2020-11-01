package com.example.thescoreanalysis_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private ImageButton mBtn;
    private EditText mET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //jump
        mBtn = findViewById(R.id.firstart);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得数据
                mET = (EditText)findViewById(R.id.account);
                String account= mET.getText().toString().toLowerCase();
                mET = (EditText)findViewById(R.id.passage);
                String passage= mET.getText().toString().toLowerCase();
                String judge="wu123456";

                Intent intent = new Intent(LoginActivity.this,InputActivity.class);
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(LoginActivity.this,"Please input the account",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(passage)){
                    Toast.makeText(LoginActivity.this,"Please input the passage",Toast.LENGTH_SHORT).show();
                }else if(passage.equals(judge)==false) {
                    Toast.makeText(LoginActivity.this,"The passage is wrong,please reinput it"+passage,Toast.LENGTH_SHORT).show();
                }else{
                        startActivity(intent);
                        finish();
                    }
                }

        });
        //qq
        mBtn = findViewById(R.id.qq);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText (LoginActivity.this,"This is unavailable",Toast.LENGTH_SHORT).show();
            }
        });
        //微信
        mBtn = findViewById(R.id.weixin);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText (LoginActivity.this,"This is unavailable",Toast.LENGTH_SHORT).show();
            }
        });
    }
}