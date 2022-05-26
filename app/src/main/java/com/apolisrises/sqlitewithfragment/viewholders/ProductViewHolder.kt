package com.apolisrises.sqlitewithfragment.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.apolisrises.sqlitewithfragment.Product
import com.apolisrises.sqlitewithfragment.databinding.ViewHolderProductBinding

class ProductViewHolder(val binding: ViewHolderProductBinding): RecyclerView.ViewHolder(binding.root) {
    fun setData(product: Product) {
        binding.apply {
            tvCategory.text = "Category   : ${product.category}"
            tvName.text     = "Name       : ${product.name}"
            tvPrice.text    = "Price      : ${product.price}"
        }
    }
}