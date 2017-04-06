package com.example.materialtest;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FloatingActionButton btnFloat;
    private RecyclerView recyclerView;
    private ImageAdapter imageAdapter;
    private List<Image> imageList = new ArrayList<>();
    private Image[] images = {
            new Image("草莓","http://img3.imgtn.bdimg.com/it/u=903670219,3644649612&fm=23&gp=0.jpg"),
            new Image("葡萄","http://img1.imgtn.bdimg.com/it/u=1752659599,826217934&fm=23&gp=0.jpg"),
            new Image("橙子","http://img5.imgtn.bdimg.com/it/u=2017869028,3783550037&fm=23&gp=0.jpg"),
            new Image("石榴","http://img4.imgtn.bdimg.com/it/u=1076910493,2722778409&fm=23&gp=0.jpg"),
            new Image("柠檬","http://img1.imgtn.bdimg.com/it/u=8325729,2650146730&fm=23&gp=0.jpg"),
    };
    private SwipeRefreshLayout swipe_refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        btnFloat = (FloatingActionButton) findViewById(R.id.btn_float);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        swipe_refresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_view_headline_black_24dp);
        }
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });
        btnFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Buy Buy Buy",Snackbar.LENGTH_SHORT)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                T.showShort(MainActivity.this,"Nice");
                            }
                        }).show();
            }
        });
        initImages();
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        imageAdapter = new ImageAdapter(this,imageList);
        recyclerView.setAdapter(imageAdapter);
        swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    private void refresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initImages();
                        imageAdapter.notifyDataSetChanged();
                        swipe_refresh.setRefreshing(false);
                    }
                });

            }
        }).start();
    }

    private void initImages() {
        imageList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(images.length);
            imageList.add(images[index]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                T.showShort(this,"You clicked Backup");
                break;
            case R.id.delete:
                T.showShort(this,"You clicked Delete");
                break;
            case R.id.setting:
                T.showShort(this,"You clicked Setting");
                break;
        }
        return true;
    }
}
