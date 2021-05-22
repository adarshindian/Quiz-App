package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
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

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class Name_and_Category extends AppCompatActivity {
    GridView gridView;

    CategoryAdopter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_and__category);

        ArrayList<com.example.quiz.Category>show=new ArrayList<>();
        Category c=new Category("Physics",R.drawable.physics);
        show.add(c);
        c=new Category("Chemistry",R.drawable.chemistry);
        show.add(c);


        gridView =  findViewById(R.id.gridView);
//        show =MainActivity.databasehelper.fetch();
        adapter = new CategoryAdopter(this,R.layout.activity_name_and__category,show);
        gridView.setAdapter(adapter);
        // show=MainActivity.databasehelper.fetch();
        // String toastText=show.get(1).getName().toString();
        adapter.notifyDataSetChanged();
        gridView.setOnItemClickListener((parent, view, position, id) -> showDialogue(position));
        // Toast.makeText(getApplicationContext(),toastText,Toast.LENGTH_SHORT).show();
    }


    public void showDialogue(int position){
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