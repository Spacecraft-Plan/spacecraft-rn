package com.flightbase

import android.graphics.Color
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

@ReactModule(name = FlightbaseViewManager.NAME)
class FlightbaseViewManager :
  FlightbaseViewManagerSpec<FlightbaseView>() {
  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): FlightbaseView {
    return FlightbaseView(context)
  }

  @ReactProp(name = "color")
  override fun setColor(view: FlightbaseView?, color: String?) {
    view?.setBackgroundColor(Color.parseColor(color))
  }

  companion object {
    const val NAME = "FlightbaseView"
  }
}
