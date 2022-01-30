package com.creativaties.dxapp.data.repo

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.creativaties.dxapp.data.model.News
import com.creativaties.dxapp.data.network.Myapi
import com.creativaties.dxapp.data.network.Networking
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo  {

    private lateinit var compositeDisposable : CompositeDisposable

    fun userRepoData() : LiveData<List<News.Article>> {


        compositeDisposable = CompositeDisposable()
        val loginResponse = MutableLiveData<List<News.Article>>()

        compositeDisposable.add(
            Networking.create()
                .queryNews("683b94ba98424ff291aacd5456ccd087","us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if ( it != null) {
                        loginResponse.value = it.articles
                    }
                    else{
                        //
                    }
                },{

//                    AppUtils.showToast(this, it.message.toString(), true)
                    if (it is HttpException) {
//                        loginResponse.value = it.message().toString()
                        val body: ResponseBody = it.response().errorBody()!!
                        val error=body.string()
                        when(it.code()){
                            401-> {
                                //User token has been expired
                            }
                            422->{
                                val jsonObject = JSONObject(error)
                                if (jsonObject.has("errors")){
                                    val errors = jsonObject.getJSONObject("errors")

//                                    loginResponse.value = error.toString()
                               //error
                                }
                            }
                        }

                    }

                }))


return loginResponse

    }
}