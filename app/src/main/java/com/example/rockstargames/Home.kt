package com.example.rockstargames

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.featuredImage)
        val learnMoreButton = view.findViewById<Button>(R.id.learnMoreButton)
        val youtubeIcon = view.findViewById<ImageView>(R.id.youtubeIcon)
        val twitterIcon = view.findViewById<ImageView>(R.id.twitterIcon)
        val instagramIcon = view.findViewById<ImageView>(R.id.instagramIcon)

        webView.settings.javaScriptEnabled = true
        webView.settings.mediaPlaybackRequiresUserGesture = false
        val videoId="QdBZY2fkU-0"
        webView.loadUrl("https://www.youtube.com/embed/$videoId?autoplay=1&mute=0")

        // Learn More Button - Open Rockstar Games Website
        learnMoreButton.setOnClickListener {
            val url = "https://www.rockstargames.com/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        // Social Media Links
        youtubeIcon.setOnClickListener {
            val url = "https://www.youtube.com/rockstargames"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        twitterIcon.setOnClickListener {
            val url = "https://twitter.com/RockstarGames"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        instagramIcon.setOnClickListener {
            val url = "https://www.instagram.com/rockstargames/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}