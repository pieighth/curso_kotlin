package com.example.aulareview.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR


data class User(private var _name: String,private var _email: String, var password: String) : BaseObservable(){

    var name : String
    @Bindable get() = _name
    set(value){
        _name = value
        notifyPropertyChanged(BR.name)
    }

    var email: String
    @Bindable get() = _email
    set(value) {
        _email = value
        notifyPropertyChanged(BR.email)
    }
}