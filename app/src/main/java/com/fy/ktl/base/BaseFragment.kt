package com.hazz.kotlinmvp.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fy.ktl.KtlApp

abstract class BaseFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(),null)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        loadData()
    }

    abstract fun getLayoutId():Int

    abstract fun initView()

    abstract fun loadData()

    override fun onDestroy() {
        super.onDestroy()
        activity?.let { KtlApp.getRefWatcher(it)?.watch(activity) }
    }


}
