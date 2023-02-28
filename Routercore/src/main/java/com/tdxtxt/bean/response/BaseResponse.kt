package com.tdxtxt.bean.response

import com.tdxtxt.net.model.AbsResponse

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/13
 *     desc   :
 * </pre>
 */
data class BaseResponse <T> constructor(val errorMsg: String?, val errorCode: Int, val data: T?) :
    AbsResponse<T> {

    override fun isSuccess() = errorCode == 0

    override fun getMessage() = errorMsg

    override fun getCode() = errorCode
}