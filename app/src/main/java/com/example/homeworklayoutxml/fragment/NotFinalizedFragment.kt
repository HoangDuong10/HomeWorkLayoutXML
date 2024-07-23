package com.example.homeworklayoutxml.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworklayoutxml.R
import com.example.homeworklayoutxml.adapter.CustomerInformationAdapter
import com.example.homeworklayoutxml.databinding.FragmentNotFinalizedBinding
import com.example.homeworklayoutxml.model.User

class NotFinalizedFragment : Fragment() {

    private lateinit var fragmentNotFinalizedBinding: FragmentNotFinalizedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentNotFinalizedBinding = FragmentNotFinalizedBinding.inflate(layoutInflater)
        fragmentNotFinalizedBinding.rcvData.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter = CustomerInformationAdapter(getListCustomer())
        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider_recycler)!!)
        fragmentNotFinalizedBinding.rcvData.addItemDecoration(dividerItemDecoration)
        fragmentNotFinalizedBinding.rcvData.adapter = adapter
        return fragmentNotFinalizedBinding.root
    }

    private fun getListCustomer(): List<User> {
        return listOf(
            User(
                R.drawable.ic_avata, "Dương",
                listOf(
                    "Có thử hàng không shop? ",
                    "Bình luận đã xóa ",
                    "A12345 có ship ngay trong hôm nay được không em nhỉ?"
                )
            ),
            User(
                R.drawable.ic_avata2, "Nguyễn Văn Hải",
                listOf(
                    "Có thử hàng không shop? ",
                    "Shop hỗ trợ freeship không? ",
                    "A12345 có ship ngay trong hôm nay được không em nhỉ?"
                )
            ),
            User(
                R.drawable.ic_avata1, "Hoàng Văn Tuấn",
                listOf(
                    "Có thử hàng không shop? ",
                    "Shop hỗ trợ freeship không? ",
                    "A12345 có ship ngay trong hôm nay được không em nhỉ?"
                )
            ),
            User(
                R.drawable.ic_avata2, "Trần Văn Bảo",
                listOf(
                    "Có thử hàng không shop? ",
                    "Shop hỗ trợ freeship không? ",
                    "A12345 có ship ngay trong hôm nay được không em nhỉ?"
                )
            ),
            User(
                R.drawable.ic_avata, "Dương",
                listOf(
                    "Có thử hàng không shop? ",
                    "Shop hỗ trợ freeship không? ",
                    "A12345 có ship ngay trong hôm nay được không em nhỉ?"
                )
            ),
            User(
                R.drawable.ic_avata, "Dương",
                listOf(
                    "Có thử hàng không shop, ",
                    "Shop hỗ trợ freeship không? ",
                    "A12345 có ship ngay trong hôm nay được không em nhỉ?"
                )
            ),
        )
    }
}