package com.example.randomuserchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomuserchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter

    private val dataUrl = "https://randomuser.me/api/?format=json&results=100&noinfo&nat=us"

    private val adapterListener = object : UserAdapter.ItemListener {
        override fun viewUserDetails(clickedUser: User) {
            val userDetailFragment = DetailDialogFragment.newInstance(clickedUser)
            userDetailFragment.show(supportFragmentManager, "User details")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.userListRecyclerView
        adapter = UserAdapter(adapterListener)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        MoshiHelper.buildMoshi()
        refreshData()
    }

    private fun refreshData() {
        userViewModel.retrieveData(dataUrl)
        userViewModel.userList.observe(this) { list ->
            if (list.isEmpty()) {
                binding.listTitle.text = getString(R.string.no_items_error)
            } else binding.listTitle.text = getString(R.string.list_of_users)
            adapter.update(list)
        }
    }
}