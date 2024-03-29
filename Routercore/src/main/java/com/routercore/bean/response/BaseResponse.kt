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
class BaseResponse<T> : AbsResponse{
    var status: Int? = 200
    @SerializedName("message")
    var msg: String = ""
    var data: T? = null


    override fun isSuccess() = status == 200

    override fun getMessage() = msg
    override fun getMeta() = data

    override fun getCode() = status
}