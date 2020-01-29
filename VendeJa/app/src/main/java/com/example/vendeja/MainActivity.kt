package com.example.vendeja

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.example.vendeja.features.UserSessionViewModel
import com.example.vendeja.utils.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var finalHost: NavHostFragment
    lateinit var bottomNavigationView: BottomNavigationView
    private var isLogged: Boolean = false
    private val viewModel: UserSessionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_main)


        viewModel.authenticationState.observe(
            this/*viewLifeCycleOwner*/,
            Observer { authenticationState ->
                when (authenticationState) {
                    UserSessionViewModel.AuthenticationState.AUTHENTICATED -> {
                        supportFragmentManager.beginTransaction().remove(finalHost).commitNow()
                        mainFlow()
                    }
                    UserSessionViewModel.AuthenticationState.UNAUTHENTICATED -> {
                        loginFlow()
                    }
                    else -> bottomNavigationView.visibility = View.GONE
                }
            })


    }

    private fun setup(){
        val navGraphIds = listOf(R.navigation.home_graph, R.navigation.settings_graph)

        // Setup the bottom navigation view with a list of navigation graphs
        bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.fragment_main_host,
            intent = intent
        )

        if (!::finalHost.isInitialized) {
            finalHost = NavHostFragment.create(R.navigation.auth_graph)
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main_host, finalHost)
            .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
            .commit()



    }

    private fun loginFlow() {
        bottomNavigationView.visibility = View.GONE

        if(!::finalHost.isInitialized) {
            finalHost = NavHostFragment.create(R.navigation.auth_graph)
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main_host, finalHost)
            .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
            .commit()


    }

    private fun mainFlow() {
        bottomNavigationView.visibility = View.VISIBLE

        val navGraphIds = listOf(R.navigation.home_graph, R.navigation.publish_graph, R.navigation.settings_graph)

        // Setup the bottom navigation view with a list of navigation graphs
        bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.fragment_main_host,
            intent = intent
        )

    }

    private fun clearHostContainer(){
        supportFragmentManager.fragments.forEach {
            supportFragmentManager
                .beginTransaction()
                .remove(it)
                .commitNow()
        }
    }
}
