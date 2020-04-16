package com.rmn.githubapi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.fragment_detail_user.*
import kotlinx.android.synthetic.main.item_row_profile.*
import org.json.JSONObject


/**
 * A simple [Fragment] subclass.
 */
@Suppress("UNREACHABLE_CODE")
class DetailUserFragment : Fragment() {
    companion object {
        private val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(index: Int): DetailUserFragment {
            val fragment = DetailUserFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_SECTION_NUMBER, index)
            fragment.arguments = bundle
            return fragment
        }

    }

    private val list = ArrayList<User>()
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_user, container, false)
        tabLayout = view.findViewById(R.id.tabs) as TabLayout
        viewPager = view.findViewById(R.id.view_pager) as ViewPager
        viewPager!!.setAdapter(SectionPageAdapter(this.requireContext(), fragmentManager))
        tabLayout!!.post(Runnable { tabLayout!!.setupWithViewPager(viewPager) })
        return view


        //return inflater.inflate(R.layout.fragment_detail_user, container, false)
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
        re_user.layoutManager = LinearLayoutManager(this.requireContext())
        val listHeroAdapter = UserAdapter(list)
        re_user.adapter = listHeroAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var index = 1
        if (getArguments() != null) {
            index = arguments?.getInt(ARG_SECTION_NUMBER, 0) as Int
        }
        re_user.setHasFixedSize(true)
        list.addAll(getListUser())
        showRecyclerList()

    }
}