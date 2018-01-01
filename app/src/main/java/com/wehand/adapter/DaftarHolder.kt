package com.jonesrandom.sqlite_kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.wehand.model.ModelUserInfo
//直接讯问latout 上的信息
import kotlinx.android.synthetic.main.row_userinfo.view.*

/**
 * Created by jonesrandom on 11/14/17.
 *
 * #JanganLupaBahagia
 * 这个是用户信息结果展示
 */
class DaftarHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bind(data: ModelUserInfo, listener: OnItemClickListener, position: Int) = with(itemView) {
//控件名=图标,用户名,是否当前用户,
        rowAv.text = data.name.substring(0, 1).capitalize()
        rowName.text = data.name
        rowIscurrent.text = data.iscurrentuser.toString()

        setOnClickListener { listener.onClick(data, position) }

    }
}