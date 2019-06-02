package com.n1njac.cmovie.widget.custondialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment

/**
 * Created by N1njaC on 2019/6/2 15:42.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
open class CustomDimDialogFragment : AppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return CustomDimDialog(context)
    }
}