package com.example.rockstargames

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(
    private val gameList: List<Game>,
    private val onGameClick: (Game) -> Unit // Click listener
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.gameImage)
        val titleView: TextView = view.findViewById(R.id.gameTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_games, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = gameList[position]
        holder.imageView.setImageResource(game.image)
        holder.titleView.text = game.title

        // Add Click Listener
        holder.itemView.setOnClickListener {
            onGameClick(game) // Notify fragment about click
        }
    }

    override fun getItemCount(): Int = gameList.size
}
