package com.n1njac.cmovie.widget

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by N1njaC on 2019/5/9 23:09.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class SpaceDecoration(private val start: Int = 0,
                      private val top: Int = 0,
                      private val end: Int = 0,
                      private val bottom: Int = 0) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.set(start, top, end, bottom)
    }
}