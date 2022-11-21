package com.flightbase

import android.view.View
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ViewManagerDelegate

abstract class RTNCenteredTextManagerSpec<T : View>: SimpleViewManager<T>(), RTNCenteredTextManagerInterface<T> {
  private val mDelegate: ViewManagerDelegate<T> = RTNCenteredTextManagerDelegate(this)

  override fun getDelegate(): ViewManagerDelegate<T> {
    return mDelegate
  }
}
