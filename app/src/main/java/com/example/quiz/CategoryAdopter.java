
package com.example.quiz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.quiz.Category;

import java.util.ArrayList;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class CategoryAdopter extends BaseAdapter {

    private Context context;
    private  int layout;
    private  ArrayList<Category> categoryList;

    public CategoryAdopter(Context context, int layout, ArrayList<Category>category)
    {
        this.context = context;
        this.layout = layout;
        this.categoryList= category;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }


    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView name;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.namofitem, null);
            holder.name = (TextView) row.findViewById(R.id.txtCat);
            holder.imageView =(ImageView)row.findViewById(R.id.imgCat);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Category category = categoryList.get(position);

        holder.name.setText(category.getName());
      //  holder.txtPrice.setText(food.getPrice());

        //byte[] foodImage = category.getImage();
       // Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.imageView.setImageResource(category.getImage());

        return row;
    }
}