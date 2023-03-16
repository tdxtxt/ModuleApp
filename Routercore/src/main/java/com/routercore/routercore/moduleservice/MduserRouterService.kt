package com.routercore.routercore.moduleservice

import com.alibaba.android.arouter.launcher.ARouter
import com.tdxtxt.baselib.ui.BaseActivity
import com.routercore.routercore.moduleinter.IMduserService
import com.routercore.routercore.routermap.MduserRouterMap

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/10
 *     desc   :
 * </pre>
 */
object MduserRouterService {

    private fun getService() = ARouter.getInstance().build(MduserRouterMap.MDUSER_SERVICE_MAP).navigation() as IMduserService

    fun isLogin(): Boolean{
        return false
    }

    fun openLogin(){

    }

    fun login(activity: BaseActivity, username: String, password: String){
        getService().login(activity, username, password)
    }
}