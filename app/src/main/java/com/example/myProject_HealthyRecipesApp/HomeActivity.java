package com.example.myProject_HealthyRecipesApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private Context context;
    private MediaPlayer mediaPlayer;
    private ImageButton imagebutton01,imagebutton02,imagebutton03,imagebutton04,imagebutton05,imagebutton06;
    private Intent intent;
    private ArrayList<Map<String, Object>> itemList;
    private String[] placeList;
    private TypedArray pictureList;
    private ImageView imageView_display;
    private int recipe_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;
        setTitle("首頁");

        findViews();
        setListener();

        mediaPlayer = MediaPlayer.create(this, R.raw.bgm);
        mediaPlayer.start();
    }

    //TODO:監聽bottomNaigation(最下方的action bar)，並設定使用者按下後會跳轉到指定頁面
    private void setListener() {
        bottomNavigation.setItemIconTintList(null);
        bottomNavigation.setItemTextColor(null);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    //回首頁
                    case R.id.homePage:

                        Toast.makeText(context, "回首頁", Toast.LENGTH_SHORT).show();
                        Intent intent_home = new Intent(context, HomeActivity.class);
                        startActivity(intent_home);
                        break;

                    //回個人資訊頁
                    case R.id.user:
                        Toast.makeText(context, "回使用者資訊頁", Toast.LENGTH_SHORT).show();
                        Intent intent_user = new Intent(context, UserInfoActivity.class);
                        startActivity(intent_user);
                        break;

                    //到我的日記頁
                    case R.id.diary:
                        Toast.makeText(context, "我的日記", Toast.LENGTH_SHORT).show();
                        Intent intent_diary = new Intent(context, DiaryActivity.class);
                        startActivity(intent_diary);
                        break;

                } //end switch

                return true;
            } //end onNavigationItemSelected
        }); //end bottomNavigation listener

    } //end setListener


    //TODO:找到元件 -> findViews()
    private void findViews() {
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        imagebutton01 =(ImageButton) findViewById(R.id.imageButton);
        imagebutton01.setOnClickListener(new Mybutton());
        imagebutton02 =(ImageButton) findViewById(R.id.imageButton2);
        imagebutton02.setOnClickListener(new Mybutton());
        imagebutton03 =(ImageButton) findViewById(R.id.imageButton3);
        imagebutton03.setOnClickListener(new Mybutton());
        imagebutton04 =(ImageButton) findViewById(R.id.imageButton4);
        imagebutton04.setOnClickListener(new Mybutton());
        imagebutton05 =(ImageButton) findViewById(R.id.imageButton5);
        imagebutton05.setOnClickListener(new Mybutton());
        imagebutton06 =(ImageButton) findViewById(R.id.imageButton6);
        imagebutton06.setOnClickListener(new Mybutton());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_music:
                mediaPlayer.pause();

                return super.onOptionsItemSelected(item);
        }

        return false;
    }

    private class Mybutton implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            SharedPreferences recipe= getSharedPreferences("recipe",MODE_PRIVATE);
            Intent go = new Intent(HomeActivity.this, RecipesActivity.class);
            switch (v.getId())
            {
                case R.id.imageButton:
                    recipe_id=R.drawable.image01;

                    go.putExtra("ID", v.getId());

                    break;
                case R.id.imageButton2:
                    recipe_id=R.drawable.image02;

                    go.putExtra("ID", v.getId());

                    break;
                case R.id.imageButton3:
                    recipe_id=R.drawable.image03;

                    go.putExtra("ID", v.getId());

                    break;
                case R.id.imageButton4:
                    recipe_id=R.drawable.image04;

                    go.putExtra("ID", v.getId());

                    break;
                case R.id.imageButton5:
                    recipe_id=R.drawable.image05;

                    go.putExtra("ID", v.getId());

                    break;
                case R.id.imageButton6:
                    recipe_id=R.drawable.image06;

                    go.putExtra("ID", v.getId());

                    break;
            }
            startActivity(go);
            recipe.edit().putInt("recipe_id",recipe_id)
                    .commit();


        }
    }//end MyButton()
}