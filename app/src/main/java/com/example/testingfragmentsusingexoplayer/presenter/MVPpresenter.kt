package com.example.testingfragmentsusingexoplayer.presenter

import android.content.Context
import com.google.android.exoplayer2.ui.SimpleExoPlayerView

interface MVPpresenter {
    fun initializePlayer(exoPlayerView: SimpleExoPlayerView, context: Context?)
    fun releasePlayer()
    fun pausePlayer()
    fun startPlayer()
}