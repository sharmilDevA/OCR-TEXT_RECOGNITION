package com.example.textdetectionsample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
AppCompatButton[] button = new AppCompatButton[3];
AppCompatTextView gnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        try {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
            }

            int[] buttonIds = {R.id.camer, R.id.detect, R.id.capture};
            Class[] activities = {MainActivity.class, ImageActivity.class, DetectActivity.class};
            for (int i = 0; i < button.length; i++) {
                button[i] = findViewById(buttonIds[i]);
                final Class activity = activities[i];
                button[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LoginActivity.this, activity);
                        startActivity(intent);
                    }
                });
            }
        }catch (Exception ignored){}

       /* gnumber = findViewById(R.id.text);
        int[] arr = {10,20,30,4, 100};
        int gnm = arr[0];

        for (int a = 1; a < arr.length; a++) {
            if (arr[a] > gnm) {
                gnm = arr[a];
            }
        }
        //int n = Arrays.stream(arr).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for(int b=0;b<arr.length;b++){
            list.add(arr[b]);
        }
        gnumber.setText(String.valueOf(gnm + "        "+ Collections.max(list)));*/


        /*int MDarr[][] = {{1,2,3,4},{1,1,1,1},{2,2,2,2}};
        for(int a =0;a<MDarr.length;a++){
            for (int b=0;b<MDarr[a].length;b++){
                gnumber.setText(String.valueOf(MDarr[a][b]));
            }
        }*/

    }
}
