package com.wehand.ui
//注册用户界面
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

class NewUserActivity : AppCompatActivity() {
    private var newuser: String? =null
    private var userpwd: String? =null

    var dbHandler: DatabaseHandler? = null
    val userInfo = ModelUserInfo()
    //    数据列表
    private var listUserInfo: MutableList<ModelUserInfo> = ArrayList()
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
        //        值更新事件,检查用户是否存在,没生效
        et_account.setTextChangeListener {
            if (this.listUserInfo.any { it.name.equals(et_account.toString()) }) {
                toast(R.string.userexist)

            }

        }
        regist_button.setOnClickListener {

            if (et_account.text.toString().isNotEmpty() && et_password.text.toString().isNotEmpty() && et_password2.text.toString().isNotEmpty()) {
                if (et_password.text.toString().equals(et_password2.text.toString())) {
                    //新增用户
                    val username = et_account.text.toString()
                    val passwd = et_password.text.toString()
                    val data = ModelUserInfo()
                    data.name = username
                    data.passwd = passwd
//                    要先检查用户是否在用户表中已存在,没检查到是什么原因? TODO
                    if (this.listUserInfo.any {

                        it.name.equals(et_account.toString())


                    }) {
                        toast(R.string.userexist)

                    } else {
                        this.dbHandler!!.addUser(data)
                        toast(R.string.newscuess)
                    }
//TODO 后继增加短信验证码支持
                } else {
                    toast(R.string.noequalspwd)
                    et_password.text = null
                    et_password2.text = null

                }
            }

        }
    }
    fun initDB() {
        dbHandler = DatabaseHandler(this)
        // 获取已存取数据
        listUserInfo = dbHandler!!.allUserInfo()


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
