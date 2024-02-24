package com.example.android_task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.android_task.databinding.UserListItemBinding
import com.example.android_task.model.Data


class UserListAdapter : PagingDataAdapter<Data, UserListAdapter.ImageViewHolder>(diffCallback) {


    inner class ImageViewHolder(
        val binding: UserListItemBinding
    ) :
        ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            UserListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currUser = getItem(position)

        holder.binding.apply {
            holder.itemView.apply {

                tvEmail.text = "${currUser?.email}"
                tvFirstName.text = "${currUser?.firstName}"
                tvLastName.text = "${currUser?.lastName}"
                tvId.text = "${"user id " + currUser?.id}"

                val imageLink = currUser?.avatar
                ivPic.load(imageLink) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }

    }


}