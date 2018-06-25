package com.project.sooraj.qunoidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class ProfileViewAcitvity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view_acitvity);
        imageView=(ImageView)findViewById(R.id.imagebanner);
        TextView textView=(TextView) findViewById(R.id.username);
        TextView textView1=(TextView) findViewById(R.id.bio);
        if(getIntent().getStringExtra("url")!=null){
            Glide.with(getApplicationContext()).load(getIntent().getStringExtra("url")).apply(new RequestOptions().transform(new RoundedCorners(16)).override(100, 100)).into(imageView);
            textView.setText(getIntent().getStringExtra("name"));
            textView1.setText(getIntent().getStringExtra("bio"));
        }
    }
}
