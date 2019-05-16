package com.hazz.kotlinmvp.mvp.contract

import com.fy.ktl.bean.TabInfoBean
import com.hazz.kotlinmvp.base.IBaseView
import com.hazz.kotlinmvp.base.IPresenter

interface HotTabContract {

    interface View : IBaseView {
        fun setTabInfo(tabInfoBean: TabInfoBean)
        fun showError(msg: String)
    }

    interface Presenter : IPresenter<View> {
        fun getTabInfo()
    }
}