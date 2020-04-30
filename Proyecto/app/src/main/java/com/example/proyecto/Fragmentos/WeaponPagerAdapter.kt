package com.example.proyecto.Fragmentos

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.proyecto.FragmentosArmas.PistolasFragment
import com.example.proyecto.FragmentosMapas.BindFragment
import com.example.proyecto.FragmentosMapas.HavenFragment
import com.example.proyecto.FragmentosMapas.SplitFragment
import com.example.proyecto.R

class WeaponPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PistolasFragment.newInstance("Pistolas", R.color.softBlue)
            1 -> SplitFragment.newInstance("Split", R.color.softOrange)
            2 -> BindFragment.newInstance("Bind", R.color.smoothGray)
            3 -> PistolasFragment.newInstance("Pistolas", R.color.softOrange)
            else -> HavenFragment.newInstance("Haven", R.color.colorPrimary)
        }
    }

    override fun getItemCount(): Int {
        return 4 //son 4 tipos
    }
}