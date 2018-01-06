//package com.wehand.ui
//
//
//
//import android.os.Bundle
//import android.support.design.widget.BottomSheetDialogFragment
//import android.support.v7.app.AlertDialog
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import com.wehand.database.DatabaseHandler
//import com.wehand.model.ModelUserInfo
//import kotlinx.android.synthetic.main.dialog_detail_userinfo.*
//import com.wehand.R
//
//
//
///**
// * Created by jonesrandom on 11/14/17.
// *
// * #JanganLupaBahagia
// *展示用户明细对话框
// */
//
//class DetailUserlistDialog : BottomSheetDialogFragment() {
//
//    private var dataUserlist = ModelUserInfo()
//    var dbHandler: DatabaseHandler? = null
//
//
//
//    companion object {
//        lateinit private var listeners: OnDialogItemClick
//
//        fun newInstance(data: ModelUserInfo, listener: OnDialogItemClick): DetailUserlistDialog {
//
//            listeners = listener
//            val detail = DetailUserlistDialog()
//
//            val bind = Bundle()
//            bind.putParcelable("DATA", data)
//
//            detail.arguments = bind
//            return detail
//
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val args = arguments
//
//        if (args != null)
//            dataUserlist = args.getParcelable("DATA")
////        toast("这个是对话窗口")
//        //    实例化数据库连接器
//        dbHandler = DatabaseHandler(this)
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.dialog_detail_userinfo, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        dialogNama.text = dataUserlist.name.toUpperCase()
//        dialogNim.text = dataUserlist.name.toString()
//        dialogSemester.text = dataUserlist.iscurrentuser
////用户详情操作按钮
//        toolbarDialog.inflateMenu(R.menu.userinfo_dialog_menu)
//        toolbarDialog.setOnMenuItemClickListener {
//
//            when (it.itemId) {
////编辑选中
//                R.id.dialogEdit -> {
//                    listeners.dialogEditCallback(dataUserlist)
//                    dialog.dismiss()
//                }
////                删除选中
////
//                R.id.dialogHapus -> {
//                    val build = context?.let { it1 -> AlertDialog.Builder(it1) }
//                    build?.setTitle("Hapus Data")
//                    build?.setMessage("Apakah Kamu Ingin Menghapus Data ${dataUserlist.name.toUpperCase()}")
//                    build?.setPositiveButton("HAPUS", { _, _ ->
////TODO 要实例化才能 启用连接器
//                        val stas = dbHandler!!.deleteUserInfobyId(dataUserlist.id)
//
//                        if (stas != 0) {
//                            dialog.dismiss()
//                            listeners.dialogDeleteCallback(dataUserlist)
//
//                            Toast.makeText(activity, "Berhasil Menghapus Data", Toast.LENGTH_SHORT).show()
//                        } else {
//                            Toast.makeText(activity, "Gagal Menghapus Data", Toast.LENGTH_SHORT).show()
//                        }
//
//                    })
//                    build?.setNegativeButton("BATAL", null)
//                    build?.create()?.show()
//                }
//            }
//            true
//        }
//    }
//
//    interface OnDialogItemClick {
//        fun dialogEditCallback(data: ModelUserInfo)
//        fun dialogDeleteCallback(data: ModelUserInfo)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        dbHandler!!.closeDatabase()
//    }
//}