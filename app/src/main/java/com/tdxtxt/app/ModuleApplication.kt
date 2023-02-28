package com.tdxtxt.app

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.pingerx.socialgo.ali.alipay.AliPlatform
import com.pingerx.socialgo.core.SocialGo
import com.pingerx.socialgo.core.SocialGoConfig
import com.pingerx.socialgo.core.adapter.impl.DefaultGsonAdapter
import com.pingerx.socialgo.core.adapter.impl.DefaultRequestAdapter
import com.pingerx.socialgo.qq.QQPlatform
import com.pingerx.socialgo.wechat.WxPlatform
import com.tdxtxt.baselib.app.ApplicationDelegate
import com.tdxtxt.baselib.tools.CacheHelper
import com.tdxtxt.baselib.tools.LogA
import com.tdxtxt.net.NetMgr
import com.tdxtxt.net.NetProviderImpl

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/10
 *     desc   :
 * </pre>
 */
class ModuleApplication : Application() {
    lateinit var mApplicationDelegate: ApplicationDelegate

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        mApplicationDelegate = ApplicationDelegateImpl(this)
        mApplicationDelegate.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
        mApplicationDelegate.onCreate()
    }

    class ApplicationDelegateImpl constructor(val context: Application) :
        ApplicationDelegate(context) {
        override fun onPrivacyAfter(context: Context) {

        }

        override fun onPrivacyBefore(context: Context) {
            CacheHelper.init(context)
            NetMgr.registerProvider(NetProviderImpl())
            if (BuildConfig.DEBUG) {
                Logger.addLogAdapter(AndroidLogAdapter())
                LogA.plant(object : LogA.DebugTree() {
                    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                        Logger.log(priority, tag, message, t)
                    }
                })
            }
            /*SocialSdk.init(context, AppConstant.WX_APP_ID, AppConstant.WX_APP_SECRET, AppConstant.QQ_APP_ID)
                .registerWxPlatform(WxPlatform.Creator())
    //            .registerWbPlatform(WbPlatform.Creator())
                .registerQQPlatform(QQPlatform.Creator())
                .registerAliPlatform(AliPlatform.Creator())*/
        }
    }
}