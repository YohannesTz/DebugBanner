package com.github.yohannestz.debugbanner

import android.content.Context
import android.graphics.Insets
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowMetrics
import androidx.window.layout.WindowMetricsCalculator


internal fun View.dip(value: Int): Int = (value * resources.displayMetrics.density).toInt()

internal val isAtLeastLollipop: Boolean
    get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP

/*internal fun Context.getScreenWidth(): Float {
    val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        this.display
    } else {
        @Suppress("DEPRECATION")
        wm.defaultDisplay
    }
    val size = Point()
    display?.getSize(size)
    return size.x.toFloat()
}*/

internal fun Context.getScreenWidth(): Float {
    val windowMetrics = WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(this)
    val currentBounds = windowMetrics.bounds
    val width = currentBounds.width()
    return width.toFloat()
}

internal fun Context.getStatusBarHeight(): Float {
    var result = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = resources.getDimensionPixelSize(resourceId)
    }
    return result.toFloat()
}
