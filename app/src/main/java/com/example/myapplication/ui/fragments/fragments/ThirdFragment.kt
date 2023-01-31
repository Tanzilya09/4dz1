package com.example.myapplication.ui.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentThirdBinding
import com.example.myapplication.model.FirstModel
import com.example.myapplication.repositiry.ThirdRepositiry
import com.example.myapplication.ui.fragments.adapters.ThirdAdapter


class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private var list = mutableListOf<FirstModel>()
    private val repository = ThirdRepositiry()
    private val thirdAdapter = ThirdAdapter(list)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }
    private fun initialization()= with(binding){
        rvThirdFragment.layoutManager= LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        list.addAll(repository.getListOfText())
        rvThirdFragment.adapter = thirdAdapter
    }

}