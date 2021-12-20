package com.example.randomuserchallenge

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
        private val TAG = "UserViewModel"

    private val _userList= MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> = _userList

    fun retrieveData(url: String){

        Log.d(TAG, "retrieveData called")
        val repository = UserRepository()

        val callback = object: UserRepository.Callback{
            override fun onComplete(pulledList: List<User>){
                _userList.postValue(pulledList)
            }
        }
        repository.getUsers(url, callback)
    }

}