package com.example.homeworklayoutxml.fragment
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.homeworklayoutxml.R
import com.example.homeworklayoutxml.adapter.ViewPagerNotCompleteOrderAdapter
import com.example.homeworklayoutxml.databinding.CustomTabLayoutNotCompleteBinding
import com.example.homeworklayoutxml.databinding.FragmentCompleteOrderBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class CompleteOrderFragment : Fragment() {
    private lateinit var fragmentCompleteFragment: FragmentCompleteOrderBinding
    private lateinit var customTabLayoutNotCompleteBinding: CustomTabLayoutNotCompleteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentCompleteFragment = FragmentCompleteOrderBinding.inflate(layoutInflater)
        setUpTablayout()
        return fragmentCompleteFragment.root

    }

    private fun setUpTablayout(){
        fragmentCompleteFragment.viewPager.adapter = ViewPagerNotCompleteOrderAdapter(requireActivity())
        TabLayoutMediator(fragmentCompleteFragment.tabLayout, fragmentCompleteFragment.viewPager) { tab, position ->
            tab.customView = getTabView(position)
        }.attach()
        fragmentCompleteFragment.viewPager.isUserInputEnabled = false
        val tab = fragmentCompleteFragment.tabLayout.getTabAt(0)
        tab?.customView?.let {
            customTabLayoutNotCompleteBinding = CustomTabLayoutNotCompleteBinding.bind(it)
            customTabLayoutNotCompleteBinding.tvTitle.setTextColor(Color.WHITE)
            customTabLayoutNotCompleteBinding.linearLayout.background = ContextCompat.getDrawable(requireContext(),R.drawable.shape_green_bg_gray_stoke_corner_20)
        }
        fragmentCompleteFragment.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.let {
                    customTabLayoutNotCompleteBinding = CustomTabLayoutNotCompleteBinding.bind(it)
                    customTabLayoutNotCompleteBinding.tvTitle.setTextColor(Color.WHITE)
                    customTabLayoutNotCompleteBinding.linearLayout.background = ContextCompat.getDrawable(requireContext(),R.drawable.shape_green_bg_gray_stoke_corner_20)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.let {
                    customTabLayoutNotCompleteBinding = CustomTabLayoutNotCompleteBinding.bind(it)
                    customTabLayoutNotCompleteBinding.tvTitle.setTextColor(Color.BLACK)
                    customTabLayoutNotCompleteBinding.linearLayout.background = ContextCompat.getDrawable(requireContext(),R.drawable.shape_white_bg_gray_stoke_corner_20)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Xử lý khi tab được chọn lại
            }
        })


    }

    private fun getTabView(position: Int): View {
        customTabLayoutNotCompleteBinding = CustomTabLayoutNotCompleteBinding.inflate(layoutInflater)
        val titles = arrayOf("Chưa chốt 7", "Đã chốt 8", "Lên đơn 12")
        customTabLayoutNotCompleteBinding.tvTitle.text = titles[position]
        return customTabLayoutNotCompleteBinding.root
    }


}