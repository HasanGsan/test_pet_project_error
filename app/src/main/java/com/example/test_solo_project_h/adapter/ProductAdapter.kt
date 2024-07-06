package com.example.test_solo_project_h.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.test_solo_project_h.R
import com.example.test_solo_project_h.databinding.ListItemBinding
import com.example.test_solo_project_h.retrofit.Product
import com.example.test_solo_project_h.retrofit.ProductApi
import com.google.android.material.transition.Hold

class ProductAdapter : ListAdapter<Product, ProductAdapter.Holder>(Comparator()){
    class Holder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ListItemBinding.bind(view)

        fun bind(product: Product) = with(binding){ // Будем тут передават ьэлементы по очереди для заполнения
            Glide.with(imagePost.context)
                .load(product.image)
        }
    }


    class Comparator : DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        //Сравнение старых элементов с новыми

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =  LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false) //Для каждой view создаем элемент
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}