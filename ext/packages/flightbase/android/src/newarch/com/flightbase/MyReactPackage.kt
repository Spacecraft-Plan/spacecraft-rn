//package  com.flightbase
//
//import com.facebook.react.TurboReactPackage
//import com.facebook.react.bridge.NativeModule
//import com.facebook.react.bridge.ReactApplicationContext
//import com.facebook.react.module.model.ReactModuleInfo
//import com.facebook.react.module.model.ReactModuleInfoProvider
//
///**
// * 新架构
// */
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
