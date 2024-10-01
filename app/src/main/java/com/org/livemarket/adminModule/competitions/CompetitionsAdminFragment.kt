package com.org.livemarket.adminModule.competitions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.livemarket.R
import com.org.livemarket.adminModule.competitions.supportFunctions.CompAdminUI
import com.org.livemarket.databinding.FragmentCompetitionsAdminBinding
import com.org.livemarket.userModule.competitions.modalClass.CompetitionData
import com.org.livemarket.userModule.competitions.modalClass.SelCompetition
import com.org.livemarket.userModule.competitions.supportFunctions.CompetitionsAdapter
import com.org.livemarket.zSharedPreference.DummyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompetitionsAdminFragment : Fragment() {

    private lateinit var binding: FragmentCompetitionsAdminBinding

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
                R.layout.fragment_competitions_admin,
                container,
                false
            )

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        competitionList = DummyData.getDummyCompetitionData()
        initCompList(competitionList)
    }

    private lateinit var compAdminUI: CompAdminUI

    private fun initViews()
    {
        compAdminUI= CompAdminUI(requireContext(),layoutInflater,binding,::onTabSelected)
    }

    private fun onTabSelected(selectedTab: Int)
    {
        //get Competition List based on selected tab
    }

    private var competitionList = ArrayList<CompetitionData>()

    private fun initCompList(compList: List<CompetitionData>) {

        val jobsAdapter = CompetitionsAdapter(requireContext(), compList, ::onCompetitionClicked)
        binding.rvComp.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            adapter = jobsAdapter
        }

    }

    private fun onCompetitionClicked(compItem: CompetitionData) {

        SelCompetition.competitionData=compItem
        //goto ComDetails Screen
    }
}