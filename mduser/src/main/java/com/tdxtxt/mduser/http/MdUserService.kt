package com.tdxtxt.mduser.http

import com.tdxtxt.bean.response.BaseResponse
import com.tdxtxt.constant.Valconstant
import com.tdxtxt.net.annotate.BaseUrl
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/14
 *     desc   :
 * </pre>
 */
interface MdUserService {
    @POST("user/login")
    fun login(@Body body: Map<String, String>): Observable<BaseResponse<Any>>
}