package com.example.project_am.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Product(
        @PrimaryKey(autoGenerate = true)
        var uid:Int? = null,
        @ColumnInfo(name = "product_name")
        var productName: String?,
        @ColumnInfo(name = "category")
        var category: String?,
        @ColumnInfo(name = "variant")
        var variant: String?,
        @ColumnInfo(name = "description")
        var description: String?,
        @ColumnInfo(name = "stock")
        var stock: String?
)