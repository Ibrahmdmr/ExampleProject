package com.example.jsonplaceholderworking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jsonplaceholderworking.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = ActivityMainBinding.inflate(layoutInflater)
       setContentView(dataBinding.root)
    }
}

