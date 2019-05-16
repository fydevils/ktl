package com.fy.ktl.ui

import android.support.v4.app.Fragment
import com.fy.ktl.R
import com.fy.ktl.bean.TabInfoBean
import com.fy.ktl.showToast
import com.hazz.kotlinmvp.base.BaseActivity
import com.hazz.kotlinmvp.base.BaseFragmentAdapter
import com.hazz.kotlinmvp.mvp.contract.HotTabContract
import com.hazz.kotlinmvp.mvp.presenter.HotTabPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), HotTabContract.View {
    private val mPresenter by lazy { HotTabPresenter() }
    private val mTabTitleList = ArrayList<String>()
    private val mFragmentList = ArrayList<Fragment>()

    init {
        mPresenter.attachView(this)
    }

    override fun layoutId() = R.layout.activity_main
    override fun loadData() {
        mPresenter.getTabInfo()
    }

    override fun initView() {

    }

    override fun setTabInfo(tabInfoBean: TabInfoBean) {
        tabInfoBean.tabInfo.tabList.mapTo(mTabTitleList) { it.name }
        tabInfoBean.tabInfo.tabList.mapTo(mFragmentList) { TabFragment.getInstance(it.datas) }
        mViewPager.adapter = BaseFragmentAdapter(supportFragmentManager, mFragmentList, mTabTitleList)
        mTabLayout.setupWithViewPager(mViewPager)

    }

    override fun showError(msg: String) {
        showToast(msg)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}
