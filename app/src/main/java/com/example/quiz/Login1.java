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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login1 extends AppCompatActivity {
    private FirebaseAuth fire;
  //  private static final String TAG = "Login1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        EditText pass1et=findViewById(R.id.pass1);
        EditText email=findViewById(R.id.name1);
        Button btn=findViewById(R.id.btn1);
        TextView t=findViewById(R.id.login1);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login1.this,
                               MainActivity.class);
                        startActivity(intent);

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCheck(email,pass1et);
            }


        });
    }
    private void loginCheck(EditText email, EditText pass1et) {


        Intent intent = new Intent(Login1.this,
                DashBoard.class);
        startActivity(intent);
        finish();
        fire=FirebaseAuth.getInstance();
        fire.signInWithEmailAndPassword(email.getText().toString(),pass1et.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
              //  Log.d("checkAct", "Login onSuccess() called with: authResult = [" + authResult + "]"+TAG);
                Toast.makeText(Login1.this, "Successfully Login", Toast.LENGTH_SHORT).show();

            }

        });
    }
}