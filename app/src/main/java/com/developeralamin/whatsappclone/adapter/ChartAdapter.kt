package com.developeralamin.whatsappclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.developeralamin.whatsappclone.R
import com.developeralamin.whatsappclone.databinding.ChartUserItemBinding
import com.developeralamin.whatsappclone.model.UserModel

class ChartAdapter(var context: Context, var list: ArrayList<UserModel>) :
    RecyclerView.Adapter<ChartAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding: ChartUserItemBinding = ChartUserItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.chart_user_item, parent, false))

    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {

        var user = list[position]
        Glide.with(context).load(user.imageUrl).into(holder.binding.userImage)
        holder.binding.userName.text = user.name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}