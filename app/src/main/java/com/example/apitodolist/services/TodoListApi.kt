package com.example.apitodolist.services

import com.example.apitodolist.model.TodoListApiData
import retrofit2.Response
import retrofit2.http.GET

interface TodoListApi {
    @GET("/posts")
   suspend fun getTodos():Response<List<TodoListApiData>>
}