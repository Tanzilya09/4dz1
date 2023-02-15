package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentSecondBinding
import com.example.myapplication.model.MainModel
import com.example.myapplication.repositiry.SecondRepositiry
import com.example.myapplication.ui.adapters.SecondAdapter


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private var list = ArrayList<MainModel>()
    private val repository = SecondRepositiry()
    private val secondAdapter = SecondAdapter(list)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() = with(binding) {
        rvSecondFragment.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        list.addAll(repository.getListOfText())
        rvSecondFragment.adapter = secondAdapter
    }
}