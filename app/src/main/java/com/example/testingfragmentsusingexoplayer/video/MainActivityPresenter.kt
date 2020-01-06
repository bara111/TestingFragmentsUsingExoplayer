package com.example.testingfragmentsusingexoplayer.video

import android.content.Context
import android.net.Uri
import com.example.testingfragmentsusingexoplayer.R
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.LoadControl
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class MainActivityPresenter : MainActivityContract.Presenter {
    private var exoPlayer: SimpleExoPlayer? = null
    override fun initializePlayer(exoPlayerView: SimpleExoPlayerView, context: Context?) {
        if (this.exoPlayer == null) {
            val trackSelector: TrackSelector = DefaultTrackSelector()
            val loadControl: LoadControl = DefaultLoadControl()
            exoPlayer = ExoPlayerFactory.newSimpleInstance(context, trackSelector, loadControl)
            exoPlayer?.seekTo(0)
            exoPlayerView.player = exoPlayer
            val userAgent =
                Util.getUserAgent(context, "FragmentApp")
            val mediaSource: MediaSource = ExtractorMediaSource(
                Uri.parse(context?.getString(R.string.video_url)),
                DefaultDataSourceFactory(context, userAgent),
                DefaultExtractorsFactory(), null, null
            )
            exoPlayer?.prepare(mediaSource)
            exoPlayer?.playWhenReady = false
        }
    }

    override fun releasePlayer() {
        if (exoPlayer != null) {
            exoPlayer?.stop()
            exoPlayer?.release()
            exoPlayer = null
        }
    }

    override fun pausePlayer() {
        exoPlayer?.playWhenReady = false
        exoPlayer?.playbackState
    }

    override fun startPlayer() {
        exoPlayer?.playWhenReady = true
        exoPlayer?.playbackState
    }

}