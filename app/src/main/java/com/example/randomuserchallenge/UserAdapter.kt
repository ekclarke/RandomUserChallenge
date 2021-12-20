package com.example.randomuserchallenge

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
        private val TAG = "UserAdapter"
    private val userList: MutableList<User> = mutableListOf()

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view){
        //TODO: bind all the things we want to display here
        val nameView: TextView = view.findViewById(R.id.name_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        Log.d(TAG, "onCreateViewHolder new view requested")
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder called")
        val userItem = userList[position]
        //TODO: implement intent with passing the ID
        Log.d(TAG, userItem.name.first)
        holder.nameView.text=userItem.name.first
    }

    override fun getItemCount() = userList.size

    //NB: I know this is generally bad practice, but in this case this is actually the notification we want to use!
    @SuppressLint("NotifyDataSetChanged")
    fun update(newList: List<User>){
        Log.d(TAG, "update called")
        //TODO: implement a more elegant list update function
        if (newList.isNotEmpty()){
            userList.clear()
            userList.addAll(newList)
            notifyDataSetChanged()
        }
    }
}