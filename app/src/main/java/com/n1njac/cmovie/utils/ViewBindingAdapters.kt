package com.n1njac.cmovie.utils

import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.View.INVISIBLE
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by N1njaC on 2019/5/12 15:19.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */

@BindingAdapter("goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) VISIBLE else GONE
}

@BindingAdapter("invisibleUnless")
fun invisibleUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) VISIBLE else INVISIBLE
}

@BindingAdapter(value = ["imageUri", "placeholder"], requireAll = false)
fun imageUri(view: ImageView, imageUrl: String, placeholder: Drawable?) {
    Glide.with(view)
        .load(imageUrl)
        .apply(RequestOptions.placeholderOf(placeholder))
        .into(view)
}