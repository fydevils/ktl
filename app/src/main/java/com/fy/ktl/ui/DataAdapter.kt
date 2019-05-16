package com.fy.ktl.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fy.ktl.R
import com.fy.ktl.bean.TabInfoBean
import com.fy.ktl.showToast

class DataAdapter(var context: Context, var dataList: ArrayList<TabInfoBean.Info>?, var layoutId: Int) :
    RecyclerView.Adapter<ViewHolder>() {
    protected var mInflater: LayoutInflater? = null

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater?.inflate(layoutId, parent, false)
        return ViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = dataList?.let { it[position] }
        with(holder) {
            setText(R.id.tv_title, info?.name ?: "no  title")
        }
//        holder.setText(R.id.tv_title, info?.name ?: "no  title")


//        holder.setOnItemClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                v?.let {
//                    val textView = v as TextView
//                    context.showToast(textView.text as String)
//                }
//
//            }
//        })

        holder.setOnItemClickListener(listener = View.OnClickListener {
            it?.let {
                context.showToast(dataList!![position].name)
            }
        })




    }


}