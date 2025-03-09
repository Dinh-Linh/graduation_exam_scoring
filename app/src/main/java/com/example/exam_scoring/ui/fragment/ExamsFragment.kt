package com.example.exam_scoring.ui.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam_scoring.R
import com.example.exam_scoring.base.BaseFragment
import com.example.exam_scoring.databinding.FragmentExamsBinding
import com.example.exam_scoring.model.entity.Classes
import com.example.exam_scoring.model.req.ExamReq
import com.example.exam_scoring.ui.adapter.ExamsAdapter
import com.example.exam_scoring.utils.constants.Constant.TAG
import com.example.exam_scoring.utils.constants.safeNavigate
import com.example.exam_scoring.utils.extension.getToken
import com.example.exam_scoring.view_model.ExamViewModel

class ExamsFragment : BaseFragment<FragmentExamsBinding>(FragmentExamsBinding::inflate) {
    override val viewModel: ExamViewModel
        get() = ViewModelProvider(this)[ExamViewModel::class.java]

    private var classes: Classes? = null
    private val examAdapter = ExamsAdapter()
    override fun initData() {
        classes = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("classes", Classes::class.java)
        } else {
            arguments?.getSerializable("classes") as Classes
        }
        val examReq = classes?.let { ExamReq(null, "CLASS_EXAM_VIEW", it.classCode, 0, 10) }
        requireActivity().getToken()?.let { viewModel.getExams(it, examReq!!) }
    }

    override fun bindData() {
        binding.rclListTest.adapter = examAdapter
        binding.rclListTest.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        //classes?.exams?.let { examAdapter.setDataList(it.toMutableList()) }

    }

    override fun observeData() {
        viewModel.listExam.observe(viewLifecycleOwner) { list ->
            list?.let { examAdapter.setDataList(it.toMutableList()) }
        }
    }

    override fun setOnClick() {
        examAdapter.onClick = { item ->
            val bundle = Bundle()
            bundle.putParcelable("exams", item)
//            findNavController().navigate(
//                R.id.action_listTestFragment_to_examResultsFragment,
//                bundle
//            )
            findNavController().safeNavigate(R.id.action_listTestFragment_to_examResultsFragment,bundle)
//            safeNavigate(R.id.action_listTestFragment_to_examResultsFragment, bundle)
//            Log.d("Exams id: ", item.id)
        }
    }
}

fun NavController.safeNavigate(
    actionId: Int,
    bundle: Bundle? = null
) {
    val action = currentDestination?.getAction(actionId) ?: graph.getAction(actionId)
    if (action != null && currentDestination?.id != action.destinationId) {
        navigate(actionId, bundle)
    }
}