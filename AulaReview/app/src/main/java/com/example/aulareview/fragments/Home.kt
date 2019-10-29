package com.example.aulareview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.aulareview.R
import com.example.aulareview.databinding.HomeFragmentBinding
import com.example.aulareview.models.User
import com.example.aulareview.viewmodels.HomeViewModel

class Home : Fragment(){

    lateinit var binding : HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        val viewModel = HomeViewModel()

        binding.viewModel = viewModel
        viewModel.user.set(User("joao", "mail.mao", "1234"))


        binding.lifecycleOwner = this

        return binding.root
    }
}