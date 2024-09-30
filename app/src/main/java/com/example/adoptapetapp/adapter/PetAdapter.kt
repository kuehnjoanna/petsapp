package com.example.adoptapetapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptapetapp.data.Pet
import com.example.adoptapetapp.databinding.PetItemBinding

class PetAdapter (
    val dataset: List<Pet>,
    val itemClickedCallback: (Pet) -> Unit,
): RecyclerView.Adapter<PetAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: PetItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = PetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = dataset[position]
        val binding = holder.binding
        binding.dogNameTV.text = data.name
        binding.dogAgeTV.text = data.age.toString()
        binding.dogPhotoIV.setImageResource(data.picture)
        binding.dogPhotoIV.setOnClickListener {
            itemClickedCallback(data)
        }
    }
}