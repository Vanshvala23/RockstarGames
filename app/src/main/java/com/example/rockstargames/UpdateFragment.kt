package com.example.rockstargames

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UpdateFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var updatesAdapter: UpdatesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewUpdates)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        updatesAdapter = UpdatesAdapter(emptyList())
        recyclerView.adapter = updatesAdapter

        WebScrap.fetchUpdates { updates ->
            requireActivity().runOnUiThread {
                updatesAdapter.updateData(updates)
            }
        }
    }
}