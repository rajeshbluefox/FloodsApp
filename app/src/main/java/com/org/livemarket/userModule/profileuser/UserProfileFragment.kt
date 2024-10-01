package com.org.livemarket.userModule.profileuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.org.livemarket.R
import com.org.livemarket.databinding.FragmentCompetitionsBinding
import com.org.livemarket.databinding.FragmentUserProfileBinding
import com.org.livemarket.loginModule.supportFunctions.LogoutDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserProfileFragment : Fragment() {

    private lateinit var binding: FragmentUserProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        onClickListeners()
    }

    private fun onClickListeners()
    {
        binding.btLogout.setOnClickListener {
            logoutDialog.openLogoutDialog("Are you sure you want to logout?")
        }

        binding.btChangePassword.setOnClickListener {
            //goto change password activity
        }
    }

    private lateinit var logoutDialog: LogoutDialog

    private fun initViews()
    {
        logoutDialog= LogoutDialog(layoutInflater,requireContext(),::onLogoutClicked)

    }

    private fun onLogoutClicked()
    {
        //goto login activity
    }

}