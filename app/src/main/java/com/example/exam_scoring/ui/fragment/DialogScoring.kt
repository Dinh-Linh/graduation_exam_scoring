package com.example.exam_scoring.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.exam_scoring.R
import com.example.exam_scoring.utils.extension.DialogOptionCallBack

class DialogScoring(private val callback: DialogOptionCallBack) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.scoring)
        val btnUploadFile = dialog.findViewById<Button>(R.id.uploadImg)
        val btnCamera = dialog.findViewById<Button>(R.id.camera)
        btnUploadFile.setOnClickListener {
            callback.onUploadFileSelected()
            dismiss()
        }
        btnCamera.setOnClickListener {
            callback.onCameraSelected()
            dismiss()
        }
        return dialog
    }
}