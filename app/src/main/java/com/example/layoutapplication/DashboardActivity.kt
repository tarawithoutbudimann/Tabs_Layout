package com.example.layoutapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.layoutapplication.databinding.ActivityDashboardBinding
import java.util.*

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var viewPager: ViewPager2
    private val images = listOf(
        R.drawable.slider1,
        R.drawable.slider2,
        R.drawable.slider3,
        R.drawable.slider4,
        R.drawable.slider5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager
        val imageSliderAdapter = ImageSliderAdapter(images)
        viewPager.adapter = imageSliderAdapter

        val timer = Timer()
        timer.scheduleAtFixedRate(ImageSliderTimer(images.size), 2000, 3000)

        // Mendapatkan nama pengguna dari Intent
        val unname = intent.getStringExtra(LoginFragment.EXTRA_NAME)

        // Menampilkan pesan selamat datang
        unname?.let {
            binding.welcomeMessage.text = "Hello, $unname!"
        }
    }

    private inner class ImageSliderTimer(val numPages: Int) : TimerTask() {
        override fun run() {
            runOnUiThread {
                viewPager.currentItem = (viewPager.currentItem + 1) % numPages
            }
        }
    }
}
