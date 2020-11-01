package com.example.thescoreanalysis_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    private ImageButton input_Btn;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);



        input_Btn = (ImageButton) findViewById(R.id.mainRBtnJump);
        input_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取edittext中的数据
                //数学成绩
                editText = findViewById(R.id.mainETmath);
                String math = editText.getText().toString();
                //英语成绩
                editText = findViewById(R.id.mainETEnglish);
                String english = editText.getText().toString();
                //程序设计
                editText = findViewById(R.id.mainETComputer);
                String computer = editText.getText().toString();
                //技术导论
                editText = findViewById(R.id.mainETTechnique);
                String technique = editText.getText().toString();

                editText = findViewById(R.id.mainTVEnglish);
                String fir = editText.getText().toString();
                editText = findViewById(R.id.mainTVMath);
                String sec = editText.getText().toString();
                editText = findViewById(R.id.mainTVTTechnique);
                String thi = editText.getText().toString();
                editText = findViewById(R.id.mainTVComputer);
                String fou = editText.getText().toString();


                double mathJ = 0, englishJ = 0, computerJ = 0, techniqueJ = 1;
                if (!(TextUtils.isEmpty(math) || TextUtils.isEmpty(english) || TextUtils.isEmpty(technique) || TextUtils.isEmpty(computer))) {
                    mathJ = Double.parseDouble(math);    //数据转换
                    englishJ = Double.parseDouble(english);
                    computerJ = Double.parseDouble(computer);
                    techniqueJ = Double.parseDouble(technique);
                }

                //活动跳转及数据传送
                Intent intent = new Intent(InputActivity.this, ScoreActivity.class);
                intent.putExtra("math", math);
                intent.putExtra("english", english);
                intent.putExtra("computer", computer);
                intent.putExtra("technique", technique);
                intent.putExtra("fir", fir);
                intent.putExtra("sec", sec);
                intent.putExtra("thi", thi);
                intent.putExtra("fou", fou);
                if (TextUtils.isEmpty(math) || TextUtils.isEmpty(english) || TextUtils.isEmpty(technique) || TextUtils.isEmpty(computer)
                ) {
                    Toast.makeText(InputActivity.this, "Please input the scores", Toast.LENGTH_SHORT).show();
                } else if (mathJ > 100 || englishJ > 100 || computerJ > 100 || techniqueJ > 100) {
                    Toast.makeText(InputActivity.this, "Please reinput the scores", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(fou) || TextUtils.isEmpty(thi) || TextUtils.isEmpty(sec) || TextUtils.isEmpty(fir)) {
                    Toast.makeText(InputActivity.this, "Please input the names", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}