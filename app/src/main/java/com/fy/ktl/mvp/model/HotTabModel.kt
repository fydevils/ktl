package com.hazz.kotlinmvp.mvp.model

import com.fy.ktl.bean.TabInfoBean
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe

class HotTabModel {

    fun getTabInfo(): Observable<TabInfoBean> {
        return Observable.create(ObservableOnSubscribe<TabInfoBean> {
            val tabList = ArrayList<TabInfoBean.Tab>()
            val datas = ArrayList<TabInfoBean.Info>()
            for (i in 1..100) {
                datas.add(TabInfoBean.Info("name$i"))
            }
            tabList.add(TabInfoBean.Tab(1, "tab1", datas))
            tabList.add(TabInfoBean.Tab(2, "tab2", datas))
            tabList.add(TabInfoBean.Tab(3, "tab3", datas))
            val tabInfo = TabInfoBean.TabInfo(tabList)
            val tabInfoBean = TabInfoBean(tabInfo)
            it.onNext(tabInfoBean)
        })
    }
}
