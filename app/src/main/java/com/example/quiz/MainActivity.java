package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.btn);
        EditText et=findViewById(R.id.name);
        btn.setOnClickListener( new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v) {
                                        if(et.getText().toString().isEmpty())
                                        Toast.makeText(MainActivity.this,"Enter Some Text",Toast.LENGTH_LONG).show();
                                        else
                                        {
                                            Intent intent = new Intent(MainActivity.this,
                                                    QuestionActivity.class);
                                            startActivity(intent);
                                            finish();
//                                            Intent intent = new Intent(QuestionActivity.this,
//                                                    AnswerPrint1.class);
//                                            intent.putExtra("print",s);
//                                            startActivity(intent);
//                                            finish();
                                        }
                                    }
                                }
        );
    }
}