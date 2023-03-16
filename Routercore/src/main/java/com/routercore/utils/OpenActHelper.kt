package com.routercore.utils

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.alibaba.android.arouter.core.LogisticsCenter
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import com.routercore.routercore.moduleservice.MduserRouterService
import com.tdxtxt.baselib.app.ApplicationDelegate

/**
 * <pre>
 *     author : ton
 *     time   : 2023/3/16
 *     desc   : Act打开
 * </pre>
 */
object OpenActHelper {
    fun startNeedLogin(path: String, params: Bundle? = null){
        if(MduserRouterService.isLogin()){
            startNormal(path, params)
        }else{
            MduserRouterService.openLogin()
        }
    }

    fun startNormal(path: String, params: Bundle? = null){
        findPostcardByPath(path, params).navigation()
    }

    fun findPostcardByPath(path: String, params: Bundle? = null): Postcard{
        val postcard = ARouter.getInstance().build(path)
        if(params != null) postcard.with(params)
        return postcard
    }

    fun findIntentByPath(path: String, params: Bundle? = null, uri: Uri? = null): Intent{
        val postcard = findPostcardByPath(path, params)
        LogisticsCenter.completion(postcard)
        val intent = Intent(ApplicationDelegate.context, postcard.destination)
        intent.putExtras(postcard.extras)
        intent.setData(uri)
        return intent
    }

}