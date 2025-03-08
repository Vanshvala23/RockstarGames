package com.example.rockstargames

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Games : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var gamesAdapter: GameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val gamesList = listOf(
            Game("GTA V", R.drawable.gta_v),
            Game("Red Dead Redemption 2", R.drawable.rdr2)
        )

        gamesAdapter = GameAdapter(gamesList) { selectedGame ->
            if (selectedGame.title == "GTA V") {
                openGtaVFragment()  // Now this function is correctly called
            }
        }
        recyclerView.adapter = gamesAdapter
    }

    private fun openGtaVFragment() {
        val fragment = GTAV()  // This should be the correct Fragment class

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment) // Ensure fragmentContainer is correct in XML
            .addToBackStack(null) // Allows back navigation
            .commit()
    }
}
