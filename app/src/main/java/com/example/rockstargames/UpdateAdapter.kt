package com.example.rockstargames

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UpdatesAdapter(private var updates: List<UpdateItem>) :
    RecyclerView.Adapter<UpdatesAdapter.UpdatesViewHolder>() {

    class UpdatesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val updateImage: ImageView = view.findViewById(R.id.updateImage)
        val updateTitle: TextView = view.findViewById(R.id.updateTitle)
        val updateDate: TextView = view.findViewById(R.id.updateDate)
        val updateDescription: TextView = view.findViewById(R.id.updateDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdatesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_updates, parent, false)
        return UpdatesViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpdatesViewHolder, position: Int) {
        val update = updates[position]
        holder.updateTitle.text = update.title
        holder.updateDate.text = update.date
        holder.updateDescription.text = update.description
        Glide.with(holder.itemView.context).load(update.imageUrl).into(holder.updateImage)
    }

    override fun getItemCount(): Int = updates.size

    fun updateData(newUpdates: List<UpdateItem>) {
        updates = newUpdates
        notifyDataSetChanged()
    }
}
