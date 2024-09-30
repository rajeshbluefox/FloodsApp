package com.org.livemarket.userModule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.org.livemarket.R
import com.org.livemarket.databinding.ActivityUserHomeBinding
import com.org.livemarket.userModule.competitions.CompetitionsFragment
import com.org.livemarket.userModule.myLottries.MyLottriesFragment
import com.org.livemarket.userModule.mywallet.WalletFragment
import com.org.livemarket.userModule.profileuser.UserProfileFragment
import com.org.livemarket.zCommonFuntions.StatusBarUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        StatusBarUtils.transparentStatusBarWhite(this)
        StatusBarUtils.setTopPadding(resources, binding.appBarLt)

        fillCompetetions()
        onClickListeners()
    }

    private fun onClickListeners() {
        binding.myJobBT.setOnClickListener {
            fillCompetetions()
//            onChangeBackGround(1)
        }

        binding.postJobBT.setOnClickListener {
//            onChangeBackGround(2)
            fillMyWallet()

        }

        binding.profileBT.setOnClickListener {
//            onChangeBackGround(3)
            fillUserProfile()
        }

        binding.myLottriesLt.setOnClickListener {
//            onChangeBackGround(3)
            fillMyLottries()
        }
    }

    private fun fillCompetetions() {

//        onChangeBackGround(1)

        binding.tvAppBarTitle.text = "Competetions"

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, CompetitionsFragment())
            .commit()
    }

    private fun fillMyWallet() {

//        onChangeBackGround(1)

        binding.tvAppBarTitle.text = "My Wallet"

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, WalletFragment())
            .commit()
    }

    private fun fillMyLottries() {

//        onChangeBackGround(1)

        binding.tvAppBarTitle.text = "My Lottries"

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, MyLottriesFragment())
            .commit()
    }

    private fun fillUserProfile() {

//        onChangeBackGround(1)

        binding.tvAppBarTitle.text = "Profile"

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, UserProfileFragment())
            .commit()
    }


    private fun onChangeBackGround(mSelectedItem: Int) {
        when (mSelectedItem) {
            1 -> {
                binding.myJobBT.setBackgroundResource(R.drawable.baseline_delete_24)
                binding.icPostedWork.setImageResource(R.drawable.baseline_account_circle_24)
                val textColor1 = ContextCompat.getColor(this, R.color.navi_bar_text)
                binding.tvPostedWork.setTextColor(textColor1)

                binding.postJobBT.background = null
                binding.icPostWork.setImageResource(R.drawable.baseline_account_circle_24)
                val textColor2 = ContextCompat.getColor(this, R.color.black)
                binding.tvPostWork.setTextColor(textColor2)

                binding.profileBT.background = null
                binding.icProfile.setImageResource(R.drawable.baseline_account_circle_24)
                val textColor3 = ContextCompat.getColor(this, R.color.black)
                binding.tvPostedWork.setTextColor(textColor3)
            }

            2 -> {
                binding.myJobBT.background = null
                binding.icPostedWork.setImageResource(R.drawable.baseline_account_circle_24)
                val textColor1 = ContextCompat.getColor(this, R.color.black)
                binding.tvPostedWork.setTextColor(textColor1)

                binding.postJobBT.setBackgroundResource(R.drawable.baseline_account_circle_24)
                binding.icPostWork.setImageResource(R.drawable.baseline_account_circle_24)
                val textColor2 = ContextCompat.getColor(this, R.color.navi_bar_text)
                binding.tvPostWork.setTextColor(textColor2)

                binding.profileBT.background = null
                binding.icProfile.setImageResource(R.drawable.baseline_account_circle_24)
                val textColor3 = ContextCompat.getColor(this, R.color.black)
                binding.tvPostedWork.setTextColor(textColor3)
            }

            3 -> {
                binding.myJobBT.background = null
                binding.icPostedWork.setImageResource(R.drawable.baseline_account_circle_24)
                val textColor1 = ContextCompat.getColor(this, R.color.black)
                binding.tvPostedWork.setTextColor(textColor1)

                binding.postJobBT.background = null
                binding.icPostWork.setImageResource(R.drawable.baseline_account_circle_24)
                val textColor2 = ContextCompat.getColor(this, R.color.black)
                binding.tvPostWork.setTextColor(textColor2)

                binding.profileBT.setBackgroundResource(R.drawable.baseline_account_circle_24)
                binding.icProfile.setImageResource(R.drawable.baseline_account_circle_24)
                val textColor3 = ContextCompat.getColor(this, R.color.navi_bar_text)
                binding.tvPostedWork.setTextColor(textColor3)
            }
        }

    }

}