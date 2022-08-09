package com.alifidn.practiceapi.practice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alifidn.practiceapi.databinding.UserPracticeItemBinding
import com.alifidn.practiceapi.practice.data.PracticeUserResponseItem

class AdapterUser : RecyclerView.Adapter<AdapterUser.UserViewHolder>() {

    private val listPracticeUsers = ArrayList<PracticeUserResponseItem>()

    class UserViewHolder(val userBinding: UserPracticeItemBinding) : RecyclerView.ViewHolder(userBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder = UserViewHolder(
        UserPracticeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userBinding.apply {
            with(listPracticeUsers[position]) {
                tvName.text = name
                tvEmail.text = email
                tvUsername.text = username
            }
        }
    }

    override fun getItemCount(): Int = listPracticeUsers.size

    fun setPracticeUser(user : ArrayList<PracticeUserResponseItem>) {
        this.listPracticeUsers.clear()
        this.listPracticeUsers.addAll(user)
    }
}