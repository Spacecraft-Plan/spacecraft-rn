package com.jamesfchen.spacecraftrn

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.common.MapBuilder
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ViewProps
import com.facebook.react.views.image.ImageResizeMode

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: jamesfchen
 * @since: Mar/13/2022  Sun
 */
@ReactModule(name = "MyImageView")
abstract class BaseImageViewManager(var mCallerContext: ReactApplicationContext) : SimpleViewManager<MyImageView>() {
    override fun getName(): String {
        return "MyImageView"
    }
    public override fun createViewInstance(context: ThemedReactContext): MyImageView {
        return MyImageView(context)
    }
    @ReactProp(name = "src")
    fun setSrc(view: MyImageView, sources: ReadableArray?) {
        view.setSource(sources)
    }

    @ReactProp(name = "borderRadius", defaultFloat = 0f)
    override fun setBorderRadius(view: MyImageView, borderRadius: Float) {
        view.setBorderRadius(borderRadius)
    }

    @ReactProp(name = ViewProps.RESIZE_MODE)
    fun setResizeMode(view: MyImageView, resizeMode: String?) {
        view.setScaleType(ImageResizeMode.toScaleType(resizeMode))
    }
    override fun getExportedCustomBubblingEventTypeConstants(): MutableMap<String, Any> {
        //java层的topChange 与 js层的onChange进行映射
        return MapBuilder.builder<String, Any>().put(
            "topChange",
            MapBuilder.of(
                "phasedRegistrationNames",
                MapBuilder.of("bubbled", "onChange")
            )
        ).build()
    }
}

class MyImageViewManager(cxt: ReactApplicationContext) : BaseImageViewManager(cxt)

