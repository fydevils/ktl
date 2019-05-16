package com.hazz.kotlinmvp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fy.ktl.KtlApp


/**
 * @author lhp
 * created: 2019/5/10
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()
        loadData()

    }

    abstract fun layoutId(): Int

    abstract fun initView()

    abstract fun loadData()

    override fun onDestroy() {
        super.onDestroy()
        KtlApp.getRefWatcher(this)?.watch(this)
    }


}


