package com.org.livemarket.adminModule.transactions.supportFunctions

import android.content.Context
import android.view.LayoutInflater
import com.google.android.material.tabs.TabLayout
import com.org.livemarket.databinding.FragmentTransactionsBinding

class TransactionFragmentUI(
    context: Context,
    private val layoutInflater: LayoutInflater,
    private val binding: FragmentTransactionsBinding,
    private val onTabSelected: (clickType: Int) -> Unit,

    ) {
    init {
        tabClickListener()
    }

    var selectedTab = 0

    private fun tabClickListener() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        selectedTab = 0
                        onTabSelected.invoke(selectedTab)
                    }

                    1 -> {
                        selectedTab = 1
                        onTabSelected.invoke(selectedTab)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Handle tab unselected
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle tab reselected
            }
        })
    }

}