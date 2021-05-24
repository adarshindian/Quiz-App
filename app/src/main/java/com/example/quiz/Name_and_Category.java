package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.Category;
import com.example.quiz.CategoryAdopter;
import com.example.quiz.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Name_and_Category extends AppCompatActivity {
    GridView gridView;

    CategoryAdopter adapter = null;
    ArrayList<Category>show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_and__category);
        FirebaseFirestore f=FirebaseFirestore.getInstance();
        //f.collection("india").document().get().addOnSuccessListener();
        show=new ArrayList<>();
        Category c=new Category("Physics",R.drawable.physics);
        show.add(c);
        c=new Category("Chemistry",R.drawable.chemistry);
        show.add(c);
        c=new Category("Math",R.drawable.math);
        show.add(c);
        c=new Category("Biology",R.drawable.biology);
        show.add(c);
        c=new Category("IC Launcher",R.drawable.ic_launcher_foreground);
        show.add(c);
        c=new Category("Chemistry",R.drawable.chemistry);
        show.add(c);



        //DataBase Activity Success//
//        Map<String, Object> category = new HashMap<>();
//                    category.put("question","What Is PhySics");
//                    category.put("1", "Jai Mata Di");
//                    category.put("2", "Jai Shree Ram");
//                    category.put("3", "Jai Mahakal");
//                    category.put("4", "Jai Mahakal Ji");
//                    category.put("answer","Jai Shree Ram");
//
//                    f.collection("category").document("Physics").collection("Test 1").document("1").set(category).addOnSuccessListener(aVoid -> {
//                        Toast.makeText(this, "Successful insert in Databse", Toast.LENGTH_SHORT).show();
//                    }).addOnFailureListener(e -> {
//                        Toast.makeText(this, "Unsuccessfull insert in Database", Toast.LENGTH_SHORT).show();
//                    });
//
//        f.collection("users").document("Adarsh").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//
//                        Toast.makeText(Name_and_Category.this,  task.getResult().getId(), Toast.LENGTH_SHORT).show();
//                    } else {
//
//                    }
//                } else {
//
//                }
//            }
//        });






        gridView =  findViewById(R.id.gridView);
//        show =MainActivity.databasehelper.fetch();
        adapter = new CategoryAdopter(this,R.layout.activity_name_and__category,show);
        gridView.setAdapter(adapter);
        // show=MainActivity.databasehelper.fetch();
        // String toastText=show.get(1).getName().toString();

        gridView.setOnItemClickListener((parent, view, position, id) -> showDialogue(position));
        adapter.notifyDataSetChanged();
        // Toast.makeText(getApplicationContext(),toastText,Toast.LENGTH_SHORT).show();
    }


    public void showDialogue(int position){
        String s=show.get(position).getName();
       // Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, QuestionAnswerView.class);
      //  AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete);
       // String getrec=textView.getText().toString();

//Create the bundle
        Bundle bundle = new Bundle();

//Add your data to bundle
        bundle.putString("subject", s);

//Add the bundle to the intent
        i.putExtras(bundle);

//Fire that second activity
        startActivity(i);
        finish();
//        Dialog dialogue=new Dialog(FoodList.this);
//        dialogue.setContentView(R.layout.samplemyview);
//        //Getting custom Dialogue Views
//        TextView text_inside=dialogue.findViewById(R.id.text_of_Image);
//        ImageView img_inside=dialogue.findViewById(R.id.image);
//        // int img=show[position];
//
//        Button cancel=dialogue.findViewById(R.id.Cancel);
//
////        String trim = text_inside.get(position).toString().trim();
////        text_inside.setText(String.valueOf(trim));
//        // Integer c=imageids.get(position);
//        // text_inside.setText(String.valueOf(imageids.get(position)).trim());
//        byte[] foodImage = show.get(position).getImage();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
//
//        // String title=getResources().getResourceName();
//        // text_inside.setText(title.substring(title.indexOf("/")+1));
//        img_inside.setImageBitmap(bitmap);
//        dialogue.show();
//        // Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show();
//
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialogue.dismiss();
//            }
//        });

    }

}