package com.jamesfchen.spacecraftrn

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: jamesfchen
 * @since: Sep/27/2022  Tue
 */

//import com.facebook.react.bridge.ReactApplicationContext
//import com.facebook.react.module.annotations.ReactModule
//import com.facebook.react.uimanager.SimpleViewManager
//import com.facebook.react.uimanager.ThemedReactContext
//import com.facebook.react.uimanager.ViewManagerDelegate
//import com.facebook.react.uimanager.annotations.ReactProp
//import com.facebook.react.viewmanagers.RTNCenteredTextManagerDelegate
//import com.facebook.react.viewmanagers.RTNCenteredTextManagerInterface
//
//
//@ReactModule(name = RTNCenteredTextManager.NAME)
//class RTNCenteredTextManager(context: ReactApplicationContext) :
//    SimpleViewManager<RTNCenteredText>(), RTNCenteredTextManagerInterface<RTNCenteredText> {
//    private val mDelegate: ViewManagerDelegate<RTNCenteredText> =
//        RTNCenteredTextManagerDelegate(this)
//
//    override fun getDelegate(): ViewManagerDelegate<RTNCenteredText> {
//        return mDelegate
//    }
//
//    override fun getName(): String {
//        return NAME
//    }
//
//    override fun createViewInstance(context: ThemedReactContext): RTNCenteredText {
//        return RTNCenteredText(context)
//    }
//
//    @ReactProp(name = "text")
//    fun setText(view: RTNCenteredText, text: String) {
//        view.text = text
//    }
//
//    companion object {
//        const val NAME = "RTNCenteredText"
//    }
//}