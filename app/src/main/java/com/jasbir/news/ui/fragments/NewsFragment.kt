package com.jasbir.news.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jasbir.news.R
import com.jasbir.news.ui.adapter.ViewPagerAdapter
import com.jasbir.news.ui.viewmodel.NewsViewModel
import com.jasbir.news.util.VerticalViewPager

class NewsFragment : Fragment() {
    private lateinit var viewPager: VerticalViewPager
    private lateinit var newsAdapter : ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        viewPager = view.findViewById(R.id.verticalViewpager)
        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        viewModel.liveupdate.observe(requireActivity(), Observer {new->
            new
            newsAdapter = ViewPagerAdapter(requireContext(),new)
            viewPager.adapter = newsAdapter

        })

        return view
    }

}