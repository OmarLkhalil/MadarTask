package com.omarlkhalil.madartask.views.display_users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.omarlkhalil.domain.entity.MadarUser
import com.omarlkhalil.madartask.databinding.ItemUsersBinding


class ItemUsersAdapter :
    ListAdapter<MadarUser, ItemUsersAdapter.UserViewHolder>(DiffCallback()) {

    inner class UserViewHolder(private val binding: ItemUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: MadarUser) = with(binding) {
            tvName.text = user.name.orEmpty()
            tvAge.text = buildString { append(user.age) }
            tvJobtitle.text = user.jobtitle.orEmpty()
            tvGender.text = user.gender.orEmpty()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUsersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    class DiffCallback : DiffUtil.ItemCallback<MadarUser>() {
        override fun areItemsTheSame(oldItem: MadarUser, newItem: MadarUser): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MadarUser, newItem: MadarUser): Boolean {
            return oldItem == newItem
        }
    }
}
