package com.example.homeworklayoutxml

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.homeworklayoutxml.adapter.ViewPagerCompleteOrderAdapter
import com.example.homeworklayoutxml.databinding.ActivityMainBinding
import com.example.homeworklayoutxml.databinding.CustomTabLayoutBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var customTablayoutBinding: CustomTabLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        setUpTablayout()


    }

    private fun setUpTablayout(){
        activityMainBinding.viewPager.adapter = ViewPagerCompleteOrderAdapter(this)
        TabLayoutMediator(activityMainBinding.tabLayout, activityMainBinding.viewPager) { tab, position ->
           tab.customView = getTabView(position)
            if (position == 3) {
                customTablayoutBinding.tvTitle.background = ContextCompat.getDrawable(this, R.drawable.shape_green_bg_corner_6)
                customTablayoutBinding.tvTitle.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.green))
                customTablayoutBinding.tvTitle.setPadding(8,8,8,8)
            }
        }.attach()
        activityMainBinding.viewPager.isUserInputEnabled = false
        val tab = activityMainBinding.tabLayout.getTabAt(0)
        tab?.customView?.let {
            customTablayoutBinding = CustomTabLayoutBinding.bind(it)
            customTablayoutBinding.tvTitle.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.green))
        }
        activityMainBinding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.let {
                    customTablayoutBinding = CustomTabLayoutBinding.bind(it)
                    customTablayoutBinding.tvTitle.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.green))
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.let {
                    customTablayoutBinding = CustomTabLayoutBinding.bind(it)
                    customTablayoutBinding.tvTitle.setTextColor(Color.GRAY)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Xử lý khi tab được chọn lại
            }
        })


    }
    private fun getTabView(position: Int): View {
        customTablayoutBinding = CustomTabLayoutBinding.inflate(layoutInflater)
        val titles = arrayOf("Chốt đơn", "Sản phẩm", "Hiệu quả","Kịch bản")
        customTablayoutBinding.tvTitle.text = titles[position]
        return customTablayoutBinding.root
    }


}