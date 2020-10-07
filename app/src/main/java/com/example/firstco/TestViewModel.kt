package com.example.firstco

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstco.TestApi.ApiClient
import com.example.firstco.TestApi.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestViewModel() : ViewModel() {

    var listU = MutableLiveData<List<User>>()
    var listUser = MutableLiveData<java.util.List<User>?>()
    private var clickCount:Int =0
    var countLiveData= MutableLiveData<Int>()
    //var userLiveData : List<User>? = null

    open fun getInitialcount():MutableLiveData<Int>{
        countLiveData.value=clickCount
        return countLiveData
    }

    open fun getCurrentCount(){
        clickCount+=1
        countLiveData.value=clickCount
    }

    open fun getDataUser(): MutableLiveData<List<User>> {
        ///this.listU.value =
        return listU
    }

    open fun getUserDump(): MutableLiveData<java.util.List<User>?> {

        return listUser
    }

    open fun setDataUser(){
        val UserList: Call<java.util.List<User>> = ApiClient().getUser().getAllUser()

        UserList.enqueue(object : Callback<java.util.List<User>> {
            override fun onResponse(call: Call<java.util.List<User>>, response: Response<java.util.List<User>>) {
                if (response.code() == 200) {

                    //listU.value  = response?.body()?.get(0)?.first_name//.toString()
                    var aaaa = response?.body()?.toList()

                    listUser.value = response.body()

                    listU.value  = aaaa


                }
            }

            override fun onFailure(call: Call<java.util.List<User>>, t: Throwable) {
                Log.e("Failure",t.localizedMessage)
                //userLiveData = null

            }
        })




    }





    }






