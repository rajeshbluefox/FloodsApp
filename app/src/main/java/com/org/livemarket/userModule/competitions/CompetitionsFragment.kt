package com.org.livemarket.userModule.competitions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.org.livemarket.R
import com.org.livemarket.databinding.FragmentCompetitionsBinding
import com.org.livemarket.userModule.competitions.modalClass.CompetitionData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompetitionsFragment : Fragment() {

    private lateinit var binding: FragmentCompetitionsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_competitions, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    fun getDummyCompetitionData(): ArrayList<CompetitionData> {
        val competitionList = ArrayList<CompetitionData>()

        // Dummy data
        competitionList.add(
            CompetitionData(
                competitionId = 1,
                name = "Competition 1",
                competitionImage = "https://example.com/image1.jpg",
                startRange = "01/09/2024",
                endRange = "30/09/2024",
                ticketCost = "50.0",
                withDrawDate = "05/10/2024",
                prizeCount = "3",
                dateOfPosting = "31/08/2024"
            )
        )

        competitionList.add(
            CompetitionData(
                competitionId = 2,
                name = "Competition 2",
                competitionImage = "https://example.com/image2.jpg",
                startRange = "01/10/2024",
                endRange = "31/10/2024",
                ticketCost = "75.0",
                withDrawDate = "05/11/2024",
                prizeCount = "5",
                dateOfPosting = "30/09/2024"
            )
        )

        competitionList.add(
            CompetitionData(
                competitionId = 3,
                name = "Competition 3",
                competitionImage = "https://example.com/image3.jpg",
                startRange = "01/11/2024",
                endRange = "30/11/2024",
                ticketCost = "100.0",
                withDrawDate = "05/12/2024",
                prizeCount = "2",
                dateOfPosting = "31/10/2024"
            )
        )

        // Add more dummy data if needed

        return competitionList
    }

}