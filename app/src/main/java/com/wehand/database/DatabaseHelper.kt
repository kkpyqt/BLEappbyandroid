package com.wehand.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import android.util.Log


import com.wehand.model.ModelUserInfo
import java.util.*

/**
 * Created by kkpyqt on 17-12-30.
 * 数据库操作类
 */


class DatabaseHandler(ctx: Context) : SQLiteOpenHelper(ctx,DatabaseHandler.DB_NAME, null, DatabaseHandler.DB_VERSION) {

        companion object {
            private val DB_VERSION = 1
            private val DB_NAME = "YNBLEAPP"
            private val TABLE_NAME = "Userinfo"

            private val ROW_ID = "_id"
            private val ROW_NAME = "name"
            private val ROW_ISREMEMBER = "isremember"
            private val ROW_ISREGIST = "isregist"
            private val ROW_PASSWD = "passwd"
            private val ROW_ISCURRENTUSER ="iscurrentuser"
// writableDatabase 跟这个有关
//            private lateinit var database: SQLiteDatabase
//            private var databaseOpen: Boolean = false
//
//            fun closeDatabase() {
//                if (database.isOpen && databaseOpen) {
//                    database.close()
//                    databaseOpen = false
//
//                    Log.i("Database" , "Database close")
//                }
        }
//    创建表
        override fun onCreate(db: SQLiteDatabase) {
            val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME ($ROW_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " $ROW_NAME TEXT , $ROW_ISREMEMBER TEXT , $ROW_ISREGIST TEXT,$ROW_PASSWD TEXT,ROW_ISCURRENTUSER TXT)"
            db.execSQL(CREATE_TABLE)
        }
//    删除表
        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        db.execSQL(DROP_TABLE)
        onCreate(db)
        }





//        新增操作
        fun addUser(userInfo: ModelUserInfo): Boolean {
            val db = this.writableDatabase
            val values = ContentValues()
//            设置构造器与表模型的对应关系
            values.put(ROW_NAME,userInfo.name)
            values.put(ROW_ISREGIST, userInfo.isregist)
            values.put(ROW_ISREMEMBER, userInfo.isremember)
            values.put(ROW_PASSWD, userInfo.passwd)
            val _success = db.insert(TABLE_NAME, null, values)
            db.close()
            Log.v("InsertedId", "$_success")
            return (Integer.parseInt("$_success") != -1)
        }
//获取指定ID  的用户数据
        fun getuserInfobyId(_id: Int): ModelUserInfo {
            val userInfo = ModelUserInfo()
            val db = writableDatabase
            val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE $ROW_ID = $_id"
            val cursor = db.rawQuery(selectQuery, null)
//    列上的值都是来源于object
            cursor?.moveToFirst()
            userInfo.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ROW_ID)))
            userInfo.name = cursor.getString(cursor.getColumnIndex(ROW_NAME))
            userInfo.isremember = cursor.getString(cursor.getColumnIndex(ROW_ISREMEMBER))
            userInfo.iscurrentuser = cursor.getString(cursor.getColumnIndex(ROW_ISCURRENTUSER))

            cursor.close()
            return userInfo
        }
//
//获取指定用户名  的用户密码等数据
        fun getuserInfobyName(_name: String): ModelUserInfo {
            val userInfo = ModelUserInfo()
            val db = writableDatabase
            val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE $ROW_ID = $_name"
            val cursor = db.rawQuery(selectQuery, null)
        //    列上的值都是来源于object
            cursor?.moveToFirst()
            userInfo.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ROW_ID)))
            userInfo.name = cursor.getString(cursor.getColumnIndex(ROW_NAME))
            userInfo.passwd = cursor.getString(cursor.getColumnIndex(ROW_PASSWD))
            userInfo.isremember = cursor.getString(cursor.getColumnIndex(ROW_ISREMEMBER))
            userInfo.iscurrentuser = cursor.getString(cursor.getColumnIndex(ROW_ISCURRENTUSER))

            cursor.close()
            return userInfo
        }

    //修改用户明细操作,有返回值
        fun updateUserifno(userInfo: ModelUserInfo): Boolean {
            val db = this.writableDatabase
            val values = ContentValues()
//        /            设置构造器与表模型的对应关系
            values.put(ROW_NAME,userInfo.name)
            values.put(ROW_ISREGIST, userInfo.isregist)
            values.put(ROW_ISREMEMBER, userInfo.isremember)
            values.put(ROW_ISCURRENTUSER, userInfo.iscurrentuser)
            values.put(ROW_PASSWD, userInfo.passwd)

            val _success = db.update(TABLE_NAME, values, ROW_ID + "=?", arrayOf(userInfo.id.toString())).toLong()
            db.close()
            return Integer.parseInt("$_success") != -1
        }
//        修改操作
        fun updateUserPwd(userInfo: ModelUserInfo,_name: String): Boolean {
            val db = this.writableDatabase
//            val values = ContentValues()
////            /            设置构造器与表模型的对应关系
//
//            values.put(ROW_PASSWD, userInfo.passwd)
//
//            val _success = db.update(TABLE_NAME, values, ROW_NAME + "=?","$_name").toLong()
            val UPDATE_TABLE = "UPDATE $TABLE_NAME SET $ROW_PASSWD = ${userInfo.passwd} WHERE $ROW_NAME =$_name"
            val _success =db.execSQL(UPDATE_TABLE)
            db.close()
            return Integer.parseInt("$_success") != -1
        }
//获取所有记录
        fun allUserInfo(): MutableList<ModelUserInfo> {
            val userList = ArrayList<ModelUserInfo>()
            val db = writableDatabase
            val selectQuery = "SELECT  * FROM $TABLE_NAME"
            Log.i("DatabaseHelper",selectQuery)
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        val userinfo = ModelUserInfo()
                        userinfo.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ROW_ID)))
                        userinfo.name = cursor.getString(cursor.getColumnIndex(ROW_NAME))
                        userinfo.isremember = cursor.getString(cursor.getColumnIndex(ROW_ISREMEMBER))
                        userinfo.iscurrentuser = cursor.getString(cursor.getColumnIndex(ROW_ISCURRENTUSER))

                        userList.add(userinfo)
                    } while (cursor.moveToNext())
                }
            }
            cursor.close()
            return userList
            Log.i("DatabaseHelper","OK")
        }

//    删除指定ID  用户
        fun deleteUserInfobyId(_id: Int): Boolean {
            val db = this.writableDatabase
            val _success = db.delete(TABLE_NAME, ROW_ID + "=?", arrayOf(_id.toString())).toLong()
            db.close()
            return Integer.parseInt("$_success") != -1
        }

//删除所胡记录操作
        fun deleteAllUserInfo(): Boolean {
            val db = this.writableDatabase
            val _success = db.delete(TABLE_NAME, null, null).toLong()
            db.close()
            return Integer.parseInt("$_success") != -1
        }
}



