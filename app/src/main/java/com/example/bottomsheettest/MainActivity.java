package com.example.bottomsheettest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerControlView;

public class MainActivity extends AppCompatActivity {

    MotionLayout motionLayout;
    LinearLayout swipeLayout;
    PlayerControlView controlView;
    ExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get view's ids
        motionLayout = findViewById(R.id.motion_layout);
        swipeLayout = motionLayout.findViewById(R.id.swipe_layout);
        controlView = motionLayout.findViewById(R.id.controller);
        //Set up player
        player = new ExoPlayer.Builder(this).build();
        controlView.setPlayer(player);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.test_song_0);
        MediaItem item = MediaItem.fromUri(uri);
        player.addMediaItem(item);
        player.prepare();
        player.setPlayWhenReady(true);
        //Config Motion layout
    }
}