package com.org.livemarket.adminModule.blockUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.org.livemarket.R
import com.org.livemarket.adminModule.blockUser.modalClass.UserData
import com.org.livemarket.adminModule.blockUser.supportFunctions.BlockUserAdapter
import com.org.livemarket.adminModule.blockUser.supportFunctions.BlockUserDialog
import com.org.livemarket.databinding.FragmentBlockUserBinding
import com.org.livemarket.databinding.FragmentTransactionsBinding
import com.org.livemarket.userModule.competitions.modalClass.CompetitionData
import com.org.livemarket.userModule.competitions.supportFunctions.CompetitionsAdapter
import com.org.livemarket.zSharedPreference.DummyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlockUserFragment : Fragment() {

    private lateinit var binding: FragmentBlockUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_block_user,
                container,
                false
            )

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initDummyRv()
        tabClickListener()
    }

    private lateinit var blockUserDialog: BlockUserDialog

    private fun initViews() {
        blockUserDialog = BlockUserDialog(layoutInflater, requireContext(), ::onYesBlockClicked)
    }

    var selectedTab = 0

    private fun tabClickListener() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        selectedTab = 0
                        //Call Active User API
                    }

                    1 -> {
                        selectedTab = 1
                        //call Blocked Users API
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


    private fun initDummyRv() {
        usersList = DummyData.getDummyUserData()
        initUsersList(usersList)
    }

    private var usersList = ArrayList<UserData>()

    private fun initUsersList(usersList: List<UserData>) {

        val blockUserAdapter = BlockUserAdapter(requireContext(), usersList, ::onBlockClicked)
        binding.rvUsers.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            adapter = blockUserAdapter
        }

    }

    private fun onBlockClicked(userItem: UserData, isBlocked: Boolean) {
        if (isBlocked)
            blockUserDialog.openBlockUserDialog(userItem, true,"Do you want to block this user?")
        else
            blockUserDialog.openBlockUserDialog(userItem,false, "Do you want to unblock this user?")

    }

    private fun onYesBlockClicked(userItem: UserData, isBlocked: Boolean) {
        //TODO  Call API to block user
    }

}