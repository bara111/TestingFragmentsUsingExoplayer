package com.example.testingfragmentsusingexoplayer.video

import android.content.Context
import com.google.android.exoplayer2.ui.SimpleExoPlayerView

interface MainActivityContract {
    interface Presenter {
        fun initializePlayer(exoPlayerView: SimpleExoPlayerView, context: Context?)
        fun releasePlayer()
        fun pausePlayer()
        fun startPlayer()
    }
    interface View {
        fun resume()
        fun pause()
    }
}