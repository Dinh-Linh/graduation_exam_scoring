package com.example.exam_scoring.ui.fragment

import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam_scoring.base.BaseFragment
import com.example.exam_scoring.databinding.FragmentExamResultsBinding
import com.example.exam_scoring.model.entity.Exams
import com.example.exam_scoring.model.req.ResultExamReq
import com.example.exam_scoring.ui.adapter.ExamResultsAdapter
import com.example.exam_scoring.utils.extension.DialogOptionCallBack
import com.example.exam_scoring.utils.extension.getToken
import com.example.exam_scoring.view_model.ExamResultsViewModel
import java.io.File


class ExamResultsFragment :
    BaseFragment<FragmentExamResultsBinding>(FragmentExamResultsBinding::inflate),
    DialogOptionCallBack {
    override val viewModel: ExamResultsViewModel
        get() = ViewModelProvider(this)[ExamResultsViewModel::class.java]

    private val examsAdapter = ExamResultsAdapter()
    private var exams: Exams? = null

    private val pickFileLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                //Execute file selected
                Toast.makeText(requireContext(), "File selected: $it", Toast.LENGTH_LONG).show()
            }
        }

    private val takePictureLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
            if (isSuccess) {
                //Execute image took
                Toast.makeText(requireContext(), "Image took", Toast.LENGTH_LONG).show()
            }
        }

    override fun initData() {
        exams = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("exams", Exams::class.java)
        } else {
            arguments?.getSerializable("exams") as Exams
        }
        val examResultReq = exams?.let { ResultExamReq(it.id, "", "", 10, 0) }
        requireActivity().getToken()?.let {
                viewModel.fetchExamResults(it, examResultReq!!)
        }
    }

    override fun bindData() {
        binding.rclListStudent.adapter = examsAdapter
        binding.rclListStudent.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//        exams?.students?.let { studentAdapter.setDataList(it.toMutableList()) }
//        Log.d("Students:", exams?.students.toString())
    }

    override fun observeData() {
        viewModel.examResult.observe(viewLifecycleOwner) { list ->
            list?.let { examsAdapter.setDataList(it.toMutableList()) }
        }
    }

    override fun setOnClick() {
        examsAdapter.onClick = {
            showDialogScoring()
        }
    }

    //Open file picker
    override fun onUploadFileSelected() {
        pickFileLauncher.launch("image/*")
    }

    //Camera
    override fun onCameraSelected() {
        val photoUri = createImageUri()
        takePictureLauncher.launch(photoUri)
    }

    private fun createImageUri(): Uri? {
        val imageFile = File(requireContext().cacheDir, "captured_image.jpg")
        return FileProvider.getUriForFile(
            requireContext(),
            "${requireContext().packageName}.provider",
            imageFile
        )
    }

    private fun showDialogScoring() {
        val dialog = DialogScoring(this@ExamResultsFragment)
        dialog.show(childFragmentManager, "DialogScoring")
    }

}