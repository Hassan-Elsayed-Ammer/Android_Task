package com.example.android_task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.android_task.R
import com.example.android_task.adapter.UserListAdapter
import com.example.android_task.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.VISIBLE

        val userListAdapter = UserListAdapter()

        binding.recyclerView.apply {
            adapter = userListAdapter
            setHasFixedSize(true)
        }


        viewModel.userList.observe(this) { list ->
            userListAdapter.submitData(lifecycle,list)
            binding.progressBar.visibility = View.INVISIBLE

        }

    }
}