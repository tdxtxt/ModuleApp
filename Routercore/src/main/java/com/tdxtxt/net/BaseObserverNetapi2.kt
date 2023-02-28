package com.tdxtxt.net

import com.tdxtxt.constant.Valconstant
import com.tdxtxt.net.observer.AbsObserverNetapi2

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/13
 *     desc   :
 * </pre>
 */
abstract class BaseObserverNetapi2<T> : AbsObserverNetapi2<T>() {
    override fun host() = Valconstant.HOST

}