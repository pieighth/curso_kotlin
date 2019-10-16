package br.com.peagah.meusexercicios.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Todo(val id: Int, val Description: String, val status: Boolean): Parcelable{
    internal lateinit var dateExecuted : Date
}
