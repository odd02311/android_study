package com.example.part3.chapter7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.part3.chapter7.databinding.ItemContentBinding
import com.example.part3.chapter7.model.ContentEntity
import kotlinx.coroutines.NonDisposableHandle.parent

class ListAdapter : ListAdapter<ContentEntity, ContentViewHolder>(diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(
            ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    companion object{
        private val diffCallback = object : DiffUtil.ItemCallback<ContentEntity>(){
            override fun areItemsTheSame(oldItem: ContentEntity, newItem: ContentEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ContentEntity, newItem: ContentEntity): Boolean {
                return oldItem == newItem
            }

        }
    }


}