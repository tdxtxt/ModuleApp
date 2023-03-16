package com.routercore.utils

import com.routercore.BuildConfig

/**
 * <pre>
 *     author : ton
 *     time   : 2023/3/14
 *     desc   :
 * </pre>
 */
object RouterConstant {
    const val EVN_RELESE = 0
    const val EVN_TEST = 1
    const val EVN_DEV = 2

    var HOST = BuildConfig.HOST_DEV
}