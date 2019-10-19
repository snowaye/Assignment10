package com.padc.batch9.assignment10.activity


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.fragment.*
import com.padc.batch9.assignment10.util.Utils

class MainActivity : BaseActivity() {


    private lateinit var fragmentManager: FragmentManager
    private lateinit var navView: BottomNavigationView
    private lateinit var view: View
    private val mNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
            menuItem ->
        when (menuItem.itemId){
            R.id.nav_home -> {
                val fragment = HomeFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_search -> {
                val fragment = SearchFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_coming_soon -> {
                val fragment = ComingSoonFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_download -> {
                val fragment = DownloadFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_more -> {
                val fragment = MoreFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                val fragment = HomeFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        navView = findViewById(R.id.nav_view)
        Utils.setStatusBarColor(this, R.color.colorPrimary)
        val fragment = HomeFragment()
        loadFragment(fragment)
        navView.setOnNavigationItemSelectedListener(mNavigationItemSelectedListener)
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
