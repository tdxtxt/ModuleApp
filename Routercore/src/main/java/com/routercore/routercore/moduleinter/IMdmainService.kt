package com.routercore.routercore.moduleinter

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/10
 *     desc   :
 * </pre>
 */
interface IMdmainService : IProvider {
    override fun init(context: Context?) {}

    fun openMain(isRefresh: Boolean)
    fun openHomePage(isRefresh: Boolean)
}