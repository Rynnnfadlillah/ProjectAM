package com.example.project_am.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.project_am.data.entity.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM Product")
    fun getAllProducts(): List<Product>

    @Query("SELECT * FROM Product WHERE product_name LIKE '%' || :search || '%'")
    fun searchProducts(search: String): List<Product>
    @Insert
     fun insertProduct(vararg product: Product)
    @Update
    fun updateProduct(product: Product)
    @Delete
    fun delete(product: Product)

    @Query("SELECT * FROM Product WHERE uid = :uid")
    fun get(uid: Int): Product




}