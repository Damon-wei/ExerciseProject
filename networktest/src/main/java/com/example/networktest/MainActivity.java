package com.example.networktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    private Button sendRequest;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendRequest = (Button) findViewById(R.id.btn_sendRequest);
        textView = (TextView) findViewById(R.id.text);

        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        HttpURLConnection connection = null;
                        BufferedReader reader = null;
                        try {
                            URL url = new URL("https://www.baidu.com");
                            connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("GET");
                            connection.setConnectTimeout(8000);
                            connection.setReadTimeout(8000);
                            InputStream inputStream = connection.getInputStream();
                            reader = new BufferedReader(new InputStreamReader(inputStream));
                            StringBuilder response = new StringBuilder();
                            String line;
                            while ((line = reader.readLine()) != null){
                                response.append(line);
                            }
                            Log.d("damon==",response.toString());
                            showResponse(response.toString());

                        } catch (Exception e) {
                            Log.d("e==",e.toString());
                            e.printStackTrace();
                        }finally {
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (connection != null) {
                                connection.disconnect();
                            }
                        }
                    }
                }.start();
            }
        });
    }

    private void showResponse(final String string) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("damon===",string);
                textView.setText(string);
            }
        });

    }
}
