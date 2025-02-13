package com.flightbase

import android.view.View

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.viewmanagers.FlightbaseViewManagerDelegate
import com.facebook.react.viewmanagers.FlightbaseViewManagerInterface

abstract class FlightbaseViewManagerSpec<T : View> : SimpleViewManager<T>(), FlightbaseViewManagerInterface<T> {
  private val mDelegate: ViewManagerDelegate<T>

  init {
    mDelegate = FlightbaseViewManagerDelegate(this)
  }

  override fun getDelegate(): ViewManagerDelegate<T>? {
    return mDelegate
  }
}
