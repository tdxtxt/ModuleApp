package com.edu.mdxxx.http

import android.util.ArrayMap
import com.routercore.bean.response.BaseResponse
import com.tdxtxt.net.NetMgr
import io.reactivex.Observable

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/14
 *     desc   :
 * </pre>
 */
object MdxxxRepository {
    private fun getService() = NetMgr.getService(MdxxxService::class.java)

    fun login(username: String, password: String): Observable<BaseResponse<Any>> {
        val parmas = ArrayMap<String, String>()
        parmas.put("username", username)
        parmas.put("password", password)
        return getService().login(parmas)
    }
}