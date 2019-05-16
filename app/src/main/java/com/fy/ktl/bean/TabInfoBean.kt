package com.fy.ktl.bean

/**
 *
 * 数据类
 */

data class TabInfoBean(val tabInfo: TabInfo) {
    data class TabInfo(val tabList: ArrayList<Tab>)

    data class Tab(val id: Long, val name: String, val datas: ArrayList<Info>)

    data class Info(val name: String)
}
