package com.flightbase

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import java.util.ArrayList

class FlightbaseViewPackage : ReactPackage {
  override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
    val modules: MutableList<NativeModule> = ArrayList()
//    modules.add(com.base.CalendarModule(reactContext))
    return modules
  }

  override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
    val viewManagers: MutableList<ViewManager<*, *>> = ArrayList()
    viewManagers.add(FlightbaseViewManager())
    viewManagers.add(MyImageViewManager(reactContext))
    return viewManagers
  }
}
