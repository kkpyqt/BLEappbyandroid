package com.wehand.ui
//注册用户界面
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.wehand.R
import com.wehand.database.DatabaseHandler
import kotlinx.android.synthetic.main.activity_newuser.*
import org.jetbrains.anko.toast

import com.wehand.model.ModelUserInfo
import kotlinx.android.synthetic.main.activity_login.*

class NewUserActivity : AppCompatActivity() {


    var dbHandler: DatabaseHandler? = null


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
        setContentView(R.layout.activity_newuser)

        initOperations()

    }
    fun  initOperations() {

        regist_button.setOnClickListener {

            if (et_newaccount.text.toString().isNotEmpty() && et_newpassword.text.toString().isNotEmpty() && et_newpassword2.text.toString().isNotEmpty()) {
                if (et_newpassword.text.toString().equals(et_newpassword2.text.toString())) {
                    //新增用户
                    val username = et_newaccount.text.trim().toString()
                    val passwd = et_newpassword.text.trim().toString()
                    //新增前先检查用户是否存在TODO if
                    if (adduser(_name = username,_passwd = passwd) ==1)      {
                        toast(R.string.addsucess)
//                        TODO 自动跳转到首页
                        val intent = Intent(this, LoginActivity::class.java)
                        intent.putExtra("name", et_newaccount.text.toString())
                        startActivity(intent)
                    }

//TODO 后继增加短信验证码支持
                } else {
                    toast(R.string.noequalspwd)
                    et_newpassword.text = null
                    et_newpassword2.text = null

                }
            }

        }
    }
    fun adduser(_name: String,_passwd: String):Int{
        //                    要先检查用户是否在用户表中已存在,没检查到是什么原因? TODO
        if (dbHandler!!.addUser(_name,_passwd)){

            toast(R.string.addsucess)
            return  1

        }else {
            toast(R.string.userexist)
            return 0

        }

    }
    fun initDB() {
        dbHandler = DatabaseHandler(this)
        // 获取已存取数据



    }
    override fun onResume() {
        super.onResume()
        initDB()
    }
    override fun onDestroy() {
        super.onDestroy()
//        this.dbHandler.closeDatabase()
    }
}
