package com.mycm

import android.graphics.Color
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

@ReactModule(name = MycmViewManager.NAME)
class MycmViewManager :
  MycmViewManagerSpec<MycmView>() {
  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): MycmView {
    return MycmView(context)
  }

  @ReactProp(name = "color")
  override fun setColor(view: MycmView?, color: String?) {
    view?.setBackgroundColor(Color.parseColor(color))
  }

  companion object {
    const val NAME = "MycmView"
  }
}
