package com.example.vendeja.features.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.vendeja.R
import com.example.vendeja.features.home.HomeFragmentDirections
import com.example.vendeja.models.database.ProductDB
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter() : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var products: MutableList<ProductDB> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val inflate = inflater.inflate(R.layout.product_item, parent, false)

        inflate.setOnClickListener {
            it.findNavController().navigate(HomeFragmentDirections.listToDetail(1))
        }
        return ProductViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return products.size

    }

    fun setData(products: MutableList<ProductDB>) {
        this.products = products
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bindData(product, position)
    }

    class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(product: ProductDB, position: Int) {
            view.id_product_name.text = product.produto.toString()
//            view.id_product_price.text = product.price.toString()
            view.id_product_url.text = product.imageUrl.toString()


        }
    }
}