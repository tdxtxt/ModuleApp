package com.edu.mduser.http

import com.edu.mduser.bean.response.LoginTokenBody
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
interface MduserService {
    @POST("api/access-tokens")
    fun login(@Body body: Map<String, String>): Observable<LoginTokenBody>
}