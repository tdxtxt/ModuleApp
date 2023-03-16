package com.routercore.bean.response

import com.google.gson.annotations.SerializedName
import com.tdxtxt.net.model.AbsResponse

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/13
 *     desc   :
 * </pre>
 */
open class BaseResponseBody: AbsResponse{
    var status: Int? = 200
    @SerializedName("message")
    var msg: String = ""
    override fun getCode() = status

    override fun getMessage() = msg

    override fun getMeta() = this

    override fun isSuccess() = status == 200
}