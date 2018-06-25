package com.project.sooraj.qunoidapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageViewActivity extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView=(ImageView)findViewById(R.id.imagebanner);
        TextView textView=(TextView) findViewById(R.id.bio);
        if(getIntent().getStringExtra("url")!=null){
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("url")).apply(new RequestOptions().override(600, 140)).into(imageView);
            textView.setText(getIntent().getStringExtra("bio"));

        }
    }
}
