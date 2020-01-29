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
import com.example.vendeja.models.database.ProductDB
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

        val myList = mutableListOf<ProductDB>()

//        myList.add(1, ProductDB(
//           "abc4qiwfq",
//            "Algum produto",
//            "image.jpg",
//                123.30f,
//            "Meu produto",
//            4.5f
//
//        ))

        val layoutManager = LinearLayoutManager(activity)
        productAdapter.setData(myList)
        id_list.layoutManager = layoutManager
        
        id_list.adapter = productAdapter



    }




}
