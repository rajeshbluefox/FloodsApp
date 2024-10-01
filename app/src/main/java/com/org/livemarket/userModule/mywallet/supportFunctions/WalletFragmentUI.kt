package com.org.livemarket.userModule.mywallet.supportFunctions

import android.content.Context
import android.view.LayoutInflater
import com.google.android.material.tabs.TabLayout
import com.org.livemarket.databinding.FragmentWalletBinding

class WalletFragmentUI(
    context: Context,
    layoutInflater: LayoutInflater,
    private val binding: FragmentWalletBinding,
    private val onAddClicked: (clickType: Int) -> Unit,
    private val onTabSelected: (clickType: Int) -> Unit,

    ) {
    private val mContext: Context = context
    private val mLayoutInflater: LayoutInflater = layoutInflater


    init {
        tabClickListener()
        onClickListeners()
    }

    private fun onClickListeners()
    {
        binding.btAddActivity.setOnClickListener {
            onAddClicked.invoke(selectedTab)
        }

        binding.btAddMoney.setOnClickListener {
            onAddClicked.invoke(0)
        }

    }

    var selectedTab = 0

    private fun tabClickListener() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        selectedTab = 0
                        updateButton(selectedTab)
                    }

                    1 -> {
                        selectedTab = 1
                        updateButton(selectedTab)
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

    fun updateButton(selectedTab: Int)
    {
        when (selectedTab) {
            0 -> {
                binding.btAddActivity.text = "Add Deposit"
            }
            1 -> {
                binding.btAddActivity.text = "Request Withdraw"
            }
        }

        onTabSelected.invoke(selectedTab)
    }

}