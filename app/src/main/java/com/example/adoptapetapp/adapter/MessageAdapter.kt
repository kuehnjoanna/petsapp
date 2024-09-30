package com.example.adoptapetapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptapetapp.data.Message
import com.example.adoptapetapp.databinding.MessageItemBinding

class MessageAdapter (
    val dataset: List<Message>,
    val itemClickedCallback: (Message) -> Unit,
): RecyclerView.Adapter<MessageAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: MessageItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = MessageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = dataset[position]
        val binding = holder.binding
        binding.messageTitleTV.text = data.title
        binding.messageBodyTV.text = data.content
        binding.messageITEM.setOnClickListener {
            itemClickedCallback(data)
        }
    }
}