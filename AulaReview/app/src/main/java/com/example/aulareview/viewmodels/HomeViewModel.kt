package com.example.aulareview.viewmodels

import android.text.Editable
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.aulareview.R
import com.example.aulareview.models.User

class HomeViewModel : ViewModel(){

    var user = ObservableField<User>()

    fun afterChanged(s: Editable){
        Log.d("viewModel", "afterChanged: $s")
    }

    fun beforeChanged(s: CharSequence, start: Int, count: Int, after: Int){

    }

    fun onChanged(s: CharSequence, start: Int, before: Int, count: Int){
        Log.d("viewModel","onChanged: $s")
    }

    fun buttonClick(view: View?){
        Log.d("viewModel", "Cliquei nessa bagaca")
        val navController = view?.findNavController()
        navController?.navigate(R.id.profile)

    }

}