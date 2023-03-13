package com.routercore.mduser.impl

import com.alibaba.android.arouter.facade.annotation.Route
import com.tdxtxt.baselib.tools.ToastHelper
import com.tdxtxt.baselib.ui.BaseActivity
import com.routercore.bean.response.BaseResponse
import com.routercore.mduser.http.MdUserRepository
import com.routercore.net.BaseObserverNetapi
import com.routercore.routercore.moduleinter.IMduserService
import com.routercore.routercore.routermap.MduserRouterMap

/**
 * <pre>
 *     author : ton
 *     time   : 2023/2/10
 *     desc   :
 * </pre>
 */
@Route(path = MduserRouterMap.MDUSER_SERVICE_MAP)
class MduserServiceImpl : IMduserService {
    override fun login(activity: BaseActivity, username: String, password: String) {
        MdUserRepository.login(username, password)
            .compose(activity.bindUIThread())
            .compose(activity.bindProgress())
            .subscribe(object : BaseObserverNetapi<Any>(){
                override fun onFailure(
                  response: BaseResponse<Any>?,
                  errorCode: Int?,
                  errorMsg: String?,
                  e: Throwable?) {
                    ToastHelper.showToast(errorMsg)
                }

                override fun onSuccess(response: BaseResponse<Any>) {
                    ToastHelper.showToast(response.toString())
                }
            })
    }


}