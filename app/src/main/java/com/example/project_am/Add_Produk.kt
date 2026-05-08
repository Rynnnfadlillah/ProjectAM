package com.example.project_am

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.project_am.data.Appdatabase
import com.example.project_am.data.entity.Product


class Add_Produk : AppCompatActivity() {
    private lateinit var database: Appdatabase
    private lateinit var nama_category: EditText
    private lateinit var nama_variant: EditText
    private lateinit var nama_produk: EditText
    private lateinit var deskripsi: EditText
    private lateinit var angka_stock: EditText
    private lateinit var btn_Addproduk: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_produk)

        val btnkeluar = findViewById<ImageButton>(R.id.kembali_addcat)

        nama_category = findViewById(R.id.nama_category)
        nama_variant = findViewById(R.id.nama_variant)
        nama_produk = findViewById(R.id.nama_produk)
        deskripsi = findViewById(R.id.deskripsi)
        angka_stock = findViewById(R.id.angka_stock)
        btn_Addproduk = findViewById(R.id.btn_Addproduct)

        database = Appdatabase.getInstance(applicationContext)

        val intent = intent.extras
        if(intent!=null){
            val id = intent.getInt("id", 0)
            val user = database.productDao().get(id)

            nama_produk.setText(user.productName)
            nama_category.setText(user.category)
            nama_variant.setText(user.variant)
            deskripsi.setText(user.description)
            angka_stock.setText(user.stock)
        }

        btn_Addproduk.setOnClickListener {
            if (nama_category.text.isNotEmpty() && nama_variant.text.isNotEmpty() && nama_produk.text.isNotEmpty() && deskripsi.text.isNotEmpty() && angka_stock.text.isNotEmpty()) {
                if(intent!=null){
                    database.productDao().updateProduct(
                        Product(
                            intent.getInt("id",0),
                            nama_produk.text.toString(),
                            nama_category.text.toString(),
                            nama_variant.text.toString(),
                            deskripsi.text.toString(),
                            angka_stock.text.toString()
                        )

                    )

                }else{
                    database.productDao().insertProduct(
                        Product(
                            null,
                            nama_produk.text.toString(),
                            nama_category.text.toString(),
                            nama_variant.text.toString(),
                            deskripsi.text.toString(),
                            angka_stock.text.toString()
                        )
                    )
                }
                goToTampilProduk()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Silakan isi semua data dengan benar",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnkeluar.setOnClickListener{
        finish()
        }

    }
    private fun goToTampilProduk() {
        val intent = Intent(this, Tampil_Produk::class.java)
        startActivity(intent)
        finish()
    }
}

