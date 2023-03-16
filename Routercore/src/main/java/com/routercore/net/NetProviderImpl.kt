package com.routercore.net

import com.blankj.utilcode.util.GsonUtils
import com.routercore.BuildConfig
import com.routercore.bean.response.BaseResponseBody
import com.routercore.utils.RouterCacheHelper
import com.routercore.utils.RouterConstant
import com.tdxtxt.baselib.tools.LogA
import com.tdxtxt.net.config.DefaultNetProvider
import com.tdxtxt.net.model.AbsResponse
import org.json.JSONException
import retrofit2.HttpException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/14
 *     desc   :
 * </pre>
 */
class NetProviderImpl : DefaultNetProvider() {

    fun initEvnType(isDebug: Boolean) {
        if (isDebug) {
            if (!RouterCacheHelper.isExistEvnType()) {
                RouterCacheHelper.putEvnType(RouterConstant.EVN_DEV)
            }
        }

        changeHost(
            when (RouterCacheHelper.getEvnType()) {
                RouterConstant.EVN_DEV -> BuildConfig.HOST_DEV
                RouterConstant.EVN_TEST -> BuildConfig.HOST_TEST
                else -> BuildConfig.HOST_RELEASE
            }
        )
    }

    fun changeHost(host: String) {
        RouterConstant.HOST = host
    }

    override fun host() = RouterConstant.HOST

    override fun printLog(message: String) {
        LogA.i("http", message)
    }

    override fun throwable2Response(e: Throwable?): AbsResponse? {
        when (e) {
            is HttpException -> {
                val errorBody = e.response().errorBody()
                val json = errorBody?.string()
                var response: AbsResponse? = null
                if(json?.isNotEmpty() == true){
                    try{
                        response = GsonUtils.fromJson(json, BaseResponseBody::class.java)
                    }catch (ex: Exception){}
                }
                return response
            }
            else -> return null
        }
    }

    override fun throwable2Message(e: Throwable?): String {
        if(e == null) return "未知错误"
        return when(e){
            is UnknownHostException -> "网络异常"
            is SocketTimeoutException -> "请求网络超时"
            is SocketException -> "网络异常"
            is SSLException -> "网络异常"
            is JSONException -> "数据解析错误"
            is HttpException -> {
                val errorBody = e.response().errorBody()
                val json = errorBody?.string()
                var response: AbsResponse? = null
                if(json?.isNotEmpty() == true){
                    try{
                        response = GsonUtils.fromJson(json, BaseResponseBody::class.java)
                    }catch (ex: Exception){}
                }
                response?.getMessage()?: "请求失败，请重试"
            }
            else -> "请求失败，请重试"
        }
    }

}