package com.example.thescoreanalysis_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    private Button input_Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        input_Btn = (Button)findViewById(R.id.mainRBtnJump);
        input_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputActivity.this,ScoreActivity.class);
                startActivity(intent);
            }
        });
    }
}