package com.creativaties.dxapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.creativaties.dxapp.Adapter.NewsAdapter
import com.creativaties.dxapp.R
import com.creativaties.dxapp.data.model.News
import com.creativaties.dxapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , Api {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        val viewModel = ViewModelProviders.of(this).get(FontViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.callback = this

        viewModel.liveupdate.observe(this, Observer {new->

            rvSuper.also {
                it.layoutManager = LinearLayoutManager(this)
                it.setHasFixedSize(true)
                it.adapter = NewsAdapter(new)
            }

        })
    }

    override fun onStarted() {
    }

    override fun onSuccess(loginResponse: LiveData<List<News.Article>>) {

    }

    override fun onFailed(message: String) {

    }


}