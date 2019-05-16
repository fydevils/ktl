package com.hazz.kotlinmvp.mvp.presenter

import com.hazz.kotlinmvp.base.BasePresenter
import com.hazz.kotlinmvp.mvp.contract.HotTabContract
import com.hazz.kotlinmvp.mvp.model.HotTabModel

class HotTabPresenter : BasePresenter<HotTabContract.View>(), HotTabContract.Presenter {

    private val hotTabModel by lazy { HotTabModel() }


    override fun getTabInfo() {
        checkViewAttached()
        val disposable = hotTabModel.getTabInfo()
            .subscribe({ tabInfo ->
                mRootView?.setTabInfo(tabInfo)
            }, { throwable ->
                //处理异常
                mRootView?.showError("data  error")
            })
        addSubscription(disposable)
    }
}