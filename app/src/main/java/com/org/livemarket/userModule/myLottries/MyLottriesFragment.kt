package com.org.livemarket.userModule.myLottries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.org.livemarket.R
import com.org.livemarket.databinding.FragmentCompetitionsBinding
import com.org.livemarket.databinding.FragmentMyLottriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyLottriesFragment : Fragment() {

    private lateinit var binding: FragmentMyLottriesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_my_lottries, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}