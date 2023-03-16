package com.edu.mdmain.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.edu.mdmain.R
import com.routercore.routercore.routermap.MdmainRouterMap
import com.tdxtxt.baselib.ui.CommToolBarActivity

/**
 * <pre>
 *     author : ton
 *     time   : 2023/3/16
 *     desc   :
 * </pre>
 */
@Route(path = MdmainRouterMap.MDMAIN_ACT_MAIN)
class MainActivity : CommToolBarActivity() {
    override fun getLayoutResId() = R.layout.activity_mdmain_main

}