package com.routercore.routercore.moduleinter

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider
import com.tdxtxt.baselib.ui.BaseActivity

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/10
 *     desc   :
 * </pre>
 */
interface IMduserService : IProvider {
    override fun init(context: Context?) {}

    fun login(activity: BaseActivity, username: String, password: String)
}