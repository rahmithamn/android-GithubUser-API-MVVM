package com.rmn.githubapi

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionPageAdapter(private val mContext: Context, fm: FragmentManager?) : FragmentPagerAdapter(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val TAB_TITLES = intArrayOf(R.string.tab_title_following, R.string.tab_title_followers)

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = DetailUserFragment()
            1 -> fragment = DetailUserFragment.newInstance(position + 1)
        }
        return fragment as Fragment
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}