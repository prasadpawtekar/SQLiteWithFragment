package com.apolisrises.sqlitewithfragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.apolisrises.sqlitewithfragment.adapter.ProductAdapter
import com.apolisrises.sqlitewithfragment.databinding.FragmentProductListBinding
import com.apolisrises.sqlitewithfragment.databinding.FragmentProductSearchBinding
import com.apolisrises.sqlitewithfragment.sql.ProductDao

class ProductsSearchFragment:Fragment() {
    lateinit var binding: FragmentProductSearchBinding
    lateinit var productDao: ProductDao
    lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductSearchBinding.inflate(layoutInflater, container, false)
        productDao = ProductDao(requireContext())
        val searchText = arguments?.getString("search_text") ?: ""
        val searchResultList = productDao.search(searchText)

        adapter = ProductAdapter(searchResultList)
        binding.rvProducts.layoutManager = LinearLayoutManager(requireContext())
        binding.rvProducts.adapter = adapter

        binding.tvSearchText.text = "Search Text = $searchText"
        return binding.root
    }

}