package com.jasbir.news.ui.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jasbir.news.R
import com.jasbir.news.ui.adapter.ViewPagerAdapter
import com.jasbir.news.ui.fragments.NewsFragment
import com.jasbir.news.ui.viewmodel.NewsViewModel
import com.jasbir.news.util.VerticalViewPager



class MainActivity : AppCompatActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.app_theme)
        setContentView(R.layout.activity_main)
        changeFragment(NewsFragment())
    }

    private fun changeFragment( fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val ft = fragmentManager.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.commit()
    }


}