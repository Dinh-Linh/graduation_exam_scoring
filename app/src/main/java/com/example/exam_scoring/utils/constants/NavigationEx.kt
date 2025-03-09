package com.example.exam_scoring.utils.constants

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

private const val TAG = Constant.TAG

fun Fragment.safeNavigate(actionId: Int, bundle: Bundle? = null) {
    try {
        findNavController().navigate(actionId, bundle)
    } catch (e: Exception) {
        Log.e(TAG, e.message.toString())
    }
}

fun Fragment.safePopBack() {
    try {
        findNavController().popBackStack()
    } catch (e: Exception) {
        Log.e(TAG, e.message.toString())
    }
}