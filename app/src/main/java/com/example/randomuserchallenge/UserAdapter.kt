package com.example.randomuserchallenge

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val listener: ItemListener): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    private val TAG = "UserAdapter"
    private val userList: MutableList<User> = mutableListOf()

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        Log.d(TAG, "onCreateViewHolder new view requested")
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(adapterLayout, listener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder called")
        val userItem = userList[position]
        holder.bindView(userItem)
    }

    override fun getItemCount() = userList.size

    //NB: I know this is generally bad practice, but in this case this is actually the notification we want to use!
    //TODO: look up adapterset stable IDs
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

    interface ItemListener {
        fun viewUserDetails(clickedUser: User)
    }

    class UserViewHolder(view: View, val listener: ItemListener): RecyclerView.ViewHolder(view){
        //TODO: list all the things we want to display here
        val nameView: TextView = view.findViewById(R.id.name_view)
        lateinit var targetUser:User

        init{
            view.setOnClickListener(){
                listener.viewUserDetails(targetUser)
            }
        }

        fun bindView(user: User){
            targetUser = user
            Log.d("USERVIEWHOLDER", targetUser.name.first)
            nameView.text=targetUser.name.first
        }
    }
}