package com.example.materialtest;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.security.PublicKey;

public class DetailsActivity extends AppCompatActivity {

    public static final String IMAGE_NAME = "image_name";
    public static final String IMAGE_PATH = "image_path";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String name = getIntent().getStringExtra(IMAGE_NAME);
        String path = getIntent().getStringExtra(IMAGE_PATH);

        ImageView imageView = (ImageView) findViewById(R.id.iv_image);
        TextView textView = (TextView) findViewById(R.id.tv_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(name);
        Glide.with(this).load(path).into(imageView);
        String details = getDetails(name);
        textView.setText(details);
    }

    private String getDetails(String name) {
        StringBuilder details = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            details.append(name);
        }
        return details.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
