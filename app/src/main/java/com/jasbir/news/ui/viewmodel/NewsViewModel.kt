package com.jasbir.news.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.jasbir.news.data.remote.repo.UserRepo

class NewsViewModel( ) : ViewModel() {


    val liveupdate = UserRepo().userRepoData()


}