package com.fy.ktl

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * 全局拓展函数
 */

fun Fragment.showToast(content: String)  {
    val toast = Toast.makeText(this.activity?.applicationContext, content, Toast.LENGTH_SHORT)
    toast.show()
   }

fun Context.showToast(content: String)  {
    val toast = Toast.makeText(KtlApp.context, content, Toast.LENGTH_SHORT)
    toast.show()
}




