package com.example.myapplication.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemRvBinding
import com.example.myapplication.`interface`.OnItemTextClickListener
import com.example.myapplication.model.FirstModel

class FirstAdapter (
    private val listFirst: MutableList<FirstModel>,
    private val onItemTextListener : OnItemTextClickListener
    ): RecyclerView.Adapter<FirstAdapter.FirstViewHolder>(){

        inner class FirstViewHolder(private val binding: ItemRvBinding) :
            RecyclerView.ViewHolder(binding.root)  {
            fun onBind(firstModel: FirstModel)= with(binding) {
                txt.text = firstModel.name
                Glide.with(image.context).load(firstModel.cat).into(image)
                itemView.setOnClickListener{
                    onItemTextListener.onClick(firstModel)
                    txt.text = firstModel.toString()
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
            return FirstViewHolder(
                ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
            holder.onBind(listFirst[position])
            holder.itemView.setOnLongClickListener{
                listFirst.removeAt(holder.adapterPosition)
                notifyItemRemoved(holder.adapterPosition)
                true
            }
        }

        override fun getItemCount(): Int = listFirst.size

    }