package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {
            TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        t1=findViewById(R.id.tktest);
        t2=findViewById(R.id.mktest);
        t2=findViewById(R.id.wtfriends);
        t3=findViewById(R.id.review);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // t1.setBackgroundColor(112233);
                Intent intent = new Intent(DashBoard.this,
                        QuestionActivity.class);
                startActivity(intent);
               // finish();
            }
        });


    }
}