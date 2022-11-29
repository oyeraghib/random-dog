package com.example.randomdoggen.app.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.randomdoggen.databinding.ListItemRecyclerViewBinding

class GeneratedDogsAdapter : RecyclerView.Adapter<GeneratedDogsAdapter.GeneratedDogsViewHolder>() {

    private var list = emptyList<String>()

    inner class GeneratedDogsViewHolder(val binding: ListItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneratedDogsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemRecyclerViewBinding.inflate(layoutInflater)

        return GeneratedDogsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GeneratedDogsViewHolder, position: Int) {
        val currentDog = list[position]
        holder.apply {
            Log.d("Adapter", "Image: $currentDog")
            binding.ivDog.load(currentDog)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getDogs(dogs: List<String>) {
        this.list = dogs
        notifyDataSetChanged()
    }
}