package com.yuriycode.lifecyclertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val liveDataString = MutableLiveData<String>()
    private val liveDataString1 = MutableLiveData<String>()
    private val mediatorLiveDataString = MediatorLiveData<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        liveDataString.value = "string"
        liveDataString1.value = "string1"

        mediatorLiveDataString.addSource(liveDataString) {
            number_text.text = it
        }

        mediatorLiveDataString.addSource(liveDataString1){
            number_text1.text = it
        }

        mediatorLiveDataString.observe(this, Observer {

        })


        button_save1.setOnClickListener {
            liveDataString.value = edit_text.text.toString()
        }
        button_save2.setOnClickListener {
            liveDataString1.value = edit_text.text.toString()
        }
    }
    }