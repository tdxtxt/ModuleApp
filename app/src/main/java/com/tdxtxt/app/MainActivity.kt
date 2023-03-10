package com.tdxtxt.app

import android.content.Intent
import com.tdxtxt.baselib.ui.CommToolBarActivity
import com.tdxtxt.routercore.moduleservice.MduserRouterService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : CommToolBarActivity() {

    override fun getLayoutResId() = R.layout.activity_main

    override fun initUi() {
        setTitleBar("我是大人")

        btn_next_1.setOnClickListener {
            startActivity(Intent(fragmentActivity, VideoActivity::class.java))
//            MduserRouterService.login(this@MainActivity, "122", "33dd")
        }
    }
}
