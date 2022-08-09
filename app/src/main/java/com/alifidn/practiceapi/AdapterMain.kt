package com.alifidn.practiceapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alifidn.practiceapi.data.MainItem
import com.alifidn.practiceapi.databinding.UserItemsBinding
import com.bumptech.glide.Glide

class AdapterMain : RecyclerView.Adapter<AdapterMain.MainViewHolder>() {

    private val listUser = ArrayList<MainItem>()

    class MainViewHolder(val itemUser: UserItemsBinding) : RecyclerView.ViewHolder(itemUser.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder = MainViewHolder(
        UserItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemUser.apply {
            with(listUser[position]) {
                tvName.text = login
                Glide.with(imgAvatar.context).load(avatarUrl).into(imgAvatar)
            }
        }
    }

    override fun getItemCount(): Int = listUser.size

    fun setUser(user : ArrayList<MainItem>) {
        this.listUser.clear()
        this.listUser.addAll(user)
    }
}