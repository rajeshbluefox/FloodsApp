package com.org.livemarket.adminModule.competitions.supportFunctions

import android.content.Context
import android.view.LayoutInflater
import com.org.livemarket.databinding.FragmentCompetitionsAdminBinding

class CompAdminUI(
    context: Context,
    layoutInflater: LayoutInflater,
    private val binding: FragmentCompetitionsAdminBinding,
    private val onTabSelected: (selectedTab: Int) -> Unit
) {
    init {

        onClickListeners()
    }

    private fun onClickListeners() {
        binding.btLive.setOnClickListener {
            onTabSelected.invoke(1)
        }
        binding.btToDraw.setOnClickListener {
            onTabSelected.invoke(2)
        }

        binding.btDrawn.setOnClickListener {
            onTabSelected.invoke(3)
        }

    }
}