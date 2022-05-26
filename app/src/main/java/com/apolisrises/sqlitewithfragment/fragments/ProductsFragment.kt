package com.apolisrises.sqlitewithfragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.apolisrises.sqlitewithfragment.adapter.ProductAdapter
import com.apolisrises.sqlitewithfragment.databinding.FragmentProductListBinding
import com.apolisrises.sqlitewithfragment.sql.ProductDao

class ProductsFragment:Fragment() {
    lateinit var binding: FragmentProductListBinding
    lateinit var productDao: ProductDao
    lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductListBinding.inflate(layoutInflater, container, false)
        productDao = ProductDao(requireContext())
        adapter = ProductAdapter(productDao.getProducts())
        binding.rvProducts.layoutManager = LinearLayoutManager(requireContext())
        binding.rvProducts.adapter = adapter
        return binding.root
    }
}