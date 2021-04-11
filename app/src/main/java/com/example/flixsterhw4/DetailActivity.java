package com.example.flixsterhw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvOverview;
    ImageView ivPoster;
    TextView release;

    String strOfTitle;
    String strOfOverview;
    String imageUrl;
    String releaseD;

    RatingBar ratingBar;
    float starRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        ivPoster = (ImageView) findViewById(R.id.ivPoster);
        ratingBar = (RatingBar) findViewById(R.id.star);
        release = (TextView) findViewById(R.id.release);

        ratingBar.setBackgroundColor(Color.WHITE);
        ratingBar.setIsIndicator(true);
        ratingBar.setNumStars(5);

        starRate = getIntent().getFloatExtra("rate", 0);
        ratingBar.setRating(starRate);

        releaseD = getIntent().getStringExtra("release");
        release.setText("Release Date: " + releaseD);
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