package com.example.apitodolist.model

data class TodoListApiData(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)