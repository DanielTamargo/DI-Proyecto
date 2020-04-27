package com.example.proyecto

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun createFragment(position: Int): Fragment {
        when (position) {

        }

    }

    override fun getItemCount(): Int {
        return 3
    }

}