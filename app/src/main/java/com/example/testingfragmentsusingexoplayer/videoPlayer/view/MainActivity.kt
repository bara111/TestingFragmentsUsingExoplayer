package com.example.testingfragmentsusingexoplayer.videoPlayer.view

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.example.testingfragmentsusingexoplayer.R
import com.example.testingfragmentsusingexoplayer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MVPview, ExoPlayerFragment.OnFragmentInteractionListener {
    private lateinit var binding: ActivityMainBinding
    private val INTENT:String="INTENT"
    private lateinit var exoPlayerFragment:ExoPlayerFragment
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
            fragmentManager.beginTransaction().add(R.id.exp_player_fragment, exoPlayerFragment!!)
                .commit()
        } else {
            exoPlayerFragment = ExoPlayerFragment()
            fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().add(R.id.exp_player_fragment, exoPlayerFragment!!)
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putParcelable(INTENT, intent)

    }

    override fun start() {

    }

    override fun pause() {

    }

    override fun onFragmentInteraction(uri: Uri) {
    }
}
