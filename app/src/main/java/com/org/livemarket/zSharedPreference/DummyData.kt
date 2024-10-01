package com.org.livemarket.zSharedPreference

import com.org.livemarket.adminModule.blockUser.modalClass.UserData
import com.org.livemarket.userModule.competitions.modalClass.CompetitionData
import com.org.livemarket.userModule.mywallet.modalClass.DepositData
import com.org.livemarket.userModule.mywallet.modalClass.WithdrawAmountData

object DummyData {
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


    fun getDummyWithdrawAmountData(): ArrayList<WithdrawAmountData> {
        val withdrawList = ArrayList<WithdrawAmountData>()

        withdrawList.add(
            WithdrawAmountData(
                withDrawId = 1,
                amount = "5000",
                mode = 1, // 1 for UPI
                upiId = "user@upi",
                accHolderName = "",
                accNumber = "",
                ifsccode = "",
                bankName = "",
                date = "2024-09-25",
                status = 1 // 1 for Pending
            )
        )

        withdrawList.add(
            WithdrawAmountData(
                withDrawId = 2,
                amount = "10000",
                mode = 2, // 2 for Bank Transfer
                upiId = "",
                accHolderName = "John Doe",
                accNumber = "1234567890",
                ifsccode = "IFSC12345",
                bankName = "State Bank of India",
                date = "2024-09-26",
                status = 2 // 2 for Completed
            )
        )

        withdrawList.add(
            WithdrawAmountData(
                withDrawId = 3,
                amount = "2000",
                mode = 1, // 1 for UPI
                upiId = "anotheruser@upi",
                accHolderName = "",
                accNumber = "",
                ifsccode = "",
                bankName = "",
                date = "2024-09-27",
                status = 3 // 3 for Failed
            )
        )

        withdrawList.add(
            WithdrawAmountData(
                withDrawId = 4,
                amount = "7500",
                mode = 2, // 2 for Bank Transfer
                upiId = "",
                accHolderName = "Jane Doe",
                accNumber = "9876543210",
                ifsccode = "IFSC54321",
                bankName = "HDFC Bank",
                date = "2024-09-28",
                status = 1 // 1 for Pending
            )
        )

        return withdrawList
    }


    fun getDummyDepositData(): ArrayList<DepositData> {
        val depositList = ArrayList<DepositData>()

        depositList.add(
            DepositData(
                depositId = 1,
                amount = "1000",
                referenceNo = "REF12345",
                date = "2023-09-01",
                status = "Pending"
            )
        )

        depositList.add(
            DepositData(
                depositId = 2,
                amount = "1500",
                referenceNo = "REF12346",
                date = "2023-09-02",
                status = "Completed"
            )
        )

        depositList.add(
            DepositData(
                depositId = 3,
                amount = "2000",
                referenceNo = "REF12347",
                date = "2023-09-03",
                status = "Failed"
            )
        )

        depositList.add(
            DepositData(
                depositId = 4,
                amount = "2500",
                referenceNo = "REF12348",
                date = "2023-09-04",
                status = "Pending"
            )
        )

        return depositList
    }


    fun getDummyUserData(): ArrayList<UserData> {
        val userList = ArrayList<UserData>()

        userList.add(
            UserData(
                userId = 1,
                userName = "John Smith",
                phoneNumber = "9876543210",
                status = 1 // 1 for Active
            )
        )

        userList.add(
            UserData(
                userId = 2,
                userName = "Alice Johnson",
                phoneNumber = "9123456789",
                status = 0 // 0 for Inactive
            )
        )

        userList.add(
            UserData(
                userId = 3,
                userName = "Michael Brown",
                phoneNumber = "9988776655",
                status = 1 // 1 for Active
            )
        )

        userList.add(
            UserData(
                userId = 4,
                userName = "Jessica Davis",
                phoneNumber = "9871234567",
                status = 0 // 0 for Inactive
            )
        )

        return userList
    }



}