package com.wehand.ui
/*
实现测量界面首页
创建日期
作者：
修改记录：
     1.实现界面，及跳转
     */

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wehand.R
import kotlinx.android.synthetic.main.fragment_measure.*
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

class MeasureFragment : Fragment() {

    companion object {
        val TAG: String = MeasureFragment::class.java.simpleName
        fun newInstance() = MeasureFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//            如何获取交父窗口mainactivity 的数据？
        activity.title = "基"
        val view = inflater?.inflate(R.layout.fragment_measure, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        绑定点击事件
//        iv_xuetang = view.findViewById(R.id.iv_xuetang)
        iv_xuetang.setOnClickListener( {toast("点击了血糖")})




    }

}


