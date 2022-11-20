package com.mycm

import android.view.View

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.viewmanagers.MycmViewManagerDelegate
import com.facebook.react.viewmanagers.MycmViewManagerInterface

abstract class MycmViewManagerSpec<T : View> : SimpleViewManager<T>(), MycmViewManagerInterface<T> {
  private val mDelegate: ViewManagerDelegate<T>

  init {
    mDelegate = MycmViewManagerDelegate(this)
  }

  override fun getDelegate(): ViewManagerDelegate<T>? {
    return mDelegate
  }
}
