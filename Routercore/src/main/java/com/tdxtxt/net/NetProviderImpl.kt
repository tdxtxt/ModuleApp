package com.tdxtxt.net

import com.tdxtxt.baselib.tools.LogA
import com.tdxtxt.constant.Valconstant
import com.tdxtxt.net.config.DefaultNetProvider

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/14
 *     desc   :
 * </pre>
 */
class NetProviderImpl : DefaultNetProvider() {
    override fun host() = Valconstant.HOST

    override fun printLog(message: String) {
        LogA.i("http", message)
    }
}