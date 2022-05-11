package com.developeralamin.whatsappclone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.developeralamin.whatsappclone.adapter.ChartAdapter
import com.developeralamin.whatsappclone.databinding.FragmentChatBinding
import com.developeralamin.whatsappclone.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList


class ChatFragment : Fragment() {

    lateinit var binding: FragmentChatBinding
    private var database: FirebaseDatabase? = null
    lateinit var userlist: ArrayList<UserModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentChatBinding.inflate(layoutInflater)

        database = FirebaseDatabase.getInstance()
        userlist = ArrayList()

        database!!.reference.child("users")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    userlist.clear()

                    for (snapshot1 in snapshot.children) {
                        val user = snapshot1.getValue(UserModel::class.java)
                        if (user!!.uid != FirebaseAuth.getInstance().uid) {
                            userlist.add(user)
                        }
                    }

//                    binding.userlistRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//                    binding.userlistRecyclerView.adapter = ChartAdapter(requireContext(), userlist)

                    binding.userlistRecyclerView.adapter = ChartAdapter(requireContext(), userlist)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

        return binding.root

    }
}