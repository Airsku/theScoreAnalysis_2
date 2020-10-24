package com.example.thescoreanalysis_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class concreatScore_Activity extends AppCompatActivity {
    private Button score_Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concreat_score_);

        //Button1
        score_Btn = findViewById(R.id.scoreRBtnJumpto1);
        score_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(concreatScore_Activity.this,ScoreActivity.class);
                startActivity(intent);
            }
        });
    }
}