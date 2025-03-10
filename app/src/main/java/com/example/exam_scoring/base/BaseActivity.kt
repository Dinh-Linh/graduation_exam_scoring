package com.example.exam_scoring.base

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding>(private val bindingInflater: (LayoutInflater) -> VB) : AppCompatActivity() {
    private var _binding : VB?= null
    protected val binding: VB
        get() = _binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        setContentView(binding.root)
        initData()
        bindData()
        setOnClick()
    }

    abstract fun initData()
    abstract fun bindData()
    abstract fun setOnClick()

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if(ev?.action == MotionEvent.ACTION_DOWN){
            val v = currentFocus
            if(v is EditText){
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if(!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())){
                    v.clearFocus()
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
                    imm.hideSoftInputFromWindow(v.windowToken, 0)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}