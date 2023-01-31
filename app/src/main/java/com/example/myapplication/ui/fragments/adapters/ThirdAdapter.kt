package com.example.myapplication.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemRvBinding
import com.example.myapplication.model.FirstModel

class ThirdAdapter (
    private val listSecond: MutableList<FirstModel>,
): RecyclerView.Adapter<ThirdAdapter.ThirdViewHolder>(){

    inner class ThirdViewHolder(private val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root)  {
        fun onBind(firstModel: FirstModel)= with(binding) {
            txt.text = firstModel.name
            Glide.with(image.context).load(firstModel.cat).into(image)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThirdViewHolder {
        return ThirdViewHolder(
            ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ThirdViewHolder, position: Int) {
        holder.onBind(listSecond[position])
    }

    override fun getItemCount(): Int = listSecond.size

}