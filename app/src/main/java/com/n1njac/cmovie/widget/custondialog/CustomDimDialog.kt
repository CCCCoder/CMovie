package com.n1njac.cmovie.widget.custondialog

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatDialog
import androidx.core.content.res.ResourcesCompat
import com.n1njac.cmovie.R

/**
 * Created by N1njaC on 2019/6/2 15:43.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class CustomDimDialog(context: Context?) : AppCompatDialog(context, R.style.CustomDimDialog) {

    init {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.run {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }

    override fun setContentView(view: View?) {
        if (view != null) {
            super.setContentView(wrap(view))
        }
    }

    private fun wrap(content: View): View {
        val res = context.resources
        val verticalMargin = res.getDimensionPixelSize(R.dimen.dialog_vertical_margin)
        val horizontalMargin = res.getDimensionPixelSize(R.dimen.dialog_horizontal_margin)
        return FrameLayout(context).apply {
            addView(content, FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
                    .apply {
                        setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin)
                        gravity = Gravity.CENTER
                    })
            val rect = Rect()
            setOnTouchListener { _, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        content.getGlobalVisibleRect(rect)
                        if (!rect.contains(event.x.toInt(), event.y.toInt())) {
                            cancel()
                            true
                        } else {
                            false
                        }
                    }
                    else -> false
                }
            }
            background = ColorDrawable(ResourcesCompat.getColor(res, R.color.scrim, context.theme))
        }
    }
}