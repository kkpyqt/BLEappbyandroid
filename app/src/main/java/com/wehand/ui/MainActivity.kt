package com.wehand.ui
/*
实现用户登陆后activy
创建日期
作者：
修改记录：
     1.实现界面，及跳转
     */
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.wehand.R
import com.wehand.extension.*
import com.wehand.helper.*
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val KEY_POSITION = "keyPosition"
    //默认打开tab位置
    private var navPosition: BottomNavigationPosition = BottomNavigationPosition.MEASURE

    private lateinit var toolbar: Toolbar

    private lateinit var bottomNavigation: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restoreSaveInstanceState(savedInstanceState)
        setContentView(R.layout.activity_main)
//        标题栏
        toolbar = findViewById(R.id.toolbar)
//        导航
        bottomNavigation = findViewById(R.id.bottom_navigation)
        setSupportActionBar(toolbar)
        setupBottomNavigation()
//        内容框
        initFragment(savedInstanceState)
//        获取login activity当前登陆用户
        var loginname = intent.getStringExtra("name")
        Toast.makeText(this.applicationContext, "当前用户"+loginname.toString(), Toast.LENGTH_SHORT).show()

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        // Store the current navigation position.
        outState?.putInt(KEY_POSITION, navPosition.id)
        super.onSaveInstanceState(outState)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        navPosition = findNavigationPositionById(item.itemId)
        return switchFragment(navPosition.createFragment(), navPosition.getTag())
    }

    private fun restoreSaveInstanceState(savedInstanceState: Bundle?) {
        // Restore the current navigation position.
        //默认打开fragment位置
//        TODO 为啥没跳到测量界面
        savedInstanceState?.also {
            val id = it.getInt(KEY_POSITION, BottomNavigationPosition.MEASURE.id)
            navPosition = findNavigationPositionById(id)
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.disableShiftMode()
        bottomNavigation.active(navPosition.position)
        bottomNavigation.setOnNavigationItemSelectedListener(this)
    }
//初始化内容框
    private fun initFragment(savedInstanceState: Bundle?) {
        savedInstanceState ?: switchFragment(UserFragment.newInstance(), UserFragment.TAG)
    }

    /**
     * Immediately execute transactions with FragmentManager#executePendingTransactions.
     * initfragment ->switchfragment ->datachfragment.->attachragment
     */
    private fun switchFragment(fragment: Fragment, tag: String): Boolean {
        if (fragment.isAdded) return false
        detachFragment()
        attachFragment(fragment, tag)
        supportFragmentManager.executePendingTransactions()
        return true
    }

    private fun detachFragment() {
        supportFragmentManager.findFragmentById(R.id.container)?.also {
            supportFragmentManager.beginTransaction().detach(it).commit()
        }
    }
//   跳转到哪个fragment
    private fun attachFragment(fragment: Fragment, tag: String) {
        if (fragment.isDetached) {
//            是在这里加入要传送的数据？
            supportFragmentManager.beginTransaction().attach(fragment).commit()
        } else {
            supportFragmentManager.beginTransaction().add(R.id.container, fragment, tag).commit()
        }
        // Set a transition animation for this transaction.
        supportFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
    }

}
