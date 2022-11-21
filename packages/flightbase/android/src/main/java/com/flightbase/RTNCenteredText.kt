package com.flightbase

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: jamesfchen
 * @since: Sep/27/2022  Tue
 */


class RTNCenteredText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = -1
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyleAttr) {
    init {
        setBackgroundColor(Color.RED)
        this.gravity = Gravity.CENTER_HORIZONTAL
    }
}
