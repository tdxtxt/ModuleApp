package com.tdxtxt.routercore.moduleservice

import com.alibaba.android.arouter.launcher.ARouter
import com.tdxtxt.baselib.ui.BaseActivity
import com.tdxtxt.routercore.moduleinter.IMduserService
import com.tdxtxt.routercore.routermap.MduserRouterMap

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/10
 *     desc   :
 * </pre>
 */
object MduserRouterService {

    private fun getService() = ARouter.getInstance().build(MduserRouterMap.MDUSER_SERVICE_MAP).navigation() as IMduserService

    fun login(activity: BaseActivity, username: String, password: String){
        getService().login(activity, username, password)
    }
}