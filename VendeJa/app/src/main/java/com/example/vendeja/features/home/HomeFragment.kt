package com.example.vendeja.features.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.vendeja.R
import com.example.vendeja.features.UserSessionViewModel
import com.example.vendeja.features.product.ProductAdapter
import com.example.vendeja.models.Product
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private val viewModel: UserSessionViewModel by activityViewModels()
    private val productAdapter = ProductAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myList = mutableListOf<Product>()
        myList.add(Product(1,"produto 1", 244, "image1.jpg"))
        myList.add(Product(2,"produto 2", 12341, "image12.jpg"))
        myList.add(Product(3,"produto 3", 244, "image3.jpg"))
        myList.add(Product(4,"produto 4", 1244, "image32.jpg"))
        myList.add(Product(5,"produto 5", 244, "image4.jpg"))
        myList.add(Product(6,"produto 6", 44, "image122.jpg"))
        myList.add(Product(7,"produto 7", 244, "image15.jpg"))
        myList.add(Product(8,"produto 8", 44, "image13.jpg"))
        myList.add(Product(9,"produto 9", 244, "image11.jpg"))

        val layoutManager = LinearLayoutManager(activity)
        productAdapter.setData(myList)
        id_list.layoutManager = layoutManager
        
        id_list.adapter = productAdapter



    }




}
