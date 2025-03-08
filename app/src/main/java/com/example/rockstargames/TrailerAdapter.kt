package com.example.rockstargames

import android.view.View
import android.webkit.WebView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class TrailerAdapter(private val videoIds: List<String>) :
    RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder>() {

    class TrailerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val webView: WebView = view.findViewById(R.id.webViewTrailer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trailers, parent, false)
        return TrailerViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrailerViewHolder, position: Int) {
        val videoId = videoIds[position]
        val embedUrl = "https://www.youtube.com/embed/$videoId?autoplay=1&rel=0"

        val webSettings = holder.webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.mediaPlaybackRequiresUserGesture = false

        // Improve WebView performance
        holder.webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        holder.webView.loadUrl(embedUrl)
    }

    override fun getItemCount(): Int = videoIds.size
}
