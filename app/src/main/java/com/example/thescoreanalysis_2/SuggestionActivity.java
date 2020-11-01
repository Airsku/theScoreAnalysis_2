package com.example.thescoreanalysis_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.thescoreanalysis_2.R.id.suggestion;
import static com.example.thescoreanalysis_2.R.id.techniqueP;

public class SuggestionActivity extends AppCompatActivity {
    private ImageButton mBtn;
    private  TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        //接收成绩数据
        Intent intentget = getIntent();
        String totalC= intentget.getStringExtra("totalC");
        String datamath= intentget.getStringExtra("math");
        String dataenglish= intentget.getStringExtra("english");
        String datacomputer= intentget.getStringExtra("computer");
        String datatechnique= intentget.getStringExtra("technique");
        String sec= intentget.getStringExtra("sec");
        String fir= intentget.getStringExtra("fir");
        String fou= intentget.getStringExtra("fou");
        String thi= intentget.getStringExtra("thi");

        //转换数据
        Double total = Double.parseDouble(totalC);
        Double math = Double.parseDouble(datamath);
        Double english = Double.parseDouble(dataenglish);
        Double computer = Double.parseDouble(datacomputer);
        Double technique = Double.parseDouble(datatechnique);

        //判断输出
        String judge=null;
        if(total>=80){
            judge="总的来讲，你的成绩优秀，请继续保持。";
        }else if(total<80&&total>=60){
            judge="总的来讲，你的成绩良好，请再加把劲，争取突破优秀层次。";
        }else if(total<60){
            judge="总的来讲，你的成绩一般，建议在学习上投入更多时间，且多去寻求老师，同学的帮助。";
        }

        double[] a;
        a=new double[4];
        a[0]=math;
        a[1]=english;
        a[2]=computer;
        a[3]=technique;
        String[] b;
        b=new String[4];
        double score;
        int i;
        for(i=0;i<4;i++){
            score=a[i];
            if(score>=90&&score<100){
                b[i]=",你的成绩在90-100间，已经很好了，不过不能懈怠，需要继续保持。\n";
            }else if(score<90&&score>=80){
                b[i]=",你的成绩在80-90间，还有进步的空间，不能懈怠，需要继续加油。\n";
            }else if(score<80&&score>=70){
                b[i]=",你的成绩在70-80间，还有较大的进步的空间，需要继续加油。\n";
            }else if(score<70&&score>=60){
                b[i]=",你的成绩在60-70间，还有非常大的进步的空间，建议调整学习方法，保持学习的状态，早日突破70，达到80以上。\n";
            }else  if(score<60){
                b[i]=",你的成绩不足60，建议先夯实基础，多向老师同学请教，争取早日赶上其他同学。\n";
            }else if(score==100){
                b[i]=",首先恭喜你拿了100分，非常棒，不过不能骄傲哦，“富贵而窖，自遗其咎，继续保持，希望下次你还能拿100分。\n";
            }
        }

        mText = (TextView)findViewById(suggestion);
        mText.setText("对于"+fir+b[1]+"对于"+sec+b[0]+"对于"+thi+b[3]+"对于"+fou+b[2]+"\n"+judge);


        mBtn = findViewById(R.id.jumpToLast);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuggestionActivity.this,ScoreActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}