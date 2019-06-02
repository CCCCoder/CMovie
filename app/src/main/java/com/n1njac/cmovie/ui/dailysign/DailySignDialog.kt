package com.n1njac.cmovie.ui.dailysign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.n1njac.cmovie.databinding.DialogDailysignBinding
import com.n1njac.cmovie.widget.custondialog.CustomDimDialogFragment

/**
 * Created by N1njaC on 2019/6/2 15:34.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class DailySignDialog : CustomDimDialogFragment() {

    private lateinit var mBinding: DialogDailysignBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DialogDailysignBinding.inflate(inflater, container, false)

        return mBinding.root
    }
}