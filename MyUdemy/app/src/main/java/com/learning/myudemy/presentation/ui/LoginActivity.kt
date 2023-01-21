package com.learning.myudemy.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil.setContentView
import com.learning.myudemy.R
import com.learning.myudemy.databinding.ActivityLoginBinding
import com.learning.myudemy.presentation.base.DataBindingActivity
import com.learning.myudemy.presentation.viewModel.LoginViewModel

class LoginActivity : DataBindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

    }
}