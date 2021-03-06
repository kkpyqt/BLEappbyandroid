package com.wehand.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wehand.R
import com.wehand.model.ModelUserInfo

/**
 * Created by jonesrandom on 11/14/17.
 *
 * #JanganLupaBahagia
 * 取数据到用户列表展示,单击打开详情,可再查修改界面
 */
class UserListAdapter(data: MutableList<ModelUserInfo>, listener: OnItemClickListener) : RecyclerView.Adapter<UserListHolder>() {

    private val datas = data
    private val listeners = listener

    override fun onBindViewHolder(holder: UserListHolder?, position: Int) {
        holder?.bind(datas[position], listeners, position)
    }

    override fun getItemCount(): Int = datas.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserListHolder {
//        行展示定义
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.row_userinfo, parent, false)
        return UserListHolder(view)
    }
}