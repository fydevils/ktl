package com.fy.ktl.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.fy.ktl.R
import com.fy.ktl.bean.TabInfoBean
import com.fy.ktl.showToast
import com.hazz.kotlinmvp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_tab.*

class TabFragment : BaseFragment() {
    private var datas: ArrayList<TabInfoBean.Info>? = null

    companion object {
        fun getInstance(datas: ArrayList<TabInfoBean.Info>): TabFragment {
            val fragment = TabFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.datas = datas
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_tab
    }

    private val mAdapter by lazy {
        activity?.let { DataAdapter(it, datas, R.layout.item_detail) }

    }

    override fun initView() {
        mRecyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        mRecyclerView.adapter = mAdapter
    }

    override fun loadData() {

    }

}