package com.example.randomuserchallenge

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val listener: ItemListener) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val userList: MutableList<User> = mutableListOf()

    init {
        this.setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(adapterLayout, listener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userItem = userList[position]
        holder.bindView(userItem)
    }

    override fun getItemCount() = userList.size

    override fun getItemId(position: Int): Long {
        return userList[position].hashCode().toLong()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(newList: List<User>) {
        if (newList.isNotEmpty()) {
            userList.clear()
            userList.addAll(newList)
            notifyDataSetChanged()
        }
    }

    interface ItemListener {
        fun viewUserDetails(clickedUser: User)
    }

    class UserViewHolder(view: View, private val listener: ItemListener) :
        RecyclerView.ViewHolder(view) {
        private val firstNameView: TextView = view.findViewById(R.id.firstname_view)
        private val lastNameView: TextView = view.findViewById(R.id.lastname_view)
        private val thumbnailView: ImageView = view.findViewById(R.id.user_thumbnail)

        private lateinit var targetUser: User

        init {
            view.setOnClickListener {
                listener.viewUserDetails(targetUser)
            }
        }

        fun bindView(user: User) {
            targetUser = user
            firstNameView.text = targetUser.name.first
            lastNameView.text = targetUser.name.last
            ImageHelper.loadImage(targetUser.picture.thumbnail, thumbnailView)
        }
    }
}