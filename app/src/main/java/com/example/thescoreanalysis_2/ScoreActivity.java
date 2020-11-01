package com.example.thescoreanalysis_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static android.widget.Toast.*;
import static com.example.thescoreanalysis_2.R.*;
import static com.example.thescoreanalysis_2.R.id.*;

public class ScoreActivity extends AppCompatActivity {
    //Button1
    private ImageButton score_Btn;
    private Button mBtn;
    private TextView mText;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //获取数据并在textview里显示成绩数据
        Intent intentget = getIntent();
        String datamath= intentget.getStringExtra("math");
        String dataenglish= intentget.getStringExtra("english");
        String datacomputer= intentget.getStringExtra("computer");
        String datatechnique= intentget.getStringExtra("technique");
        String sec= intentget.getStringExtra("sec");
        String fir= intentget.getStringExtra("fir");
        String fou= intentget.getStringExtra("fou");
        String thi= intentget.getStringExtra("thi");
        mText = (TextView)findViewById(mathP);
        mText.setText(datamath);
        mText = (TextView)findViewById(englishP);
        mText.setText(dataenglish);
        mText = (TextView)findViewById(computerP);
        mText.setText(datacomputer);
        mText = (TextView)findViewById(techniqueP);
        mText.setText(datatechnique);
        mText = (TextView)findViewById(mathAnnounce);
        mText.setText(sec);
        mText = (TextView)findViewById(englishAnnounce);
        mText.setText(fir);
        mText = (TextView)findViewById(computerAnnounce);
        mText.setText(fou);
        mText = (TextView)findViewById(thchniqueAnnounce);
        mText.setText(thi);

        //学分,绩点de显示
        Double math = Double.parseDouble(datamath);
        Double mathJ = math/20;
        Double english = Double.parseDouble(dataenglish);
        Double englishJ = english/20;
        Double computer = Double.parseDouble(datacomputer);
        Double computerJ = computer/20;
        Double technique = Double.parseDouble(datatechnique);
        Double techniqueJ = technique/20;
        Double total = (math+english+computer+technique)/4;
        Double totalJ = total/20;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String totalC =decimalFormat.format(total);
        String totalJC =decimalFormat.format(totalJ);


        //CharSequence totalC = String.valueOf(total);        //C代表字符数据，J代表绩点
        //CharSequence totalJC = String.valueOf(totalJ);
        CharSequence mathC = String.valueOf(mathJ);
        CharSequence englishC = String.valueOf(englishJ);
        CharSequence techniqueC = String.valueOf(techniqueJ);
        CharSequence computerC = String.valueOf(computerJ);
        
        String wdJudge = null;  //稳定性
        if(total>=80){
            wdJudge="优秀";
        }else if(total<80&&total>=60){
            wdJudge="良好";
        }else if(total<60){
            wdJudge="一般";
        }

        String pjJudge = null;     //评级
        if(total>=90&&total<100){
            pjJudge="A+";
        }else if(total<90&&total>=80){
            pjJudge="A";
        }else if(total<80&&total>=70){
            pjJudge="B+";
        }else if(total<70&&total>=60){
            pjJudge="B";
        }else  if(total<60){
            pjJudge="C";
        }else if(total==100){
            pjJudge="SSS";
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
                b[i]="A+";
            }else if(score<90&&score>=80){
                b[i]="A";
            }else if(score<80&&score>=70){
                b[i]="B+";
            }else if(score<70&&score>=60){
                b[i]="B";
            }else  if(score<60){
                b[i]="C";
            }else if(score==100){
                b[i]="SSS";
            }
        }

        mText =(TextView) findViewById(id.total);
        mText.setText(totalC);  //总学分
        mText = (TextView)findViewById(R.id.totalSec);
        mText.setText(totalC);  //总学分
        mText =(TextView) findViewById(R.id.jdtext);
        mText.setText(totalJC); //总绩点
        mText =(TextView) findViewById(R.id.mathJ);
        mText.setText(mathC);   //数学绩点
        mText =(TextView) findViewById(R.id.englishJ);
        mText.setText(englishC);   //英语绩点
        mText =(TextView) findViewById(id.techniqueJ);
        mText.setText(techniqueC);   //技术导论绩点
        mText =(TextView) findViewById(id.computerJ);
        mText.setText(computerC);   //程序设计绩点
        
        mText = (TextView) findViewById(R.id.wdJudge);
        mText.setText(wdJudge);
        mText = (TextView) findViewById(R.id.pjJudge);
        mText.setText(pjJudge);

        mText = (TextView) findViewById(R.id.mathJudge);
        mText.setText(b[0]);
        mText = (TextView) findViewById(R.id.englishJudge);
        mText.setText(b[1]);
        mText = (TextView) findViewById(R.id.computerJudge);
        mText.setText(b[2]);
        mText = (TextView) findViewById(R.id.techniqueJudge);
        mText.setText(b[3]);


        //Button1
        score_Btn = (ImageButton) findViewById(jumpToLast);
        score_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this,InputActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //Button2
        score_Btn = (ImageButton)findViewById(jumpToNext);
        score_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(ScoreActivity.this,SuggestionActivity.class);
                intent2.putExtra("totalC", totalC);
                intent2.putExtra("fir", fir);
                intent2.putExtra("sec", sec);
                intent2.putExtra("thi", thi);
                intent2.putExtra("fou", fou);
                intent2.putExtra("math", datamath);
                intent2.putExtra("english", dataenglish);
                intent2.putExtra("computer", datacomputer);
                intent2.putExtra("technique", datatechnique);
                if (TextUtils.isEmpty(totalC)) {
                    Toast.makeText(ScoreActivity.this, "Please input or reinput the score", Toast.LENGTH_SHORT).show();
                } else startActivity(intent2);
            }
        });
    }
}

