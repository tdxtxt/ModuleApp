package com.routercore.routercore.moduleservice

import com.alibaba.android.arouter.launcher.ARouter
import com.routercore.routercore.moduleinter.IMdmainService
import com.routercore.routercore.routermap.MdmainRouterMap

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/10
 *     desc   :
 * </pre>
 */
object MdmainRouterService {

    private fun getService() = ARouter.getInstance().build(MdmainRouterMap.MDMAIN_SERVICE_MAP).navigation() as IMdmainService

}