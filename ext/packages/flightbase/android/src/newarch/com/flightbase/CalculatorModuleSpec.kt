package com.flightbase

import com.facebook.react.bridge.ReactApplicationContext

abstract class CalculatorModuleSpec internal constructor(context: ReactApplicationContext) :
  NativeCalculatorSpec(context) {}
