package com.github.yohannestz.debugbannerexample

import android.app.Application
import com.github.yohannestz.debugbanner.Banner
import com.github.yohannestz.debugbanner.BannerGravity
import com.github.yohannestz.debugbanner.DebugBanner

class DebugBannerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DebugBanner.init(
            application = this,
            banner = Banner(
                BannerGravity.START,
                bannerText = "Unpaid"
            )
        )
    }
}