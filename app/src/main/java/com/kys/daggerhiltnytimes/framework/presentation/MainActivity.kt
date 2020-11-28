package com.kys.daggerhiltnytimes.framework.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kys.daggerhiltnytimes.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}



















