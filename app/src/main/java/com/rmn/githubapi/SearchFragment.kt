package com.rmn.githubapi

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_detail_user.*
import kotlinx.android.synthetic.main.fragment_search.*
import okhttp3.*
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {
    private val list = ArrayList<User>()
    private val displayList = ArrayList<User>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_search, container, false)
    }
    fun getListUser(): ArrayList<User> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataUsername = resources.getStringArray(R.array.data_username)
        val dataFollower = resources.getIntArray(R.array.data_follower)
        val dataFollowing = resources.getIntArray(R.array.data_following)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listUser = ArrayList<User>()
        val listSearch = ArrayList<User>()

        for (position in dataName.indices) {
                val user = User(
                    dataName[position],
                    dataUsername[position],
                    dataFollower[position],
                    dataFollowing[position],
                    dataPhoto[position]
                )
                listUser.add(user)
                displayList.addAll(listUser)
        }
        return listUser
    }


    private fun showRecyclerList() {
        rv_user.layoutManager = LinearLayoutManager(this.requireContext())
        val listHeroAdapter = UserAdapter(displayList)
        rv_user.adapter = listHeroAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_user.setHasFixedSize(true)
        list.addAll(getListUser())
        showRecyclerList()

        if (search != null){
            search.queryHint = resources.getString(R.string.search_hint)
            search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    Toast.makeText(this@SearchFragment.requireContext(), query, Toast.LENGTH_SHORT).show()
                    return true
                }
                override fun onQueryTextChange(newText: String): Boolean {
                    if (newText!!.isNotEmpty()){
                        displayList.clear()
                        val searchEntered = newText.toLowerCase()
                        list.forEach {
                            if (it.name.toLowerCase().contains(searchEntered)){
                                displayList.add(it)
                            }
                        }
                        rv_user.adapter!!.notifyDataSetChanged()
                    }else {
                        displayList.clear()
                        displayList.addAll(list)
                        rv_user.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }
            })
        }


    }

}
