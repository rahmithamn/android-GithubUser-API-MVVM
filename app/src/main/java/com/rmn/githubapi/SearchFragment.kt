package com.rmn.githubapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_detail_user.*
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {
    private val list = ArrayList<User>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
    fun getListUser(): ArrayList<User> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataUsername = resources.getStringArray(R.array.data_username)
        val dataFollower = resources.getIntArray(R.array.data_follower)
        val dataFollowing = resources.getIntArray(R.array.data_following)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listUser = ArrayList<User>()
        for (position in dataName.indices) {
            val user = User(
                dataName[position],
                dataUsername[position],
                dataFollower[position],
                dataFollowing[position],
                dataPhoto[position]
            )
            listUser.add(user)
        }
        return listUser
    }

    private fun showRecyclerList() {
        rv_user.layoutManager = LinearLayoutManager(this.requireContext())
        val listHeroAdapter = UserAdapter(list)
        rv_user.adapter = listHeroAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_user.setHasFixedSize(true)
        list.addAll(getListUser())
        showRecyclerList()
    }
}
