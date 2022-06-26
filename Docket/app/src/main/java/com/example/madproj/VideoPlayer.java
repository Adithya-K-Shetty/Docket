package com.example.madproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class VideoPlayer extends AppCompatActivity {
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                Bundle bundle = getIntent().getBundleExtra("allCourseData");
                //Gets The CourseName From The Bundler
                String courseName = bundle.getString("courseName");
                //Gets The VideoId From The Bundler
                String videoId = bundle.getString("videoId");
                //Gets The Organiser Name From The Bundler
                String organiser = bundle.getString("courseOrganization");
                youTubePlayer.loadVideo(videoId, 0);

                /* Above Data Can Be Added To An Text View With .setText Property */
            }
        });
    }
    @Override
    public void onBackPressed() {
        //Execute your code here
        youTubePlayerView.release();
        finish();

    }
}