package com.ondevice.mynewapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ondevice.mytestmodule.Modules.HeroViewModel;
import com.ondevice.mytestmodule.Modules.TestInfoModel;

public class ShowDataActivity extends AppCompatActivity {

    TextView txtShowData, tvSpecilCharRm;
    ImageView imgFullInfo;

    String strText, strImage, strFinalOt, strPatern;
    public static final String abcdd = "abcd";
    public static final String images = "image";

    String strSpecil = "It is a long N L P established fact that a reader will be " +
            "distracted by the # readable @ content ^ of a < > page  =  & $ when looking at its layouttttabc";

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

        //strPatern = strFinalOt.replaceAll("\\<.*?>", "");

        tvSpecilCharRm.setText(strFinalOt);

        //tvSpecilCharRm.setText(strPatern);

        imgFullInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TestInfoModel model = ViewModelProviders.of(ShowDataActivity.this).get(TestInfoModel.class);
                HeroViewModel model = ViewModelProviders.of(ShowDataActivity.this).get(HeroViewModel.class);
                model.getToastInfo().observe(ShowDataActivity.this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String strName) {
                        Toast.makeText(ShowDataActivity.this, strName, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}