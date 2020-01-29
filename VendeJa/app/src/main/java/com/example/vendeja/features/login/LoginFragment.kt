package com.example.vendeja.features.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

import com.example.vendeja.R
import com.example.vendeja.features.UserSessionViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private val viewModel: UserSessionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        btn_login.setOnClickListener {
            viewModel.authenticationState.value = UserSessionViewModel.AuthenticationState.AUTHENTICATED

            //ValidateLogin(id_login_email.text.let { it.toString() }, id_login_password.text.let { it.toString() })
        }
    }

    fun ValidateLogin(email: String, password: String){


        activity?.let {
            viewModel.auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(it){
                task ->
                if (task.isSuccessful) {
                    viewModel.authenticationState.value = UserSessionViewModel.AuthenticationState.AUTHENTICATED
                }else{
                    viewModel.authenticationState.value = UserSessionViewModel.AuthenticationState.UNAUTHENTICATED
                }

            }
        }
    }
}
