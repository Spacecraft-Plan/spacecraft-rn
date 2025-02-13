package com.flightbase

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext


/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: jamesfchen
 * @since: Sep/26/2022  Mon
 */
class CalculatorModule(context: ReactApplicationContext) : CalculatorModuleSpec(context) {
    companion object{
        const val  NAME = "Calculator"
    }

    override fun getName(): String {
        return NAME
    }

    override fun add(a: Double, b: Double, promise: Promise) {
        promise.resolve(a + b)
    }
}
