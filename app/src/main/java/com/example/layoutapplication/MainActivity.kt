package com.example.layoutapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layoutapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //deklarasi lateinit var untuk binding, yang akan digunakan untuk mengakses elemen UI di layout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {super.onCreate(savedInstanceState)
        //inflate layout menggunakan binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //menggunakan binding untuk mengatur adapter dan tablayout pada layout
        with(binding){
            //mengatur adapter untuk viewPager menggunakan TabAdapter
            viewPager.adapter = LoginFragment.TabAdapter(supportFragmentManager)
            //menghubungkan tabLayout dengan viewPager
            tabLayout.setupWithViewPager(viewPager)
        }
    }
}