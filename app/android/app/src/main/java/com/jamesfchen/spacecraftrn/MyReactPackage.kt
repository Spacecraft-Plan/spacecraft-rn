package com.jamesfchen.spacecraftrn

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import java.util.*

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: jamesfchen
 * @since: Sep/26/2022  Mon
 */

/**
 * 老架构
 */
class MyAppPackage : ReactPackage {
    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        val modules: MutableList<NativeModule> = ArrayList()
        modules.add(CalendarModule(reactContext))
        return modules
    }

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        return listOf<ViewManager<*, *>>(
            MyImageViewManager(
                reactContext
            )
        )
    }
}

/**
 * 新架构
 */
//class MyTurboReactPackage : TurboReactPackage() {
//    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
//        return if (name == CalculatorModule.NAME) {
//            CalculatorModule(reactContext)
//        } else {
//            null
//        }
//    }
//
//    override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
//        return ReactModuleInfoProvider {
//            val moduleInfos = HashMap<String, ReactModuleInfo>();
//            moduleInfos.put(
//                CalculatorModule.NAME, ReactModuleInfo(
//                    CalculatorModule.NAME,
//                    CalculatorModule.NAME,
//                    false, // canOverrideExistingModule
//                    false, // needsEagerInit
//                    true, // hasConstants
//                    false, // isCxxModule
//                    true // isTurboModule
//                )
//            );
//            return@ReactModuleInfoProvider moduleInfos
//
//
//        }
//    }
//}