package com.mionix.teststream

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory


class MainActivity : AppCompatActivity() {
    private lateinit var playerView : PlayerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerView = findViewById(R.id.video_view)
        initializePlayer();
//        val uri = Uri.parse("https://www.youtube.com/embed/8Lq3HyBCuAA")
//
//        val intent = Intent(Intent.ACTION_VIEW, uri)
//        intent.setDataAndType(uri, "video/mp4")
//        startActivity(intent)
//        val videoView = findViewById<VideoView>(R.id.video_view)
//
//        videoView.setVideoPath("https://www.youtube.com/embed/8Lq3HyBCuAA")
//        val mediaController = MediaController(this)
//        videoView.setMediaController(mediaController)
//        mediaController.setAnchorView(videoView)


    }
    private fun initializePlayer() {
        val filePath = "https://32e353e0a663.ngrok.io/static/mclaren.mp4?id=1"
        val uri = Uri.parse(filePath)

        val dataSourceFactory: DataSource.Factory = DefaultHttpDataSourceFactory()
// Create a progressive media source pointing to a stream uri.
// Create a progressive media source pointing to a stream uri.
        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(uri))
// Create a player instance.
// Create a player instance.
        val player = SimpleExoPlayer.Builder(this@MainActivity).build()
// Set the media source to be played.
// Set the media source to be played.
        player.setMediaSource(mediaSource)
// Prepare the player.
// Prepare the player.
        player.prepare()
        playerView.player = player

    }
}