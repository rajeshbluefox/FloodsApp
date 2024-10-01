package com.org.livemarket.userModule.mywallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.livemarket.R
import com.org.livemarket.databinding.FragmentWalletBinding
import com.org.livemarket.userModule.mywallet.adapters.DepositAdapter
import com.org.livemarket.userModule.mywallet.adapters.WithdrawlAdapter
import com.org.livemarket.userModule.mywallet.modalClass.DepositData
import com.org.livemarket.userModule.mywallet.modalClass.WithdrawAmountData
import com.org.livemarket.userModule.mywallet.supportFunctions.AddDepositDialog
import com.org.livemarket.userModule.mywallet.supportFunctions.AddWithdrawlDialog
import com.org.livemarket.userModule.mywallet.supportFunctions.WalletFragmentUI
import com.org.livemarket.zSharedPreference.DummyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WalletFragment : Fragment() {

    private lateinit var binding: FragmentWalletBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_wallet, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initDummyRv()
    }

    private fun initDummyRv() {
        depositList = DummyData.getDummyDepositData()
        withdrawList = DummyData.getDummyWithdrawAmountData()

        initDepositList(depositList)
    }

    private var depositList = ArrayList<DepositData>()

    private fun initDepositList(depositList: List<DepositData>) {

        val depositAdapter = DepositAdapter(
            requireContext(),
            1,
            depositList,
            onDepositClicked = {},
            onApproveClicked = { _, _ -> })

        binding.rvWalletItems.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            adapter = depositAdapter
        }

    }

    private var withdrawList = ArrayList<WithdrawAmountData>()

    private fun initWithdrawList(withdrwalList: List<WithdrawAmountData>) {

        val withdrawAdapter =
            WithdrawlAdapter(
                requireContext(),
                1,
                withdrwalList,
                onWithDrawItemClicked = {},
                onApproveClicked = { _, _ -> })

        binding.rvWalletItems.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            adapter = withdrawAdapter
        }

    }


    private lateinit var walletFragmentUI: WalletFragmentUI
    private lateinit var addDepositDialog: AddDepositDialog
    private lateinit var addWithdrawlDialog: AddWithdrawlDialog

    private fun initViews() {
        walletFragmentUI =
            WalletFragmentUI(
                requireContext(),
                layoutInflater = layoutInflater,
                binding,
                ::onAddClicked,
                ::onTabSelected
            )
        addDepositDialog =
            AddDepositDialog(layoutInflater, requireContext(), ::onDepositSubmitClicked)
        addWithdrawlDialog =
            AddWithdrawlDialog(layoutInflater, requireContext(), ::onWithDrawSubmitClicked)
    }

    private fun onTabSelected(selectedTab: Int) {
        if (selectedTab == 0) {
            initDepositList(depositList)
        } else {
            initWithdrawList(withdrawList)
        }
    }

    private fun onAddClicked(clickType: Int) {
        if (clickType == 0) {
            addDepositDialog.openDepositDialog()
        } else {
            addWithdrawlDialog.openWithdrawlDialog()
        }
    }

    private fun onDepositSubmitClicked(depositData: DepositData) {

    }

    private fun onWithDrawSubmitClicked(withdrawAmountData: WithdrawAmountData) {

    }
}