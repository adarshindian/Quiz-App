package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionAnswerView extends AppCompatActivity {

    EditText Ques,ans1,ans2,ans3,ans4, rants;
    Button nantes,submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer_view);
        ArrayList<QuestionModel> Question = new ArrayList<>(3);
        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("“stuff”");
//Extract the data…

        Ques=findViewById(R.id.insQues);
        ans1=findViewById(R.id.insAns1);
        ans2=findViewById(R.id.insAns2);
        ans3=findViewById(R.id.insAns3);
        ans4=findViewById(R.id.insAns4);
        rants =findViewById(R.id.insRytans);
        nantes =findViewById(R.id.insNextQues);
        submit=findViewById(R.id.insSubmit_test);

        nantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkNull(Ques.getText().toString(),ans1.getText().toString(),
                        ans2.getText().toString(),ans3.getText().toString(),
                        ans4.getText().toString(), rants.getText().toString()))//if any value is null then if has true
                {
                    Toast.makeText(QuestionAnswerView.this, "Insert Data in All Field", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(rants.getText().toString())>4||Integer.parseInt(rants.getText().toString())<1)
                {
                    Toast.makeText(QuestionAnswerView.this, "Type 0 to 4 in Answer", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    QuestionModel q=new QuestionModel(Ques.getText().toString(),ans1.getText().toString(),
                            ans2.getText().toString(),ans3.getText().toString(),
                            ans4.getText().toString(),Integer.parseInt(rants.getText().toString()));
                    Question.add(q);
                    Ques.setText("");
                    ans1.setText("");
                    ans2.setText("");
                    ans3.setText("");
                    ans4.setText("");
                    rants.setText("");
                }//
                //All the field set to null so that next question can be taken

            }
        });
    }
    boolean checkNull(String ques,String ans1,String ans2,String ans3,String ans4,String rytans)
    {
        if(ques.isEmpty()||ans1.isEmpty()||ans2.isEmpty()||ans3.isEmpty()||ans4.isEmpty()||rytans.isEmpty())
            return true;
        return false;
    }
}