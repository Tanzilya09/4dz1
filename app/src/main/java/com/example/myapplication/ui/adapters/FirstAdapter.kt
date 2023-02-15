package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemRvBinding
import com.example.myapplication.`interface`.OnItemTextClickListener
import com.example.myapplication.model.MainModel

class FirstAdapter (
    private val listFirst: MutableList<MainModel>,
    private val onItemTextListener : OnItemTextClickListener
    ): RecyclerView.Adapter<FirstAdapter.FirstViewHolder>(){

        inner class FirstViewHolder(private val binding: ItemRvBinding) :
            RecyclerView.ViewHolder(binding.root)  {
            fun onBind(mainModel: MainModel)= with(binding) {
                txt.text = mainModel.name
                Glide.with(image.context).load(mainModel.cat).into(image)
                itemView.setOnClickListener{
                    onItemTextListener.onClick(mainModel)
                    txt.text = mainModel.toString()
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
            return FirstViewHolder(
                ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
            holder.onBind(listFirst[position])
        }

        override fun getItemCount(): Int = listFirst.size

    }