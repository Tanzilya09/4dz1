package com.example.myapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ui.adapters.FirstAdapter
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.`interface`.OnItemTextClickListener
import com.example.myapplication.model.MainModel
import com.example.myapplication.repositiry.FirstRepositiry
import com.example.myapplication.ui.fragments.FirstFragmentDirections

class FirstFragment : Fragment() , OnItemTextClickListener {
    private lateinit var binding: FragmentFirstBinding
    private var list = ArrayList<MainModel>()
    private val repository = FirstRepositiry()
    private val firstAdapter = FirstAdapter(list, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }
    private fun initialization() = with(binding) {
        rvFirstFragment.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        list.addAll(repository.getListOfText())
        rvFirstFragment.adapter = firstAdapter
    }

    override fun onClick(model: MainModel) = with(binding) {
        val text = model.name
        val image = model.cat
        findNavController().navigate(
            FirstFragmentDirections.actionFirstFragmentToDetailFragment().setTextArg(text.toString())
            .setImageArg(image.toString())
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        list.clear()
    }
}
