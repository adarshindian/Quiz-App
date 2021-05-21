package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {
         private    TextView t1,t2,t3,t4;
        private     CardView t11,t12,t13,t14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
      //  Log.d("checkAct", "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]"+TAG);
        t1=findViewById(R.id.tktest);
        t11=findViewById(R.id.tktestcard);
        t2=findViewById(R.id.mktest);
        t12=findViewById(R.id.mktestcard);
        t3=findViewById(R.id.wtfriends);
        t13=findViewById(R.id.wtfriendscard);
        t4=findViewById(R.id.review);
        t14=findViewById(R.id.reviewcard);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t11.setBackgroundColor(R.drawable.option_border);
                Intent intent = new Intent(DashBoard.this,
                        QuestionActivity.class);
                startActivity(intent);
               // finish();
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t12.setBackgroundColor(R.drawable.option_border);
//                Intent intent = new Intent(DashBoard.this,
//                        QuestionActivity.class);
//                startActivity(intent);
                // finish();
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t13.setBackgroundColor(R.drawable.option_border);
//                Intent intent = new Intent(DashBoard.this,
//                        QuestionActivity.class);
//                startActivity(intent);
                // finish();
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t14.setBackgroundColor(R.drawable.option_border);
//                Intent intent = new Intent(DashBoard.this,
//                        QuestionActivity.class);
//                startActivity(intent);
                // finish();
            }
        });


    }
}