package com.flightbase

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule

abstract class CalculatorModuleSpec constructor(context: ReactApplicationContext) :
  ReactContextBaseJavaModule(context) {
  abstract fun add(a: Double, b: Double, promise: Promise)
}
