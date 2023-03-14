package com.edu.mdxxx.http

import com.routercore.bean.response.BaseResponse
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
interface MdxxxService {
    @POST("user/login")
    fun login(@Body body: Map<String, String>): Observable<BaseResponse<Any>>
}