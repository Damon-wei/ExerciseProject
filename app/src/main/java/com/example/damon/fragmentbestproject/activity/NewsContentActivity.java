package com.example.damon.fragmentbestproject.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.damon.fragmentbestproject.R;
import com.example.damon.fragmentbestproject.fragment.NewsContentFragment;

public class NewsContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        NewsContentFragment fragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        fragment.refresh(title,content);

    }
    public static void actionStart(Context context,String title,String content){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        context.startActivity(intent);
    }

}
