package com.edu.mduser.impl

import com.alibaba.android.arouter.facade.annotation.Route
import com.edu.mduser.bean.response.LoginTokenBody
import com.tdxtxt.baselib.tools.ToastHelper
import com.tdxtxt.baselib.ui.BaseActivity
import com.routercore.bean.response.BaseResponse
import com.edu.mduser.http.MduserRepository
import com.routercore.net.BaseObserverNetapi
import com.routercore.net.BaseObserverNetapiResponse
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
        MduserRepository.login(username, password)
            .compose(activity.bindUIThread())
            .compose(activity.bindProgress())
            .subscribe(object : BaseObserverNetapi<LoginTokenBody>(){
                override fun onSuccess(response: LoginTokenBody) {

                }

                override fun onFailure(errorCode: Int?, errorMsg: String?, errorData: Any?) {
                    ToastHelper.showToast(errorMsg)
                }

            })
    }


}