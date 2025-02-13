package com.flightbase

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: jamesfchen
 * @since: Sep/27/2022  Tue
 */

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

@ReactModule(name = RTNCenteredTextManager.NAME)
class RTNCenteredTextManager(context: ReactApplicationContext) :
  RTNCenteredTextManagerSpec<RTNCenteredText>() {

  override fun getName(): String {
    return NAME
  }

  override fun createViewInstance(context: ThemedReactContext): RTNCenteredText {
    return RTNCenteredText(context)
  }

  @ReactProp(name = "text")
  override fun setText(view: RTNCenteredText, text: String) {
    view.text = text
  }

  companion object {
    const val NAME = "RTNCenteredText"
  }
}
