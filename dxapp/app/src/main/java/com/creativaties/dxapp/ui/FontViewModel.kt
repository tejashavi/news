package com.creativaties.dxapp.ui

import androidx.lifecycle.ViewModel
import com.creativaties.dxapp.data.repo.UserRepo

class FontViewModel() : ViewModel() {


    var callback : Api?=null
    val liveupdate = UserRepo().userRepoData()

}