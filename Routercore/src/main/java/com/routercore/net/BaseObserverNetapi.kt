package com.routercore.net

import com.routercore.bean.response.BaseResponse
import com.routercore.env.EvnConstant
import com.tdxtxt.net.observer.AbsObserverNetapi

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/13
 *     desc   :
 * </pre>
 */
abstract class BaseObserverNetapi<T> : AbsObserverNetapi<T, BaseResponse<T>>() {
    override fun host() = EvnConstant.HOST

}