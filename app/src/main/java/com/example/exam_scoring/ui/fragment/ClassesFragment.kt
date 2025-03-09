package com.example.exam_scoring.ui.fragment

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam_scoring.R
import com.example.exam_scoring.base.BaseFragment
import com.example.exam_scoring.databinding.FragmentClassesBinding
import com.example.exam_scoring.model.req.ClassesReq
import com.example.exam_scoring.ui.adapter.ClassesAdapter
import com.example.exam_scoring.utils.constants.safeNavigate
import com.example.exam_scoring.utils.extension.getToken
import com.example.exam_scoring.view_model.ClassViewModel

class ClassesFragment :
    BaseFragment<FragmentClassesBinding>(FragmentClassesBinding::inflate) {
    override val viewModel: ClassViewModel
        get() = ViewModelProvider(this)[ClassViewModel::class.java]

    private val classAdapter = ClassesAdapter()
    override fun initData() {
        val classesReq = ClassesReq(null, 0, 100, "AUTHOR_VIEW");
        requireActivity().getToken()?.let { viewModel.getListClass(classesReq, it) }
        Log.d("token", requireActivity().getToken().toString())
    }

    override fun bindData() {
        binding.rclListClass.adapter = classAdapter
        binding.rclListClass.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

    }

    override fun observeData() {
        //classAdapter.setDataList(FakeData().listClass)
        viewModel.listClass.observe(viewLifecycleOwner) { list ->
            run {
                list?.let { classAdapter.setDataList(it.toMutableList()) }
            }
        }
    }

    override fun setOnClick() {
        classAdapter.onClick = { item ->
            val bundle = Bundle()
            bundle.putSerializable("classes", item)
            parentFragment?.safeNavigate(R.id.action_listClassFragment_to_listTestFragment, bundle)
            Toast.makeText(requireContext(), "Class ${item.classCode}", Toast.LENGTH_LONG).show()
        }
    }

}