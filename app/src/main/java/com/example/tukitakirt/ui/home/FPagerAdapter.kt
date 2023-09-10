package com.example.tukitakirt.ui.home
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tukitakirt.ui.chat.ChatFragment
import com.example.tukitakirt.ui.profile.ProfileFragment
import com.example.tukitakirt.ui.user.UserFragment


// It works like a recycleView

//CS-28

class FPagerAdapter(private val fm: FragmentManager): FragmentPagerAdapter(fm) {

    var names = arrayOf("User", "Chat", "Profile")

    override fun getCount(): Int {

      return names.size


    }

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> UserFragment()
            1 -> ChatFragment()
            else -> ProfileFragment()
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        return names[position]


    }


}