package com.apolisrises.sqlitewithfragment.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(cntx: Context): SQLiteOpenHelper(cntx, "ShopDb", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("""
            CREATE TABLE product(
                productId INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                category TEXT,
                price FLOAT
            )
        """.trimIndent())
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}