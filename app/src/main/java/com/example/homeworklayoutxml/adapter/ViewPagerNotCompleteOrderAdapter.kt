package com.example.homeworklayoutxml.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homeworklayoutxml.fragment.CreateOrderFragment
import com.example.homeworklayoutxml.fragment.FinalizedFragment
import com.example.homeworklayoutxml.fragment.NotFinalizedFragment

class ViewPagerNotCompleteOrderAdapter(
    fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return NotFinalizedFragment()
            1 -> return FinalizedFragment()
            2 -> return CreateOrderFragment()

        }
        return NotFinalizedFragment()
    }
}