package com.tdxtxt.net

import com.tdxtxt.bean.response.BaseResponse
import com.tdxtxt.constant.Valconstant
import com.tdxtxt.net.observer.AbsObserverNetapi

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/13
 *     desc   :
 * </pre>
 */
abstract class BaseObserverNetapi<T> : AbsObserverNetapi<T, BaseResponse<T>>() {
    override fun host() = Valconstant.HOST

}