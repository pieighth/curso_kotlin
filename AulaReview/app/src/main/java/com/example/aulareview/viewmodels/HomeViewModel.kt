package com.example.aulareview.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.aulareview.models.User

class HomeViewModel : ViewModel(){

    var user = ObservableField<User>()

}