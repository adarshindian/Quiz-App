package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionAnswerView extends AppCompatActivity {

    EditText Ques,ans1,ans2,ans3,ans4, rants,tst_name;
    Button nantes,submit;
     FirebaseFirestore f=FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer_view);
        List<QuestionModel> Question = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("subject");
//Extract the data…

        Ques=findViewById(R.id.insQues);
        ans1=findViewById(R.id.insAns1);
        ans2=findViewById(R.id.insAns2);
        ans3=findViewById(R.id.insAns3);
        ans4=findViewById(R.id.insAns4);
        rants =findViewById(R.id.insRytans);
        nantes =findViewById(R.id.insNextQues);
        submit=findViewById(R.id.insSubmit_test);
        nantes.setText(stuff);
        tst_name=findViewById(R.id.tst_name);

        nantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




//                DocumentReference docRef= f.collection("Category").document(stuff).collection(tst_name.getText().toString()).document("Question 1");
//                docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                        QuestionModel  q= documentSnapshot.toObject(QuestionModel.class);
//                        Toast.makeText(QuestionAnswerView.this, q.question_text, Toast.LENGTH_SHORT).show();
//                    }});



                if(checkNull(tst_name.getText().toString(),Ques.getText().toString(),ans1.getText().toString(),
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

                    tst_name.setEnabled(false);
                    Ques.setText("");
                    ans1.setText("");
                    ans2.setText("");
                    ans3.setText("");
                    ans4.setText("");
                    rants.setText("");



//                    DocumentReference docRef = db.collection("cities").document("SF");
//                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                        @Override
//                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                            if (task.isSuccessful()) {
//                                DocumentSnapshot document = task.getResult();
//                                if (document.exists()) {
//                                    Log.d(TAG, "DocumentSnapshot data: " + document.getData());
//                                } else {
//                                    Log.d(TAG, "No such document");
//                                }
//                            } else {
//                                Log.d(TAG, "get failed with ", task.getException());
//                            }
//                        }
//                    });

                }//
                //All the field set to null so that next question can be taken

            }
        });
    // QuestionModel q=new QuestionModel("Abcd","a","b","c","d",1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i;
                QuestionModel q;
                for(i=0;i<Question.size();i++) {
//                    Map<String, Object> user = new HashMap<>();
//                    user.put("question_text", Question.get(i).question_text);
//                    user.put("optionOne", Question.get(i).optionOne);
//                    user.put("optionTwo", Question.get(i).optionTwo);
//                    user.put("optionThree", Question.get(i).optionThree);
//                    user.put("optionFour", Question.get(i).optionFour);
//                    user.put("correctAnswer", Question.get(i).correctAnswer);

                    q=Question.get(i);
                    DocumentReference df= f.collection("Category").document(stuff).collection(tst_name.getText().toString()).document("Question"+i);
                    df.set(q).addOnSuccessListener(aVoid ->
                            Log.d("abcdefg", "DocumentSnapshot successfully written!"))
                            .addOnFailureListener(e -> Log.w("TAGabcdefghi", "Error writing document", e));
//                    f.collection("Category").document(stuff).collection(tst_name.getText().toString()).document("Question "+i).set(q).addOnSuccessListener(aVoid ->
//                            Log.d("abcdefg", "DocumentSnapshot successfully written!"))
//                            .addOnFailureListener(e -> Log.w("TAGabcdefghi", "Error writing document", e));
////                    Toast.makeText(QuestionAnswerView.this, Question.get(i).getClass(), Toast.LENGTH_SHORT).show();


            } Question.clear();
                tst_name.setEnabled(true);
                tst_name.setText("");
            }
        });
    }
    boolean checkNull(String tst,String ques,String ans1,String ans2,String ans3,String ans4,String rytans)
    {
        if(tst.isEmpty()||ques.isEmpty()||ans1.isEmpty()||ans2.isEmpty()||ans3.isEmpty()||ans4.isEmpty()||rytans.isEmpty())
            return true;
        return false;
    }
}