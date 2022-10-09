package com.fabio.appqatar.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.opengl.Visibility
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.fabio.appqatar.databinding.FragmentExtraBinding


class ExtraFragment : Fragment() {
    lateinit var binding: FragmentExtraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExtraBinding.inflate(inflater, container, false)
//        binding.webview.loadUrl("www.google.com")
        val settings: WebSettings = binding.webview.getSettings()
        settings.javaScriptEnabled = true

        val connMgr = context?.getSystemService(Context.CONNECTIVITY_SERVICE)
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        if(isConnected)
        {
            binding.webview.loadUrl("https://www.qatar2022.qa/")
            binding.webview.clearView()
            binding.webview.measure(100, 100)
            settings.useWideViewPort = true
            settings.loadWithOverviewMode = true
            binding.webview.visibility = View.VISIBLE
            binding.tvAlert.visibility = View.GONE
        }
        else
        {
            binding.webview.visibility = View.GONE
            binding.tvAlert.visibility = View.VISIBLE

        }



        return binding.root
    }



}