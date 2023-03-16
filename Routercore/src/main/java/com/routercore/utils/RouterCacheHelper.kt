package com.routercore.utils

import com.tdxtxt.baselib.storage.CEngine
import com.tdxtxt.baselib.storage.MMKVEngine

/**
 * <pre>
 *     author : ton
 *     time   : 2023/3/14
 *     desc   :
 * </pre>
 */
object RouterCacheHelper: CEngine by object : MMKVEngine() {
    override fun createMMKVFileKey() = "RouterKey"
}{
    fun getEvnType(): Int{
        return getInt("evnType", RouterConstant.EVN_RELESE)
    }
    fun putEvnType(evnType: Int){
        putInt("evnType", evnType)
    }

    fun isExistEvnType() = contains("evnType")?: false
}