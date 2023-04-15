package com.github.yohannestz.debugbannerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.yohannestz.debugbanner.Banner
import com.github.yohannestz.debugbanner.BannerGravity
import com.github.yohannestz.debugbanner.BannerView

class BannerActivity : AppCompatActivity(), BannerView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)
    }

    override fun createBanner(): Banner {
        return Banner(
            bannerText = "Unpaid",
            bannerGravity = BannerGravity.START
        )
    }
}