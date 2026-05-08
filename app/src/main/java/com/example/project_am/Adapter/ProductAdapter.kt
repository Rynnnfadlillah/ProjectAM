package com.example.project_am.Adapter

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_am.R
import com.example.project_am.data.entity.Product

class ProductAdapter(var list: List<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private lateinit var dialog: Dialog

    fun setDialog(dialog: Dialog){
        this.dialog = dialog

    }
    interface Dialog{
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        var namaProduct: TextView
        var namaKategori: TextView
        var namaVariant : TextView
        var deskripsi : TextView
        var stock : TextView

        init{
            namaProduct= view.findViewById(R.id.nama_produk)
            namaKategori= view.findViewById(R.id.nama_kategori)
            namaVariant= view.findViewById(R.id.nama_variant)
            deskripsi= view.findViewById(R.id.deskripsi)
            stock= view.findViewById(R.id.angka_stock)
            view.setOnClickListener{
                dialog.onClick(layoutPosition)
            }



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.rowcategori,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.namaProduct.text = list[position].productName
        holder.namaKategori.text = list[position].category
        holder.namaVariant.text = list[position].variant
        holder.deskripsi.text = list[position].description
        holder.stock.text = list[position].stock

    }
}