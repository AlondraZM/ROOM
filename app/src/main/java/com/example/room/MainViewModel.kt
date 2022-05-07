package com.example.room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.database.DatabaseManager
import com.example.room.database.MyCoroutines
import com.example.room.database.MyCoroutines2
import com.example.room.database.User
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    fun saveUser(user: User){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines2(userDao).save(user)
        }
    }
    fun deleteUser(user: User){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines2(userDao).delete(user)
        }
    }
    val savedUsers = MutableLiveData<List<User>>()
    fun getUsers(){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            savedUsers.value = MyCoroutines2(userDao).getUsers().value
        }
    }
}