package com.developeralamin.whatsappclone.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.developeralamin.whatsappclone.R
import com.developeralamin.whatsappclone.activity.ChartActivity
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

//        holder.itemView.setOnClickListener {
//            val intent = Intent(context, ChartActivity::class.java)
//            intent.putExtra("uid", list[position].uid)
//            context.startActivity(intent)
//        }

        holder.itemView.setOnClickListener {
//            val intent = Intent(context, ChartActivity::class.java)
//            intent.putExtra("uid", user.uid)
//            context.startActivity(intent)

            val intent = Intent(context, ChartActivity::class.java)
            intent.putExtra("uid",list[position].uid)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}