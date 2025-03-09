package com.example.exam_scoring.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.exam_scoring.R
import com.example.exam_scoring.base.BaseActivity
import com.example.exam_scoring.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        Log.d("Fragment", supportFragmentManager.findFragmentById(R.id.mainNav).toString())
    }

    override fun initData() {

    }

    override fun bindData() {

    }

    override fun setOnClick() {

    }
}