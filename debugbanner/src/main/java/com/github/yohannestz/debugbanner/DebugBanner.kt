package com.github.yohannestz.debugbanner

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.view.ViewGroup

class DebugBanner (application: Application, private val banner: Banner): Application.ActivityLifecycleCallbacks by ActivityEmptyLifecycleCallbacks() {
    companion object {
        fun init (application: Application, banner: Banner = Banner()) {
            DebugBanner(application, banner)
        }
    }

    init {
        application.registerActivityLifecycleCallbacks(this)
    }

    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
        val decorView = activity.window.decorView as ViewGroup
        val localBanner = if (activity is BannerView) {
            activity.createBanner()
        } else {
            banner
        }
        val debugBannerView = DebugBannerView(activity).apply {
            updateText(localBanner.bannerText, localBanner.textColorRes)
            updateBannerColor(localBanner.bannerColorRes)
            bannerGravity = localBanner.bannerGravity
        }
        val bannerSize = activity.resources.getDimension(R.dimen.banner_default_size_debug).toInt()
        val params = ViewGroup.MarginLayoutParams(bannerSize, bannerSize)
        decorView.addView(debugBannerView, params)

        if (!isAtLeastLollipop)
            debugBannerView.translationY = activity.getStatusBarHeight()
    }
}