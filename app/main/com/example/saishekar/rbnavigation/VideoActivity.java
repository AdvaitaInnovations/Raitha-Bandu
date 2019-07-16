package com.example.saishekar.rbnavigation;

//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ImageView;
//
//import com.squareup.picasso.Picasso;
//
//import com.google.android.youtube.player.YouTubeInitializationResult;
//import com.google.android.youtube.player.YouTubeThumbnailLoader;
//import com.google.android.youtube.player.YouTubeThumbnailView;
//
//import android.os.Bundle;
//import android.app.Activity;
//import android.widget.Toast;
//
//public class Youtube_video_thumbnailActivity extends Activity
//        implements YouTubeThumbnailView.OnInitializedListener{
//
//    public static final String DEVELOPER_KEY ="AIzaSyCN-osGJSEf3wkDCZTDFgiXGt7pMqsnPuc";
//    private static final String VIDEO_ID ="XPmxQBS4nd0";
//
//    private YouTubeThumbnailLoader youTubeThumbnailLoader;
//    private YouTubeThumbnailView thumbnailView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_youtube_video);
//
//        thumbnailView = (YouTubeThumbnailView)findViewById(R.id.thumbnailview);
//        thumbnailView.initialize(DEVELOPER_KEY, this);
//    }
//
//    @Override
//    public void onInitializationFailure(YouTubeThumbnailView thumbnailView,
//                                        YouTubeInitializationResult errorReason) {
//
//        String errorMessage =
//                String.format("onInitializationFailure (%1$s)",
//                        errorReason.toString());
//        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onInitializationSuccess(YouTubeThumbnailView thumbnailView,
//                                        YouTubeThumbnailLoader thumbnailLoader) {
//
//        Toast.makeText(getApplicationContext(),
//                "onInitializationSuccess", Toast.LENGTH_SHORT).show();
//
//        youTubeThumbnailLoader = thumbnailLoader;
//        thumbnailLoader.setOnThumbnailLoadedListener(new ThumbnailListener());
//
//        youTubeThumbnailLoader.setVideo(VIDEO_ID);
//    }
//
//    private final class ThumbnailListener implements
//            YouTubeThumbnailLoader.OnThumbnailLoadedListener {
//
//        @Override
//        public void onThumbnailLoaded(YouTubeThumbnailView thumbnail, String videoId) {
//            Toast.makeText(getApplicationContext(),
//                    "onThumbnailLoaded", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onThumbnailError(YouTubeThumbnailView thumbnail,
//                                     YouTubeThumbnailLoader.ErrorReason reason) {
//            Toast.makeText(getApplicationContext(),
//                    "onThumbnailError", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//}


import com.example.saishekar.rbnavigation.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;

public class VideoActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener{

    public static final String DEVELOPER_KEY = "AIzaSyCN-osGJSEf3wkDCZTDFgiXGt7pMqsnPuc";
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(DEVELOPER_KEY, this);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer (%1$s)",
                    errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {

        if (!wasRestored) {
            player.cueVideo("XPmxQBS4nd0");
        }
    }

}