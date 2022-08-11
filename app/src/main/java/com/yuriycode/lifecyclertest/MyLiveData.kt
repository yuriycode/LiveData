package com.yuriycode.lifecyclertest

import androidx.lifecycle.MutableLiveData

class MyLiveData: MutableLiveData<String>() {

    fun setValueToLiveData(string: String){
        value = string
    }

    override fun onActive() {
        super.onActive()
        println("onActive")
    }

    override fun onInactive() {
        super.onInactive()
        println("onInActive")
    }


}