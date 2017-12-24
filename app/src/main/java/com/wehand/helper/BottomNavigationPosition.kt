package com.wehand.helper

import android.support.v4.app.Fragment
import com.wehand.R
import com.wehand.ui.*

enum class BottomNavigationPosition(val position: Int, val id: Int) {
    USER(0, R.id.user),
    NEWS(1, R.id.news),
//    MEASURE(2, R.id.measure),
    SHOP(3, R.id.shop),

    PROFILE(4, R.id.profile);
}

fun findNavigationPositionById(id: Int): BottomNavigationPosition = when (id) {
    BottomNavigationPosition.USER.id -> BottomNavigationPosition.USER
    BottomNavigationPosition.NEWS.id -> BottomNavigationPosition.NEWS
//    BottomNavigationPosition.MEASURE.id -> BottomNavigationPosition.MEASURE
    BottomNavigationPosition.SHOP.id -> BottomNavigationPosition.SHOP
    BottomNavigationPosition.PROFILE.id -> BottomNavigationPosition.PROFILE
//
   // BottomNavigationPosition.BLE.id -> BottomNavigationPosition.BLE
    else -> BottomNavigationPosition.USER
}

fun BottomNavigationPosition.createFragment(): Fragment = when (this) {
    BottomNavigationPosition.USER -> UserFragment.newInstance()
    BottomNavigationPosition.NEWS -> NewsFragment.newInstance()
//    BottomNavigationPosition.MEASURE -> MeasureFragment.newInstance()
    BottomNavigationPosition.SHOP -> ShopFragment.newInstance()
    BottomNavigationPosition.PROFILE -> ProfileFragment.newInstance()
//
    //BottomNavigationPosition.BLE -> BleFragment.newInstance()
}

fun BottomNavigationPosition.getTag(): String = when (this) {
    BottomNavigationPosition.USER -> UserFragment.TAG
    BottomNavigationPosition.NEWS -> NewsFragment.TAG
//    BottomNavigationPosition.MEASURE -> MeasureFragment.TAG
    BottomNavigationPosition.SHOP -> ShopFragment.TAG
    BottomNavigationPosition.PROFILE -> ProfileFragment.TAG
    //BottomNavigationPosition.BLE -> BleFragment.TAG
}
