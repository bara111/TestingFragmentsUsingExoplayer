package com.example.testingfragmentsusingexoplayer.videoPlayer.view

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.example.testingfragmentsusingexoplayer.R
import com.example.testingfragmentsusingexoplayer.databinding.ActivityMainBinding
import com.example.testingfragmentsusingexoplayer.video.ExoPlayerFragment
import com.example.testingfragmentsusingexoplayer.video.MainActivityContract


class MainActivity : AppCompatActivity(), MainActivityContract.View,
    ExoPlayerFragment.OnFragmentInteractionListener {
    private lateinit var binding: ActivityMainBinding
    private val INTENT: String = "INTENT"
    private lateinit var exoPlayerFragment: ExoPlayerFragment
    private lateinit var fragmentManager: FragmentManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        binding.lifecycleOwner = this
        if (savedInstanceState == null) {
            exoPlayerFragment = ExoPlayerFragment()
            fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().add(R.id.exp_player_fragment, exoPlayerFragment)
                .commit()
        } else {
            exoPlayerFragment = ExoPlayerFragment()
            fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().add(R.id.exp_player_fragment, exoPlayerFragment)
                .commit()
        }
        binding.play.setOnClickListener {
            resume()
        }
        binding.stop.setOnClickListener {
            pause()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putParcelable(INTENT, intent)

    }

    override fun resume() {
        exoPlayerFragment.resumePlayer()
    }

    override fun pause() {
        exoPlayerFragment.pausePlayer()

    }

    override fun onFragmentInteraction(uri: Uri) {
    }
}
