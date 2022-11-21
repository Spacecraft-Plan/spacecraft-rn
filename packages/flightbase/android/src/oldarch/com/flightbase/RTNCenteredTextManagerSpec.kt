package com.flightbase

import android.view.View
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ViewProps
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.views.image.ImageResizeMode
import com.flightbase.MyImageView

abstract class RTNCenteredTextManagerSpec<T : View> : SimpleViewManager<T>() {
  abstract fun setText(view: RTNCenteredText, text: String)
}


