package com.rmn.githubapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_detail_user.*


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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var index = 1
        if (getArguments() != null) {
            index = arguments?.getInt(ARG_SECTION_NUMBER, 0) as Int
        }

    }

}
