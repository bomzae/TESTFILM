package com.example.testapp2

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    lateinit var sqlDB: SQLiteDatabase
    lateinit var initBtn: Button
    var DB: DBHelper?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        DB = DBHelper(this)

        initBtn = findViewById(R.id.button3)
        initBtn.setOnClickListener {
            sqlDB = DB!!.writableDatabase
            DB!!.onUpgrade(sqlDB, 1, 2)
            sqlDB.close()
        }
    }
}