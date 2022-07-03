package com.example.apitodolist.ui.utilits
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apitodolist.databinding.ActivityTodoListBinding
import com.example.apitodolist.services.RetrofitInstanceTodoListApi

import retrofit2.HttpException
import java.io.IOException

class TodoListApiActivity : AppCompatActivity() {
    private lateinit var todoListApiAdapter: TodoListApiAdapter

    private lateinit var binding: ActivityTodoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView() // Calling the view

        lifecycleScope.launchWhenCreated {
            binding.ProgressBarTodoListApi.isVisible = true // Show Progress Bar
            val response = try {
                RetrofitInstanceTodoListApi.api.getTodos() // Getting List of Todos Data
            } catch (e: IOException) {
                Log.d("TodoListApiActivity", "You may have no internet connection")
                binding.ProgressBarTodoListApi.isVisible = false // Disable Progress Bar
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.d("TodoListApiActivity", "Unexpected Response")
                binding.ProgressBarTodoListApi.isVisible = false // Disable Progress Bar
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                todoListApiAdapter.posts = response.body()!!
            } else {
                Log.d("TodoListApiActivity", "Response is not successful")
            }
            binding.ProgressBarTodoListApi.isVisible = false // Disable Progress Bar


        }

    }

    private fun setupRecyclerView() = binding.rvTodoListApi.apply {
        todoListApiAdapter = TodoListApiAdapter()
        adapter = todoListApiAdapter
        layoutManager = LinearLayoutManager(this@TodoListApiActivity)
    }
}