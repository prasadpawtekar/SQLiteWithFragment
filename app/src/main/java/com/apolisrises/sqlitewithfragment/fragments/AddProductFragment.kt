package com.apolisrises.sqlitewithfragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.apolisrises.sqlitewithfragment.Product
import com.apolisrises.sqlitewithfragment.databinding.FragmentAddProductBinding
import com.apolisrises.sqlitewithfragment.sql.ProductDao

class AddProductFragment: Fragment() {
    lateinit var binding: FragmentAddProductBinding
    lateinit var productDao: ProductDao

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddProductBinding.inflate(layoutInflater, container, false)

        productDao = ProductDao(requireContext())

        binding.btnAddProduct.setOnClickListener {
            addProduct()
        }
        return binding.root
    }

    private fun addProduct() {
        binding.apply {
            val name = etName.text.toString()
            val category = etCategory.text.toString()
            val price = etPrice.text.toString().toFloat()

            val product = Product(0, name, category, price)
            val productId = productDao.addProduct(product)

            if(productId>0) {
                Toast.makeText(requireContext(), "Product added with id : $productId", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "Failed to add product.", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        productDao.db.close()
    }
}