package com.example.rockstargames

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageGalleryAdapter(private val imageList:List<Int>):RecyclerView.Adapter<ImageGalleryAdapter.ImageViewHolder>()
{
    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageRes = imageList[position]

        ViewCompat.setAlpha(holder.itemView, 0f)
        holder.itemView.animate().alpha(1f).setDuration(500).start()

        // Load image with Glide for smooth performance
        Glide.with(holder.itemView.context)
            .load(imageRes)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = imageList.size
}