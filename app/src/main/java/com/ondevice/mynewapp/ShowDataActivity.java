package com.ondevice.mynewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ShowDataActivity extends AppCompatActivity {

    TextView txtShowData, tvSpecilCharRm;
    ImageView imgFullInfo;

    String strText, strImage, strFinalOt;
    public static final String abcdd = "abcd";
    public static final String images = "image";

    String strSpecil = "It is a long established fact that a reader will be " +
            "distracted by the # readable @ content ^ of a < > page  =  & $ when looking at its layoutttt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        Intent intent = getIntent();
        strText = intent.getStringExtra(abcdd);
        strImage = intent.getStringExtra(images);


        txtShowData = findViewById(R.id.txtShowData);
        imgFullInfo = findViewById(R.id.imgFullInfo);
        tvSpecilCharRm = findViewById(R.id.tvSpecilCharRm);

        txtShowData.setText(strText);
        Glide.with(this).load(strImage).into(imgFullInfo);

        strFinalOt = strSpecil.replaceAll("\\W+"," ");

        tvSpecilCharRm.setText(strFinalOt);
    }
}