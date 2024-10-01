package com.org.livemarket.adminModule.blockUser.supportFunctions

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.org.livemarket.adminModule.blockUser.modalClass.UserData
import com.org.livemarket.databinding.ItemBlockUserBinding


class BlockUserAdapter(
    private var context: Context,
    private var usersList: List<UserData>,
    private val onBlockClicked: (userItem: UserData, isBlocked: Boolean) -> Unit,
) :
    RecyclerView.Adapter<BlockUserAdapter.BlockUserAdapterViewHolder>() {


    class BlockUserAdapterViewHolder(var binding: ItemBlockUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BlockUserAdapterViewHolder {
        return BlockUserAdapterViewHolder(
            ItemBlockUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: BlockUserAdapterViewHolder, position: Int) {

        val userItem = usersList[position]

        holder.binding.tvUserName.text = userItem.userName
        holder.binding.tvUserPhoneNumber.text = userItem.phoneNumber

        if (userItem.status == 1) //1 means Active , 0 means Blocked
        {
            holder.binding.btToggleBlock.text = "Block"
        } else {
            holder.binding.btToggleBlock.text = "UnBlock"
        }

        holder.binding.btToggleBlock.setOnClickListener {
            if (userItem.status == 1) //1 means Active , 0 means Blocked)
            {
                onBlockClicked.invoke(userItem, true)
            } else {
                onBlockClicked.invoke(userItem, false)
            }
        }

    }

    override fun getItemCount(): Int {
        return usersList.size
    }

}