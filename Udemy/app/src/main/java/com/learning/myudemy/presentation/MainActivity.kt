package com.learning.myudemy.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.learning.myudemy.R
import com.learning.myudemy.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@BindingAdapter("navController")
fun bindBottomNavigationView(view : BottomNavigationView, navController: NavController){
    view.setupWithNavController(navController)
}

@BindingAdapter("appBarConfiguration","navController")
fun bindToolbar(view: Toolbar, appBarConfiguration : AppBarConfiguration, navController: NavController){
    view.setupWithNavController(navController,appBarConfiguration)
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var navHostFragment : NavHostFragment
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        navHostFragment = binding.mainNavHostFragment.getFragment()
        navController = navHostFragment.findNavController()
        //appBarConfiguration = AppBarConfiguration(navController.graph)
        appBarConfiguration = AppBarConfiguration(binding.mainBottomNav.menu)

        binding.mainAppBarConfiguration = appBarConfiguration
        binding.mainNavController = navController
        Timber.tag("lifecycle").d("onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.tag("lifecycle").d("onRestart")

    }

    override fun onStart() {
        super.onStart()
        Timber.tag("lifecycle").d("onStart")

    }

    override fun onResume() {
        super.onResume()
        Timber.tag("lifecycle").d("onResume")

    }

    override fun onPause() {
        super.onPause()
        Timber.tag("lifecycle").d("onPause")

    }
    override fun onStop() {
        super.onStop()
        Timber.tag("lifecycle").d("onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag("lifecycle").d("onDestroy")

    }
}