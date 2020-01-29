package com.example.vendeja.features.publish


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.example.vendeja.R
import kotlinx.android.synthetic.main.fragment_publish.*

/**
 * A simple [Fragment] subclass.
 */
class PublishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_publish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        id_btn_confirmation.setOnClickListener {
            it.findNavController().navigate(PublishFragmentDirections.navToConfirmation())
        }
    }
}
