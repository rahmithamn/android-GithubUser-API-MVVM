package com.rmn.githubapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_profile.view.*

class UserAdapter(private val listHero: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(user.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                tv_item_name.text = user.name

            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_profile, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listHero[position])
    }


}
