package com.fy.ktl.ui

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.TextView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private var mView: SparseArray<View>? = null

    init {
        mView = SparseArray()
    }

   private fun <T : View> getView(viewId: Int): T {
        var view: View? = mView?.get(viewId)
        if (view == null) {
            view = itemView.findViewById(viewId)
            mView?.put(viewId, view)
        }
        return view as T
    }


    fun setText(viewId: Int, text: CharSequence) {
        val view = getView<TextView>(viewId)
        view.text = text as String
    }


    fun setOnItemClickListener(listener: View.OnClickListener) {
        itemView.setOnClickListener(listener)
    }


}