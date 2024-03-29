package com.routercore.net

import com.routercore.utils.RouterConstant
import com.tdxtxt.net.observer.AbsObserverNetapi

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/13
 *     desc   :
 * </pre>
 */
abstract class BaseObserverNetapi<T> : AbsObserverNetapi<T>() {
    override fun host() = RouterConstant.HOST

}