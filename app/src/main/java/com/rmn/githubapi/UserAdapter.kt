package com.rmn.githubapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_profile.view.*

class UserAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(user.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                item_name.text = user.name
                item_username.text = user.username
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_profile, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listUser.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
    }


}
