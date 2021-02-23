package com.example.myProject_HealthyRecipesApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipesActivity extends AppCompatActivity {

    private ImageView imageView_display;
    private TextView textView_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        setTitle("食譜");

        //TODO:action bar 1
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);


        imageView_display = (ImageView) findViewById(R.id.imageView_display) ;
        textView_id = (TextView) findViewById(R.id.textView_display);

        Intent come = this.getIntent();
        int  id = come.getIntExtra("ID", -99);
        switch(id){
            case R.id.imageButton:
                Log.i("哪張圖", "第1張");
                String text_data = getResources().getStringArray(R.array.detail)[0];
                Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.image01);
                imageView_display.setImageBitmap(pic);
                textView_id.setText(text_data);
                break;
            case R.id.imageButton2:
                Log.i("哪張圖", "第2張");
                text_data = getResources().getStringArray(R.array.detail)[1];
                pic = BitmapFactory.decodeResource(getResources(), R.drawable.image02);
                imageView_display.setImageBitmap(pic);
                textView_id.setText(text_data);

                break;
            case R.id.imageButton3:
                Log.i(  "哪張圖", "第3張");
                text_data = getResources().getStringArray(R.array.detail)[2];
                pic = BitmapFactory.decodeResource(getResources(), R.drawable.image03);
                imageView_display.setImageBitmap(pic);
                textView_id.setText(text_data);
                break;
            case R.id.imageButton4:
                Log.i("哪張圖", "第4張");
                text_data = getResources().getStringArray(R.array.detail)[3];
                pic = BitmapFactory.decodeResource(getResources(), R.drawable.image04);
                imageView_display.setImageBitmap(pic);
                textView_id.setText(text_data);
                break;
            case R.id.imageButton5:
                Log.i("哪張圖", "第5張");
                text_data = getResources().getStringArray(R.array.detail)[4];
                pic = BitmapFactory.decodeResource(getResources(), R.drawable.image05);
                imageView_display.setImageBitmap(pic);
                textView_id.setText(text_data);
                break;
            case R.id.imageButton6:
                Log.i("哪張圖", "第6張");
                text_data = getResources().getStringArray(R.array.detail)[5];
                pic = BitmapFactory.decodeResource(getResources(), R.drawable.image06);
                imageView_display.setImageBitmap(pic);
                textView_id.setText(text_data);
                break;
        }

    }

    //TODO:action bar 2
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}