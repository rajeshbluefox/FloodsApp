package com.org.livemarket.adminModule.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.livemarket.R
import com.org.livemarket.adminModule.transactions.supportFunctions.ApproveDialog
import com.org.livemarket.adminModule.transactions.supportFunctions.TransactionFragmentUI
import com.org.livemarket.databinding.FragmentTransactionsBinding
import com.org.livemarket.userModule.mywallet.adapters.DepositAdapter
import com.org.livemarket.userModule.mywallet.adapters.WithdrawlAdapter
import com.org.livemarket.userModule.mywallet.modalClass.DepositData
import com.org.livemarket.userModule.mywallet.modalClass.WithdrawAmountData
import com.org.livemarket.zSharedPreference.DummyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionsFragment : Fragment() {

    private lateinit var binding: FragmentTransactionsBinding

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
                R.layout.fragment_transactions,
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
    }

    private lateinit var transactionFragmentUI: TransactionFragmentUI
    private lateinit var approveDialog: ApproveDialog

    private fun initViews() {
        transactionFragmentUI =
            TransactionFragmentUI(
                requireContext(),
                layoutInflater = layoutInflater,
                binding,
                ::onTabSelected
            )

        approveDialog = ApproveDialog(layoutInflater, requireContext(), ::callApproveAPI)
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
            2,
            depositList,
            onDepositClicked = {},
            ::onApproveClicked
        )
        binding.rvTransactionsItems.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            adapter = depositAdapter
        }

    }

    private var withdrawList = ArrayList<WithdrawAmountData>()

    private fun initWithdrawList(withdrwalList: List<WithdrawAmountData>) {

        val withdrawAdapter = WithdrawlAdapter(
            requireContext(),
            2,
            withdrwalList,
            onWithDrawItemClicked = {},
            ::onApproveClickedWithdraw
        )
        binding.rvTransactionsItems.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            adapter = withdrawAdapter
        }

    }


    private fun onTabSelected(selectedTab: Int) {
        if (selectedTab == 0) {
            initDepositList(depositList)
        } else {
            initWithdrawList(withdrawList)
        }
    }

    private fun onApproveClicked(depositData: DepositData, isApproved: Boolean) {
        approveDialog.openApproveDialog(1, depositData, WithdrawAmountData(),"Do you want to approve this Deposit?")
    }

    private fun onApproveClickedWithdraw(
        withdrawAmountData: WithdrawAmountData,
        isApproved: Boolean
    ) {
        approveDialog.openApproveDialog(2, DepositData(), withdrawAmountData,"Do you want to approve this Withdraw?")

    }

    private fun callApproveAPI(
        dialogType: Int,
        depositData: DepositData,
        withdrawAmountData: WithdrawAmountData
    ) {
        if (dialogType == 0) {
            //TODO Call Approve Deposit
        } else {
            //TODO Call Approve Withdraw
        }
    }
}