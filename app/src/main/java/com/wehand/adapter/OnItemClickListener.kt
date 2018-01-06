package com.wehand.adapter

import com.wehand.model.ModelUserInfo

/**
 * Created by jonesrandom on 11/14/17.
 *
 * #JanganLupaBahagia
 *
 */
interface OnItemClickListener {
    fun onClick(data : ModelUserInfo , position : Int)
}