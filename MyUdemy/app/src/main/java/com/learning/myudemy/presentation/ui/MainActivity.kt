package com.learning.myudemy.presentation.ui

import android.os.Bundle
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
import com.learning.myudemy.presentation.base.LifecycleActivity
import dagger.hilt.android.AndroidEntryPoint

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
    }

}