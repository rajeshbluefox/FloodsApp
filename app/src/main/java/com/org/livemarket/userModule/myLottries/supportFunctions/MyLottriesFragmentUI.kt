package com.org.livemarket.userModule.myLottries.supportFunctions

import android.content.Context
import android.view.LayoutInflater
import com.org.livemarket.databinding.FragmentMyLottriesBinding

class MyLottriesFragmentUI(
    context: Context,
    layoutInflater: LayoutInflater,
    private val binding: FragmentMyLottriesBinding,
    private val onTabSelected: (selectedTab: Int) -> Unit
) {
    private val context: Context = context
    private val layoutInflater : LayoutInflater = layoutInflater

    init {
        onClickListeners()
    }

    private fun onClickListeners()
    {
        binding.btTobeDrawn.setOnClickListener {
            onTabSelected.invoke(0)
        }

        binding.btDrawn.setOnClickListener {
            onTabSelected.invoke(1)
        }

        binding.btWon.setOnClickListener {
            onTabSelected.invoke(2)
        }
    }
}