package com.example.rockstargames

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GTAV : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gtav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val trailerRecyclerView = view.findViewById<RecyclerView>(R.id.trailerRecyclerView)
        trailerRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val trailers = listOf(
            "QkkoHAzjnUs", // GTA V Official Trailer
            "olEGtoYs_8A", // GTA V Online Gameplay
            "UDd3pTE8UsQ"  // GTA V Heists Trailer
        )

        trailerRecyclerView.adapter = TrailerAdapter(trailers)

        val galleryRecyclerView=view.findViewById<RecyclerView>(R.id.galleryRecyclerView)
        galleryRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val images = listOf(R.drawable.gta_v_1, R.drawable.gta_v_2, R.drawable.gta_v_3)
        galleryRecyclerView.adapter = ImageGalleryAdapter(images)


        val viewUpdatesButton = view.findViewById<Button>(R.id.btnViewUpdates)
        viewUpdatesButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, UpdateFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
