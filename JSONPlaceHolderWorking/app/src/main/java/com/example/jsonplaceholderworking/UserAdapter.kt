package com.example.jsonplaceholderworking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholderworking.data.User
import com.example.jsonplaceholderworking.databinding.UserLayoutBinding

class UserAdapter(
    private val onUserClick: (user: User, position: Int) -> Unit
) : ListAdapter<User, UserAdapter.ViewHolder>(DiffUserCallBack()){

    private lateinit var binding: UserLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.user_layout, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(getItem(position),onUserClick)
    }

    inner class ViewHolder(private val binding: UserLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: User, onUserClick: (user: User, position: Int) -> Unit){
            binding.user = user
           itemView.setOnClickListener {
               onUserClick.invoke(user,adapterPosition)
           }
        }
    }

}

class DiffUserCallBack : DiffUtil.ItemCallback<User>(){
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

}