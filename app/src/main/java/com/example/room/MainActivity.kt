package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.room.database.DatabaseManager
import com.example.room.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mainViewModel.saveUser(User(
//            "Userid0002",
//            "name0002",
//            1.72,
//            72.2,
//            "user0002@gmail.com",
//            "pass0002"
//        ) )

        mainViewModel.getUsers()

        mainViewModel.savedUsers.observe(this, {usersList ->
            if (!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("Thesearetheusers", user.user_name)
                    Log.d("Thesearetheusers", user.user_email)
                    Log.d("Thesearetheusers", user.user_password)
                }
            }else{
                Log.d("thesearetheusers", "null or empty")
            }
        })

    }
}