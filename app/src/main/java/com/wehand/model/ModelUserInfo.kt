package com.wehand.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by kkpyqt on 17-12-30.
 * 将表记录信息转化为展示信息,有类型转换
 * 变量名是表字段名
 * Parcelize 序列号公害
 */
//@SuppressLint("ParcelCreator")
//@Parcelize
data class ModelUserInfo(
        var id: Int =0,
        var name: String ="",
        var isremember: String="N",
        var isregist: String="N",
        var iscurrentuser: String ="N",
        var passwd: String ="")
//    : Parcelable {
//    constructor() : this(0, "", "", "","","")
//
//}

//TODO 测量历史定义