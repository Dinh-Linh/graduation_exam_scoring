package com.example.exam_scoring.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.exam_scoring.base.BaseActivity
import com.example.exam_scoring.databinding.ActivityLoginBinding
import com.example.exam_scoring.model.req.LoginReq
import com.example.exam_scoring.utils.extension.getToken
import com.example.exam_scoring.view_model.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private val viewModel: LoginViewModel
        get() = ViewModelProvider(this)[LoginViewModel::class.java]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    override fun initData() {

    }

    override fun bindData() {

    }

    @SuppressLint("CommitPrefEdits")
    override fun setOnClick() {

        binding.btnLogin.setOnClickListener {
            val email = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()){
                val loginReq = LoginReq(email, password)
                viewModel.login(
                    loginReq,
                    onLoginSuccess = {apiResponse ->
                        val pref = getSharedPreferences("account", MODE_PRIVATE)
                        val editor = pref.edit()
                        editor.putString("token", "Bearer ${apiResponse.data?.token}")
                        editor.apply()
                        //Log.d("Token", "Bearer ${apiResponse.data.token}")
                        Log.d("Token", this.getToken().toString())
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                )
            }
            else{
                Toast.makeText(this, "Vui lòng nhập tên đăng nhập và mật khẩu", Toast.LENGTH_LONG).show()
            }
        }
    }
}