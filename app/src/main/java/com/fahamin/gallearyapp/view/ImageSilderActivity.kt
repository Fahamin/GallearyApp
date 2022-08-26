package com.fahamin.gallearyapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.fahamin.gallearyapp.ImageViewPagerAdapter
import com.fahamin.gallearyapp.databinding.ActivityImageSilderBinding

class ImageSilderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageSilderBinding
    lateinit var imageViewPagerAdapter: ImageViewPagerAdapter

    var position: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageSilderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var list = intent.getStringArrayListExtra("list")
        position = intent.getIntExtra("pos", 1);
        imageViewPagerAdapter = ImageViewPagerAdapter(list)

        setUpViewPager()
    }

    private fun setUpViewPager() {

        binding.viewPager.adapter = imageViewPagerAdapter

        //set the orientation of the viewpager using ViewPager2.orientation
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //select any page you want as your starting page
        val currentPageIndex = position
        binding.viewPager.currentItem = currentPageIndex

        // registering for page change callback
        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            }
        )
    }

    override fun onDestroy() {
        super.onDestroy()

        // unregistering the onPageChangedCallback
        binding.viewPager.unregisterOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {}
        )
    }
}
