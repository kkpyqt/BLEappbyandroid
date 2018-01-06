package com.wehand.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wehand.adapter.OnItemClickListener
import com.wehand.R
import com.wehand.adapter.UserListAdapter
import com.wehand.adapter.UserListHolder
import com.wehand.database.DatabaseHandler
import com.wehand.model.ModelUserInfo
//import com.wehand.ui.DetailUserlistDialog

class UserFragment : Fragment(){
//class UserFragment : Fragment(), OnItemClickListener, DetailUserlistDialog.OnDialogItemClick {
//    private var dataUserList: MutableList<ModelUserInfo> = ArrayList()
//    private var positionStats = 0
//    lateinit private var adapterUserList: UserListAdapter
//    //删除数据操作
//    override fun dialogDeleteCallback(data: ModelUserInfo) {
//        this.dataUserList.remove(data)
//        adapterUserList.notifyDataSetChanged()
////        判断有无数据
//        if (this.dataUserList.size > 0) {
//            textEmpty.visibility = View.GONE
//        } else {
//            textEmpty.visibility = View.VISIBLE
//        }
//
//    }
//
//    override fun dialogEditCallback(data: ModelUserInfo) {
//
//        val bind = Bundle()
//        bind.putParcelable("DATA", data)
////        修改数据跳转
//        val edit = Intent(this, UpdateDataMahasiswaActivity::class.java)
//        edit.putExtras(bind)
//        startActivityForResult(edit, 1)
//    }
//
//    override fun onClick(data: ModelUserInfo, position: Int) {
//        DetailMahasiswaDialog.newInstance(data, this).show(supportFragmentManager, "DETAIL")
//        positionStats = position
//    }
    companion object {
        val TAG: String = UserFragment::class.java.simpleName
        fun newInstance() = UserFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity.title = getString(R.string.title_user)
        val view = inflater?.inflate(R.layout.fragment_user, container, false)
        return view
    }


}