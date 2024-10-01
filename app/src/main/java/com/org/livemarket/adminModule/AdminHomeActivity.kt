package com.org.livemarket.adminModule

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.org.livemarket.R
import com.org.livemarket.adminModule.blockUser.BlockUserFragment
import com.org.livemarket.adminModule.competitions.CompetitionsAdminFragment
import com.org.livemarket.adminModule.transactions.TransactionsFragment
import com.org.livemarket.databinding.ActivityAdminHomeBinding
import com.org.livemarket.databinding.ActivityUserHomeBinding
import com.org.livemarket.userModule.competitions.CompetitionsFragment
import com.org.livemarket.zCommonFuntions.StatusBarUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        StatusBarUtils.transparentStatusBarWhite(this)
        StatusBarUtils.setTopPadding(resources, binding.appBarLt)

        fillCompetitions()
        onClickListeners()
    }


    private fun onClickListeners() {
        binding.btCompetitions.setOnClickListener {
            fillCompetitions()
//            onChangeBackGround(1)
        }

        binding.btTransactions.setOnClickListener {
//            onChangeBackGround(2)
            fillTransactions()

        }

        binding.btBlockUser.setOnClickListener {
//            onChangeBackGround(3)
            fillBlockUser()
        }

        binding.profileBT.setOnClickListener {
            fillProfile()
        }
    }

    private fun fillCompetitions() {

//        onChangeBackGround(1)

        binding.tvAppBarTitle.text = "Competitions"

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, CompetitionsAdminFragment())
            .commit()
    }

    private fun fillTransactions() {

//        onChangeBackGround(1)

        binding.tvAppBarTitle.text = "Transactions"

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, TransactionsFragment())
            .commit()
    }

    private fun fillBlockUser() {

//        onChangeBackGround(1)

        binding.tvAppBarTitle.text = "Block User"

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, BlockUserFragment())
            .commit()
    }

    private fun fillProfile() {

//        onChangeBackGround(1)

        binding.tvAppBarTitle.text = "Profile"

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, ProfileAdminFragment())
            .commit()
    }
}