package com.example.apitodolist.ui.utilits

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.apitodolist.databinding.ItemTodolistapiBinding
import com.example.apitodolist.model.TodoListApiData

class TodoListApiAdapter :RecyclerView.Adapter<TodoListApiAdapter.TodoListApiViewHolder> (){

    inner class TodoListApiViewHolder(val binding: ItemTodolistapiBinding):RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object :DiffUtil.ItemCallback<TodoListApiData>(){
        override fun areItemsTheSame(oldItem: TodoListApiData, newItem: TodoListApiData): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: TodoListApiData, newItem: TodoListApiData): Boolean {
            return oldItem == newItem
        }
    }

    private val differ  = AsyncListDiffer(this,diffCallBack)
    var posts : List<TodoListApiData>
        get() = differ.currentList
        set(value) { differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListApiViewHolder {
        return TodoListApiViewHolder(ItemTodolistapiBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoListApiViewHolder, position: Int) {

        holder.binding.apply {
            val singleTodo =  posts[position]
            txTodoApiTilte.text = singleTodo.title

        }


    }

    override fun getItemCount() = posts.size

}