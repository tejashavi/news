package com.jasbir.news.util

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager

class VerticalViewPager : ViewPager {
    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setPageTransformer(true, VerticalPageTransformer())
        overScrollMode = OVER_SCROLL_NEVER
    }

    private inner class VerticalPageTransformer : PageTransformer {
        override fun transformPage(page: View, position: Float) {
            if (position < -1) {
                page.alpha = 0f
            } else if (position <= 0) {
                page.alpha = 1f
                page.translationX = page.width * -position

                // set y position to swipe in from top
                val yPosition = position * page.height
                page.translationY = yPosition
                page.scaleX = 1f
                page.scaleY = 1f
            } else if (position <= 1) {
                page.translationX = page.width * -position
                // to scale the page down
                val scale = 0.75f + (1 - 0.75f) * (1 - Math.abs(position))
                page.scaleX = scale
                page.scaleY = scale
            } else {
                page.alpha = 0f
            }
        }
    }

    private fun swipeXYCordinates(event: MotionEvent): MotionEvent {
        val width = width.toFloat()
        val height = height.toFloat()
        val newX = event.y / height * width
        val newY = event.x / width * height
        event.setLocation(newX, newY)
        return event
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val intercepted = super.onInterceptTouchEvent(swipeXYCordinates(ev))
        swipeXYCordinates(ev)
        return intercepted
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return super.onTouchEvent(swipeXYCordinates(ev))
    }
}