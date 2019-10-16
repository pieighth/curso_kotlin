package br.com.peagah.meusexercicios.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(var userLogin: String, var userPassword: String) : Parcelable{
    internal lateinit var userName : String


    constructor(userLogin: String, userName: String, userPassword: String) :
            this(userLogin, userPassword) {
        this.userName = userName
    }


}