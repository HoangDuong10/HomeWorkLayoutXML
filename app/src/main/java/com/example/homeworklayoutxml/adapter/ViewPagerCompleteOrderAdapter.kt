package com.example.homeworklayoutxml.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homeworklayoutxml.fragment.CompleteOrderFragment
import com.example.homeworklayoutxml.fragment.EffectiveFragment
import com.example.homeworklayoutxml.fragment.ProductFragment
import com.example.homeworklayoutxml.fragment.ScriptFragment

class ViewPagerCompleteOrderAdapter(
    fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return CompleteOrderFragment()
            1 -> return ProductFragment()
            2 -> return EffectiveFragment()
            3 -> return ScriptFragment()
        }
        return CompleteOrderFragment()
    }
}