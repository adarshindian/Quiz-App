package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {
    QuestionController q = new QuestionController();

    public int res = 0;
    //  TextView tt=findViewById(R.id.namePrint);

    // int clickedOption=1;
    int currenposition = 0;
    int no_of_click = 0;
    //This ArrayLIst  Holds Question and Answer from 0 to 4 by method setQuestion
    ArrayList<TextView> ques_ans = new ArrayList<>(5);

    int correct;
    ProgressBar progress;
    ArrayList<Integer> selected_answer;


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        //Adding Question and answer in TextView Arraylist ques_ans
        //  tt.setText(getIntent().getStringExtra("prin"));
        // progress.setProgress(1);
        ques_ans.add(findViewById(R.id.ques));
        ques_ans.add(findViewById(R.id.ans1));
        ques_ans.add(findViewById(R.id.ans2));
        ques_ans.add(findViewById(R.id.ans3));
        ques_ans.add(findViewById(R.id.ans4));
        //All the question are in
        progress = findViewById(R.id.progress_pro);
        ArrayList<QuestionModel> questionsList = q.getQuestion();
        selected_answer = new ArrayList<>(questionsList.size());
        selected_answer.clear();
        //  selected_answer.add(0);
        progress.setMax(questionsList.size());


        //  int qw=questionsList.size();
        //TextView t=findViewById(R.id.ans4);
        // t.setText(questionsList.get(2).optionFour.toString());
        //Toast.makeText(this,qw,Toast.LENGTH_LONG).show();

//questionsList.get(currenposition);
        optionborder(ques_ans);
        setQuestion(questionsList, ques_ans);


        Button next_question = findViewById(R.id.btn_q);
        next_question.setOnClickListener(new View.OnClickListener() {
            String s;

            @Override
            public void onClick(View v) {

                currenposition++;
                no_of_click = 0;
                int cor;
                //  correct=questionsList.get(currenposition).correctAnswer;
                for (int i = 1; i < 5; i++)
                    ques_ans.get(i).setBackground(getResources().getDrawable(R.drawable.option_border));
                if (currenposition >= questionsList.size()) {
                    int i;
                    currenposition = questionsList.size() - 1;
                    for (i = 0; i < selected_answer.size(); i++) {
                        if (questionsList.get(i).correctAnswer == selected_answer.get(i)) {
                            res++;
                        }
                    }
                    i = 0;
                    int temp=0;
                    s = " " + res + "";
                    // String sc=selected_answer.get(3).toString();
                    //  Toast.makeText(QuestionActivity.this,s,Toast.LENGTH_SHORT).show();
                    // cor=answerCheck(questionsList);
                    // value=res;
//                    Intent intent = new Intent(QuestionActivity.this,
//                            AnswerPrint1.class);
//                    intent.putExtra("print", s);
//                    startActivity(intent);
//                    finish();
                    temp=currenposition+1;
                    MaterialAlertDialogBuilder e = new MaterialAlertDialogBuilder(QuestionActivity.this);
                            e.setTitle("------Your Score-----");
                            e.setMessage("You Got "+s+" Out of "+ temp);
                            e.setCancelable(false);
                            e.setBackground(getResources().getDrawable(R.drawable.correct_answer));

                            e.show();


                } else
                    setQuestion(questionsList, ques_ans);
            }
        });

        ques_ans.get(1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (no_of_click < 1) {
                    correct = questionsList.get(currenposition).correctAnswer;
                    for (int i = 1; i < 5; i++)
                        ques_ans.get(i).setBackground(getResources().getDrawable(R.drawable.option_border));
                    ques_ans.get(1).setBackground(getResources().getDrawable(R.drawable.onclickoption));
                    ques_ans.get(correct).setBackground(getResources().getDrawable(R.drawable.correct_answer));
                    selected_answer.add(1);
                }
                no_of_click++;

            }
        });

//        ques_ans.get(4).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ques_ans.get(1).setBackground(getResources().getDrawable(R.drawable.option_border));
//                ques_ans.get(2).setBackground(getResources().getDrawable(R.drawable.option_border));
//                ques_ans.get(3).setBackground(getResources().getDrawable(R.drawable.option_border));
//                ques_ans.get(4).setBackground(getResources().getDrawable(R.drawable.onclickoption));
//            }
//        });
        ques_ans.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (no_of_click < 1) {
                    correct = questionsList.get(currenposition).correctAnswer;
                    for (int i = 1; i < 5; i++)
                        ques_ans.get(i).setBackground(getResources().getDrawable(R.drawable.option_border));
                    ques_ans.get(2).setBackground(getResources().getDrawable(R.drawable.onclickoption));
                    ques_ans.get(correct).setBackground(getResources().getDrawable(R.drawable.correct_answer));
                    selected_answer.add(2);
                }

                no_of_click++;

            }
        });
        ques_ans.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (no_of_click < 1) {
                    correct = questionsList.get(currenposition).correctAnswer;
                    for (int i = 1; i < 5; i++)
                        ques_ans.get(i).setBackground(getResources().getDrawable(R.drawable.option_border));
                    ques_ans.get(3).setBackground(getResources().getDrawable(R.drawable.onclickoption));
                    ques_ans.get(correct).setBackground(getResources().getDrawable(R.drawable.correct_answer));
                    selected_answer.add(3);
                }
                no_of_click++;

            }
        });
        ques_ans.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (no_of_click < 1) {
                    correct = questionsList.get(currenposition).correctAnswer;
                    for (int i = 1; i < 5; i++)
                        ques_ans.get(i).setBackground(getResources().getDrawable(R.drawable.option_border));
                    ques_ans.get(4).setBackground(getResources().getDrawable(R.drawable.onclickoption));
                    ques_ans.get(correct).setBackground(getResources().getDrawable(R.drawable.correct_answer));
                    selected_answer.add(4);
                }
                no_of_click++;


            }
        });


    }

    void setQuestion(ArrayList<QuestionModel> questionsList, ArrayList<TextView> ques) {        // TextView corectans=findViewById(R.id.);

        progress.setProgress(currenposition + 1);
        ques.get(0).setText(currenposition+1 +"- "+ questionsList.get(currenposition).question_text.toString());
        ques.get(1).setText(questionsList.get(currenposition).optionOne.toString());
        ques.get(2).setText(questionsList.get(currenposition).optionTwo.toString());
        ques.get(3).setText(questionsList.get(currenposition).optionThree.toString());
        ques.get(4).setText(questionsList.get(currenposition).optionFour.toString());

    }

    void optionborder(ArrayList<TextView> ques) {


        //  for(TextView i:ans)

        ques.get(1).setBackground(getResources().getDrawable(R.drawable.option_border));
        ques.get(2).setBackground(getResources().getDrawable(R.drawable.option_border));
        ques.get(3).setBackground(getResources().getDrawable(R.drawable.option_border));
        ques.get(4).setBackground(getResources().getDrawable(R.drawable.option_border));

    }

    int answerCheck(ArrayList<QuestionModel> questionsList) {
        return questionsList.get(3).correctAnswer / selected_answer.get(1);

    }

    public void initAns1(View view) {
//        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
//        if (view instanceof TextView) {
//            TextView t = (TextView) view;
//            t.setText("Changed"+t.getId());
//        }
    }

//    void optioncl(View v)
//    {
//        Toast.makeText(QuestionActivity.this,"Hello",Toast.LENGTH_SHORT).show();
//    }


}