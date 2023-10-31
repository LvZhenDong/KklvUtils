package com.kklv.ktext

import android.content.res.Resources
import android.util.Log
import android.util.TypedValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.appbar.AppBarLayout
import kotlin.math.roundToInt

/**
 * Author:lvzhendong
 * Created:2023/8/16
 * Desc:扩展方法
 */

val Int.dpInt: Int
    get() {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            Resources.getSystem().displayMetrics
        ).roundToInt()
    }

val Int.spInt: Int
    get() {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            this.toFloat(),
            Resources.getSystem().displayMetrics
        ).roundToInt()
    }

val Int.spFloat: Float
    get() {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            this.toFloat(),
            Resources.getSystem().displayMetrics
        )
    }

val Float.dpInt: Int
    get() {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this,
            Resources.getSystem().displayMetrics
        ).roundToInt()
    }

val Int.dpFloat: Float
    get() {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            Resources.getSystem().displayMetrics
        )
    }

/**
 * 带Lifecycle的OnOffsetChangedListener
 */
fun <T : AppBarLayout> T.addLifecycleOnOffsetChangedListener(lifecycleOwner: LifecycleOwner,listener: AppBarLayout.OnOffsetChangedListener) {
    this.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
        if (lifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            listener.onOffsetChanged(appBarLayout, verticalOffset)
        }else{
            Log.i("kklv","not STARTED")
        }
    })
}
