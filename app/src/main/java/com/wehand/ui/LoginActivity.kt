package com.wehand.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wehand.R
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast
import android.content.Intent


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//        login_button= findViewById(R.id.login_button)
//        et_account  = findViewById(R.id.et_account)
//        et_password = findViewById(R.id.et_password)
//        TODO 后续要带用户名到登陆后的界面
        login_button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", et_account.text.toString())

            if (et_account.text.toString().isNotEmpty() && et_password.text.toString().isNotEmpty())
//                    startActivity(Intent(this, MainActivity::class.java))

                startActivity(intent)
//                    startActivity<Intent(this, MainActivity::class.java)>() else Toast.makeText(this,"请输入账户或者密码",Toast.LENGTH_LONG).show()//toast("请输入账户或者密码")
            else
                Toast.makeText(applicationContext, "请输入账户或者密码", Toast.LENGTH_SHORT).show()
//                toast("请输入用户名，密码")
//Toast.makeText(this,"hello",Toast.LENGTH_LONG).show()
        }
    }



}
