package com.creativaties.dxapp.ui

import androidx.lifecycle.LiveData
import com.creativaties.dxapp.data.model.News

interface Api {

    fun onStarted()
    fun onSuccess(loginResponse: LiveData<List<News.Article>>)
    fun onFailed(message : String)
}