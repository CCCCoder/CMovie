package com.n1njac.cmovie.ui.startup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.n1njac.cmovie.R
import kotlinx.android.synthetic.main.activity_launcher.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by N1njaC on 2019/4/15 22:28.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        setTimeFormat()
        delayStartUp()
    }

    private fun setTimeFormat() {
        val format = SimpleDateFormat("yyyy年MM月dd日,EEEE", Locale.getDefault())
        time_tv.text = format.format(System.currentTimeMillis())
    }

    private fun delayStartUp() {
        GlobalScope.launch {
            delay(3000)
            startActivity(Intent(this@LauncherActivity, MainActivity::class.java))
            finish()
        }
    }
}