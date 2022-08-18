package com.ondevice.mynewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ShowDataActivity extends AppCompatActivity {

    TextView txtShowData;
    ImageView imgFullInfo;

    String strText, strImage;
    public static final String abcdd = "abcd";
    public static final String images = "image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        Intent intent = getIntent();
        strText = intent.getStringExtra(abcdd);
        strImage = intent.getStringExtra(images);


        txtShowData = findViewById(R.id.txtShowData);
        txtShowData.setText(strText);
        imgFullInfo = findViewById(R.id.imgFullInfo);
        Glide.with(this).load(strImage).into(imgFullInfo);

    }
}