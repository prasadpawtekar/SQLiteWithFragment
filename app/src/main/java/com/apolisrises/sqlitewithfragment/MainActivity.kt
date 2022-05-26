package com.apolisrises.sqlitewithfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apolisrises.sqlitewithfragment.databinding.ActivityMainBinding
import com.apolisrises.sqlitewithfragment.fragments.AddProductFragment
import com.apolisrises.sqlitewithfragment.fragments.ProductsFragment
import com.apolisrises.sqlitewithfragment.fragments.ProductsSearchFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addProductFragment = AddProductFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, addProductFragment)
            .commit()

        binding.btnAddProduct.setOnClickListener {
            showAddProductFragment()
        }

        binding.btnShowProducts.setOnClickListener {
            showAllProductsFragment()
        }

        binding.btnSearch.setOnClickListener {
            searchProduct()
        }
    }

    private fun searchProduct() {

        val searchText = binding.etSearchText.text.toString()

        val bundle = Bundle()
        bundle.putString("search_text", searchText)

        val searchFragment = ProductsSearchFragment()

        searchFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, searchFragment)
            .commit()


    }

    private fun showAllProductsFragment() {
        val productsFragment = ProductsFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, productsFragment)
            .commit()

    }

    private fun showAddProductFragment() {

        val addProductFragment = AddProductFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, addProductFragment)
            .commit()

    }
}