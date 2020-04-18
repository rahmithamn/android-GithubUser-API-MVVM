package com.rmn.githubapi


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_search.*
import okhttp3.*
import java.io.IOException


@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    private val list = ArrayList<User>()
    private val displayList = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.setting -> {

                return true
            }
            else -> return true
        }
    }



}
