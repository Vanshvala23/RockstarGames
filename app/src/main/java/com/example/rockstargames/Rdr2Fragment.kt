package com.example.rockstargames

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Button


class Rdr2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rdr2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load Trailers
        val trailerRecyclerView = view.findViewById<RecyclerView>(R.id.rdr2TrailerRecyclerView)
        trailerRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val trailers = listOf("gmA6MrX81z4", "F63h3v9QV7w", "eaW0tYpxyp0") // RDR2 Official trailers
        trailerRecyclerView.adapter = TrailerAdapter(trailers)

        // Load Image Gallery
        val galleryRecyclerView = view.findViewById<RecyclerView>(R.id.rdr2GalleryRecyclerView)
        galleryRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val images = listOf(R.drawable.rdr2_1, R.drawable.rdr2_2, R.drawable.rdr2_3, R.drawable.rdr2_4)
        galleryRecyclerView.adapter = ImageGalleryAdapter(images)

        // Handle "View Updates" Button
        val viewUpdatesButton = view.findViewById<Button>(R.id.btnViewRdr2Updates)
        viewUpdatesButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, UpdateFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}