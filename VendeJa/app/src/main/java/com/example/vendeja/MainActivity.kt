package com.example.vendeja

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.vendeja.utils.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    private var isLogged : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_main)

        if (isLogged){
            mainFlow()
        }else{
            loginFlow()

        }
    }

    private fun loginFlow() {
        val finalHost = NavHostFragment.create(R.navigation.auth_graph)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main_host, finalHost)
            .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
            .commit()
        bottomNavigationView.visibility = View.GONE
    }
    private fun mainFlow(){

        val navGraphIds = listOf(R.navigation.home_graph, R.navigation.settings_graph)

        // Setup the bottom navigation view with a list of navigation graphs
        bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.fragment_main_host,
            intent = intent
        )
        bottomNavigationView.visibility = View.VISIBLE
}
}
