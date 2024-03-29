package com.routercore.net

import com.routercore.bean.response.BaseResponse
import com.routercore.utils.RouterConstant
import com.tdxtxt.net.observer.AbsObserverNetapiResponse

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/13
 *     desc   :
 * </pre>
 */
abstract class BaseObserverNetapiResponse<T> : AbsObserverNetapiResponse<BaseResponse<T>>() {
    override fun host() = RouterConstant.HOST

}