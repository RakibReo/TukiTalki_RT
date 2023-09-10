package com.example.tukitakirt.ui.home
import android.os.Bundle
import android.view.View
import com.example.tukitakirt.base.BaseFragment
import com.example.tukitakirt.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


//CS-29

@AndroidEntryPoint

class HomeFragment :BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val pageAdapter=FPagerAdapter(parentFragmentManager)
      binding.fragmentViewpager.adapter= pageAdapter
        binding.tabLayout.setupWithViewPager(binding.fragmentViewpager)

    }



}