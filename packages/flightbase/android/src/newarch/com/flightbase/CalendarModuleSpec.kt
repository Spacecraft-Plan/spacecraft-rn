package com.flightbase

import com.facebook.react.bridge.ReactApplicationContext

abstract class CalendarModuleSpec internal constructor(context: ReactApplicationContext) :
  NativeCalendarSpec(context) {}
