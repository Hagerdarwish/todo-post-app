package com.example.apitodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apitodolist.databinding.ActivityTodoListBinding

class todoList : AppCompatActivity() {
    private lateinit var binding: ActivityTodoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTodoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}