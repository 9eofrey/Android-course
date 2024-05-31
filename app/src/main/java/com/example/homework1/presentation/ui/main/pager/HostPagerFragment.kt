package com.example.homework1.presentation.ui.main.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.homework1.databinding.FragmentHostPagerBinding
import com.example.homework1.presentation.ui.main.contactList.ContactsFragment
import com.example.homework1.presentation.ui.main.profile.MainProfileFragment
import com.google.android.material.tabs.TabLayoutMediator


class HostPagerFragment : Fragment() {
    private lateinit var binding: FragmentHostPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHostPagerBinding.inflate(inflater, container, false)
        return binding.root
    }


    fun getViewPager() = binding.viewPager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val list = listOf(

            MainProfileFragment(),
            ContactsFragment()
        )
        val titles = listOf(
            "tab1", "tab2"
        )
        val adapter = PagerAdapter(this.requireActivity(), list)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            tab.text = titles[pos]
        }.attach()
    }

}