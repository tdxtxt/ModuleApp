package com.routercore.routercore.moduleservice

import com.alibaba.android.arouter.launcher.ARouter

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/10
 *     desc   :
 * </pre>
 */
object MdxxxRouterService {

    private fun getService() = ARouter.getInstance().build(MdxxxRouterMap.MDXXX_SERVICE_MAP).navigation() as IMdxxxService

}