package com.example.randomuserchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomuserchallenge.databinding.ActivityMainBinding

//TODO: update icon
//TODO: create detail activity
//TODO: implement click listener
//TODO: use intent to pass user to detail activity
class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter

    private val TAG = "MainActivity"
    private val dataUrl = "https://randomuser.me/api/?format=json"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate called")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.userListRecyclerView
        Log.d(TAG, "recyclerView bound")
        adapter = UserAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        Log.d(TAG, "adapter and layout manager assigned")
        MoshiHelper.buildMoshi()
        refreshData()
    }

    private fun refreshData() {
        Log.d(TAG, "refreshData called")
        userViewModel.retrieveData(dataUrl)
        userViewModel.userList.observe(this){list ->
            if (list.isEmpty()) {
                binding.listTitle.text=getString(R.string.no_items_error)
            }else binding.listTitle.text= getString(R.string.list_of_users)
            adapter.update(list)
        }
    }
}