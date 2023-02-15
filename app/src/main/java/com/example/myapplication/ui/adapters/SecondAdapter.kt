package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemRvBinding
import com.example.myapplication.model.MainModel

class SecondAdapter (
    private val listSecond: MutableList<MainModel>
): RecyclerView.Adapter<SecondAdapter.SecondViewHolder>(){

    inner class SecondViewHolder(private val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root)  {
        fun onBind(mainModel: MainModel)= with(binding) {
            txt.text = mainModel.name
            Glide.with(image.context).load(mainModel.cat).into(image)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        return SecondViewHolder(
            ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.onBind(listSecond[position])
    }

    override fun getItemCount(): Int = listSecond.size

}