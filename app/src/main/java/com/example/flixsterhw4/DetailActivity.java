package com.example.flixsterhw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvOverview;
    ImageView ivPoster;

    String strOfTitle;
    String strOfOverview;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        ivPoster = (ImageView) findViewById(R.id.ivPoster);

        strOfTitle = getIntent().getStringExtra("title");
        tvTitle.setText(strOfTitle);
        strOfOverview = getIntent().getStringExtra("overview");
        tvOverview.setText(strOfOverview);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            imageUrl = getIntent().getStringExtra("backdrop");
        }
        else {
            // In the portrait mode
            imageUrl = getIntent().getStringExtra("poster");
        }

        Glide.with(this).load(imageUrl).into(ivPoster);

    }
}