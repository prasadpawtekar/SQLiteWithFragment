package com.apolisrises.sqlitewithfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apolisrises.sqlitewithfragment.Product
import com.apolisrises.sqlitewithfragment.databinding.ViewHolderProductBinding
import com.apolisrises.sqlitewithfragment.viewholders.ProductViewHolder

class ProductAdapter(val products: List<Product>): RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =  ViewHolderProductBinding.inflate(layoutInflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.setData(products[position])
    }

    override fun getItemCount() = products.size
}