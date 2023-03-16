package com.edu.mduser.http

import android.util.ArrayMap
import com.edu.mduser.bean.response.LoginTokenBody
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
object MduserRepository {
    private fun getService() = NetMgr.getService(MduserService::class.java)

    fun login(userName: String, password: String): Observable<LoginTokenBody> {
        val parmas = ArrayMap<String, String>()
        parmas.put("type", "PHONE_NUMBER")
        parmas.put("name", userName)
        parmas.put("secret", password)
        parmas.put("group", "STUDENT-APP")
        return getService().login(parmas)
    }
}