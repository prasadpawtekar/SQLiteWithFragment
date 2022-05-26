package com.apolisrises.sqlitewithfragment.sql

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.apolisrises.sqlitewithfragment.Product

class ProductDao(cntx: Context) {
    val db = DBHelper(cntx).writableDatabase

    fun addProduct(product: Product): Long {
        val values = ContentValues().apply {
            put("name", product.name)
            put("category", product.category)
            put("price", product.price)
        }

        return db.insert("product", null, values)
    }

    @SuppressLint("Range")
    fun getProducts(): List<Product> {
        val list = ArrayList<Product>()

        val cursor = db.query("product", null, null, null, null, null, null)

        while(cursor.moveToNext()) {
            val id = cursor.getLong(cursor.getColumnIndex("productId"))
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val category = cursor.getString(cursor.getColumnIndex("category"))
            val price = cursor.getFloat(cursor.getColumnIndex("price"))

            list.add(Product(id, name, category, price))
        }
        return list
    }

    @SuppressLint("Range")
    fun search(searchText: String): List<Product> {
        val list = ArrayList<Product>()

        val cursor = db.query("product", null, "name like '%$searchText%'", null, null, null, null)

        while(cursor.moveToNext()) {
            val id = cursor.getLong(cursor.getColumnIndex("productId"))
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val category = cursor.getString(cursor.getColumnIndex("category"))
            val price = cursor.getFloat(cursor.getColumnIndex("price"))

            list.add(Product(id, name, category, price))
        }
        return list
    }
}