package com.example.testingfragmentsusingexoplayer.videoPlayer.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.testingfragmentsusingexoplayer.R
import com.example.testingfragmentsusingexoplayer.databinding.FragmentExoPlayerBinding
import com.example.testingfragmentsusingexoplayer.presenter.MainActivityPresenter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class ExoPlayerFragment() : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var binding: FragmentExoPlayerBinding
    private lateinit  var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ?{
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exo_player, null, false)
        mainActivityPresenter=MainActivityPresenter()
        mainActivityPresenter.initializePlayer(binding.exoPlayer,this.context)
        return binding.root
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExoPlayerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
    mainActivityPresenter.releasePlayer()
    }
    fun pausePlayer(){
        mainActivityPresenter.pausePlayer()
    }
    fun resumePlayer(){
        mainActivityPresenter.startPlayer()

    }
}
