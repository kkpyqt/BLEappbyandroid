package com.wehand.helper
/*
实现fragment 列表
创建日期
作者：
修改记录：
     1.实现界面，及跳转
     */
import android.support.v4.app.Fragment
import com.wehand.R
import com.wehand.ui.*
//从R.menu.navigation.xml 读取ID
//在navigation.xml 中可以定义每个 fragment 用到的图标
//中文显示名从R.string.id name 中读取
enum class BottomNavigationPosition(val position: Int, val id: Int) {
    USER(2, R.id.user),
    NEWS(1, R.id.news),
    MEASURE(0, R.id.measure),
    SHOP(3, R.id.shop),

    PROFILE(4, R.id.profile);
}
//根据操作栏ID ,得到位置名称
fun findNavigationPositionById(id: Int): BottomNavigationPosition = when (id) {
    BottomNavigationPosition.USER.id -> BottomNavigationPosition.USER
    BottomNavigationPosition.NEWS.id -> BottomNavigationPosition.NEWS
    BottomNavigationPosition.MEASURE.id -> BottomNavigationPosition.MEASURE
    BottomNavigationPosition.SHOP.id -> BottomNavigationPosition.SHOP
    BottomNavigationPosition.PROFILE.id -> BottomNavigationPosition.PROFILE
//
   // BottomNavigationPosition.BLE.id -> BottomNavigationPosition.BLE
    else -> BottomNavigationPosition.MEASURE
}
//根据操作栏占据图标，判断要哪个界面实例化
fun BottomNavigationPosition.createFragment(): Fragment = when (this) {
    BottomNavigationPosition.USER -> UserFragment.newInstance()
    BottomNavigationPosition.NEWS -> NewsFragment.newInstance()
    BottomNavigationPosition.MEASURE -> MeasureFragment.newInstance()
    BottomNavigationPosition.SHOP -> ShopFragment.newInstance()
    BottomNavigationPosition.PROFILE -> ProfileFragment.newInstance()
//
    //BottomNavigationPosition.BLE -> BleFragment.newInstance()
}

fun BottomNavigationPosition.getTag(): String = when (this) {
    BottomNavigationPosition.USER -> UserFragment.TAG
    BottomNavigationPosition.NEWS -> NewsFragment.TAG
    BottomNavigationPosition.MEASURE -> MeasureFragment.TAG
    BottomNavigationPosition.SHOP -> ShopFragment.TAG
    BottomNavigationPosition.PROFILE -> ProfileFragment.TAG
    //BottomNavigationPosition.BLE -> BleFragment.TAG
}

