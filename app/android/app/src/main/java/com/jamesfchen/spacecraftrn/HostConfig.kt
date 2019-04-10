package com.jamesfchen.spacecraftrn

import android.app.Application
import com.facebook.jni.HybridData
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.PackageList
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.ReactPackageTurboModuleManagerDelegate
import com.facebook.react.bridge.*
import com.facebook.react.fabric.ComponentFactory
import com.facebook.react.fabric.CoreComponentsRegistry
import com.facebook.react.fabric.FabricJSIModuleProvider
import com.facebook.react.fabric.ReactNativeConfig
import com.facebook.react.uimanager.ViewManagerRegistry
import com.facebook.soloader.SoLoader

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: jamesfchen
 * @since: Sep/24/2022  Sat
 */
abstract class BaseReactNativeHost(application: Application) : ReactNativeHost(application) {
    override fun getJSMainModuleName(): String? {
        return "index"
    }

    override fun getUseDeveloperSupport(): Boolean {
        return BuildConfig.DEBUG
    }
}

/**
 * 老架构
 */
class ReactNativeHost1(application: Application) : BaseReactNativeHost(application) {
    override fun getPackages(): List<ReactPackage>? {
        val packages: MutableList<ReactPackage> = PackageList(this).packages
        // Packages that cannot be autolinked yet can be added manually here, for example:
        // packages.add(new MyReactNativePackage());
        packages.add(MyAppPackage())
        return packages
    }
}

/**
 * 新架构
 */
class ReactNativeHost2(application: Application) : BaseReactNativeHost(application) {
    override fun getPackages(): List<ReactPackage> {
        val packages: MutableList<ReactPackage> = PackageList(this).packages
        // Packages that cannot be autolinked yet can be added manually here, for example:
        //     packages.add(new MyReactNativePackage());
        // TurboModules must also be loaded here providing a valid TurboReactPackage implementation:
        //     packages.add(new TurboReactPackage() { ... });
        // If you have custom Fabric Components, their ViewManagers should also be loaded here
        // inside a ReactPackage.
//        packages.add(MyTurboReactPackage())
        return packages
    }

    override fun getReactPackageTurboModuleManagerDelegateBuilder(): ReactPackageTurboModuleManagerDelegate.Builder {
        // Here we provide the ReactPackageTurboModuleManagerDelegate Builder. This is necessary
        // for the new architecture and to use TurboModules correctly.
        return MainApplicationTurboModuleManagerDelegate.Builder()
    }

    /**
     * Class responsible to load the TurboModules. This class has native methods and needs a
     * corresponding C++ implementation/header file to work correctly (already placed inside the jni/
     * folder for you).
     *
     *
     * Please note that this class is used ONLY if you opt-in for the New Architecture (see the
     * `newArchEnabled` property). Is ignored otherwise.
     */
    class MainApplicationTurboModuleManagerDelegate protected constructor(
        reactApplicationContext: ReactApplicationContext?, packages: List<ReactPackage>?
    ) : ReactPackageTurboModuleManagerDelegate(reactApplicationContext, packages) {
        external override fun initHybrid(): HybridData
        external fun canCreateTurboModule(moduleName: String?): Boolean
        class Builder : ReactPackageTurboModuleManagerDelegate.Builder() {
            override fun build(
                context: ReactApplicationContext, packages: List<ReactPackage>
            ): MainApplicationTurboModuleManagerDelegate {
                return MainApplicationTurboModuleManagerDelegate(context, packages)
            }
        }

        @Synchronized
        override fun maybeLoadOtherSoLibraries() {
            if (!sIsSoLibraryLoaded) {
                // If you change the name of your application .so file in the Android.mk file,
                // make sure you update the name here as well.
                SoLoader.loadLibrary("spacecraftrn_appmodules")
                sIsSoLibraryLoaded = true
            }
        }

        companion object {
            @Volatile
            private var sIsSoLibraryLoaded = false
        }
    }

    override fun getJSIModulePackage(): JSIModulePackage {
        return JSIModulePackage { reactApplicationContext, _ ->
            val specs: MutableList<JSIModuleSpec<*>> = ArrayList()

            // Here we provide a new JSIModuleSpec that will be responsible of providing the
            // custom Fabric Components.
            specs.add(object : JSIModuleSpec<UIManager> {
                override fun getJSIModuleType(): JSIModuleType {
                    return JSIModuleType.UIManager
                }

                override fun getJSIModuleProvider(): JSIModuleProvider<UIManager> {
                    val componentFactory = ComponentFactory()
                    CoreComponentsRegistry.register(componentFactory)

                    // Here we register a Components Registry.
                    // The one that is generated with the template contains no components
                    // and just provides you the one from React Native core.
                    MainComponentsRegistry.register(componentFactory)
                    val reactInstanceManager = reactInstanceManager
                    val viewManagerRegistry = ViewManagerRegistry(
                        reactInstanceManager.getOrCreateViewManagers(reactApplicationContext)
                    )
                    return FabricJSIModuleProvider(
                        reactApplicationContext,
                        componentFactory,
                        ReactNativeConfig.DEFAULT_CONFIG,
                        viewManagerRegistry
                    )
                }
            })
            specs
        }
    }

    /**
     * Class responsible to load the custom Fabric Components. This class has native methods and needs a
     * corresponding C++ implementation/header file to work correctly (already placed inside the jni/
     * folder for you).
     *
     *
     * Please note that this class is used ONLY if you opt-in for the New Architecture (see the
     * `newArchEnabled` property). Is ignored otherwise.
     */
    @DoNotStrip
    class MainComponentsRegistry @DoNotStrip private constructor(componentFactory: ComponentFactory) {
        @DoNotStrip
        private val mHybridData: HybridData

        @DoNotStrip
        private external fun initHybrid(componentFactory: ComponentFactory): HybridData

        init {
            mHybridData = initHybrid(componentFactory)
        }

        companion object {
            init {
                SoLoader.loadLibrary("fabricjni")
            }

            @DoNotStrip
            fun register(componentFactory: ComponentFactory): MainComponentsRegistry {
                return MainComponentsRegistry(componentFactory)
            }
        }
    }

}