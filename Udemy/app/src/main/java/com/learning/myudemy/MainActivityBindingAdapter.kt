package com.learning.myudemy

import androidx.databinding.BindingAdapter
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView



@BindingAdapter("navController")
fun bindNavController(view : BottomNavigationView,navController: NavController){
    view.setupWithNavController(navController)
}
