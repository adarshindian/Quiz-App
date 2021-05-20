package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
   private FirebaseFirestore db = FirebaseFirestore.getInstance();
   private FirebaseAuth firebaseauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        EditText et = findViewById(R.id.name);
        EditText pass=findViewById(R.id.pass);
        TextView t=findViewById(R.id.login);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                                Login1.class);
                        startActivity(intent);
            }
        });

        btn.setOnClickListener(v -> {
//                    Map<String, Object> user = new HashMap<>();
//                    user.put("first", "Ada");
//                    user.put("last", "Lovelace");
//                    user.put("born", 1815);
//
//                    db.collection("users").document().set(user, SetOptions.merge()).addOnSuccessListener(aVoid -> {
//                        Toast.makeText(this, "Successdsfjs", Toast.LENGTH_SHORT).show();
//                    }).addOnFailureListener(e -> {
//                        Toast.makeText(this, "Unsuccess", Toast.LENGTH_SHORT).show();
//                    });
                    if (et.getText().toString().isEmpty() ||pass.getText().toString().isEmpty() )
                        Toast.makeText(MainActivity.this, "Enter Some Text", Toast.LENGTH_LONG).show();
                    else if(pass.length()<6)
                        Toast.makeText(this, "Password Should be at Least 6 Character Long", Toast.LENGTH_SHORT).show();
                    else {

                        register(et,pass);
//                        Intent intent = new Intent(MainActivity.this,
//                                QuestionActivity.class);
//                        startActivity(intent);
//                        finish();
//                                            Intent intent = new Intent(QuestionActivity.this,
//                                                    AnswerPrint1.class);
//                                            intent.putExtra("print",s);
//                                            startActivity(intent);
//                                            finish();
                    }
                }
        );
    }

    private void register(EditText et, EditText pass) {
       firebaseauth= FirebaseAuth.getInstance();
        firebaseauth.createUserWithEmailAndPassword(et.getText().toString(),pass.getText().toString()).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(MainActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}