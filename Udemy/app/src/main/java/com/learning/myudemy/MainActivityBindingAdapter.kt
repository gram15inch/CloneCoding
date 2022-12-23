package com.learning.myudemy

import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView



@BindingAdapter("navController")
fun bindBottomNavigationView(view : BottomNavigationView,navController: NavController){
    view.setupWithNavController(navController)
}

@BindingAdapter("appBarConfiguration","navController")
fun bindToolbar(view: Toolbar, appBarConfiguration : AppBarConfiguration, navController: NavController){
    view.setupWithNavController(navController,appBarConfiguration)
}
