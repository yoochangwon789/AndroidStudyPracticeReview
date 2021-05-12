package com.example.androidstudypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_layout_pager.*

class TabLayoutPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout_pager)

        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        val pagerAdapter = PagerAdapter(supportFragmentManager, 3)
        pager_view.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                pager_view.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        pager_view.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
    }
}

class PagerAdapter(
    fragmentManager: FragmentManager,
    val pagerCount: Int
) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return pagerCount
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return IuLilkaFragmentOne()
            1 -> return IuLilkaFragmentTwo()
            2 -> return IuLilkaFragmentThree()
            else -> return IuLilkaFragmentOne()
        }
    }
}