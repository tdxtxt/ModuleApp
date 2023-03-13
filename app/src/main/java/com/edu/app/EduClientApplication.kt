package com.edu.app

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.tdxtxt.baselib.app.ApplicationDelegate
import com.tdxtxt.baselib.tools.CacheHelper
import com.tdxtxt.baselib.tools.LogA
import com.tdxtxt.net.NetMgr
import com.routercore.net.NetProviderImpl

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/10
 *     desc   :
 * </pre>
 */
class EduClientApplication : Application() {
    private lateinit var mApplicationDelegate: ApplicationDelegate

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
        override fun onPrivacyAfter(context: Context) {//同意隐私正常之后

        }

        override fun onPrivacyBefore(context: Context) {//同意隐私正常之前
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