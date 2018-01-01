package com.wehand.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wehand.R
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast
import android.widget.EditText
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
//导入数据模型
import com.wehand.database.DatabaseHandler
import com.wehand.model.ModelUserInfo
import kotlinx.android.synthetic.main.fragment_login.*


class LoginActivity : AppCompatActivity() {
//    数据列表
    private var listUserInfo: MutableList<ModelUserInfo> = ArrayList()
    var dbHandler: DatabaseHandler? = null
    var userInfo = ModelUserInfo()

//    用户名可以为空
    private var loginuser: String? =null
    private var passwd: String? =null
    fun EditText.setTextChangeListener(body: (key: String) -> Unit) {
        addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                body(s.toString())
            }


            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initOperations()
    }
    fun initOperations() {
        // 获取已存取数据
//        if (DatabaseHandler
//                .allUserInfo().size> 0) {
//            dataUserInfo = DatabaseHelper.getAllData()
//        }
//        TODO 后续要带用户名到登陆后的界面
//        如果数据集不为空,记住密码显示,否则不显示
//        if (this.dataUserInfo.size > 0) {
//            rem_pas_check.visibility = View.VISIBLE
////
//        } else {
//            rem_pas_check.visibility = View.GONE
//        }
////        定义更新记住密码事件
        et_account.setTextChangeListener {



            //            如果当前用户记录満足记录密码, 刚自动设置密码
            if (this.listUserInfo.any {
                it.isremember.equals("Y")
                it.name.equals(et_account.toString())

            }){
//                TODO 怎么过滤列表的值?过滤当前用户,将密码自动填充
//                类型错误
                this.userInfo = this.dbHandler!!.getuserInfobyName(et_account.toString())

                et_password.setText(this.userInfo.passwd.toString())
            }
        }


        login_button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", et_account.text.toString())

            if (et_account.text.toString().isNotEmpty() && et_password.text.toString().isNotEmpty()) {
//              检验用户名密码,OK 才能通过
                if (this.listUserInfo.any {

                    it.name.equals(et_account.toString())
                    it.passwd.equals(et_password.toString())

                }) {
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, R.string.loginerror, Toast.LENGTH_SHORT).show()
                }
            }  else {
                Toast.makeText(applicationContext, R.string.nologin, Toast.LENGTH_SHORT).show()
            }

        }
// 点取忘记密码跳到通过验证码获取密码activity
//        tv_forgot.setOnClickListener {
//            //            修改密码界面
//            if(et_account.length()>0) {
//
//               Log.i("获取信息",et_account.toString())
//            }
//
//        }
//        新用户注册
        tv_newuser.setOnClickListener {
            val intent = Intent(this, NewUserActivity::class.java)
//            TODO 后继要带用户返回
            startActivity(intent)
        }
    }
    fun initDB() {
        dbHandler = DatabaseHandler(this)
//        再次获取所有用户失败?
        listUserInfo = dbHandler!!.allUserInfo()


    }
    override fun onResume() {
        super.onResume()
        initDB()
    }
    override fun onDestroy() {
        super.onDestroy()
//        DatabaseHelper.closeDatabase()
    }



}
