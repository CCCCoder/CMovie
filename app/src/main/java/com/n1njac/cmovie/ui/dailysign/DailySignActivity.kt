package com.n1njac.cmovie.ui.dailysign

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.n1njac.cmovie.base.FullScreenActivity
import com.n1njac.cmovie.databinding.ActivityDailySignBinding
import com.n1njac.cmovie.domain.result.EventObserver
import com.n1njac.cmovie.utils.getStatusBarHeight
import com.n1njac.cmovie.utils.viewModelProvider
import com.n1njac.cmovie.widget.ZoomOutPageTransformer
import javax.inject.Inject
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.n1njac.cmovie.domain.usecase.LoadDailySignDataUseCaseResult
import android.graphics.drawable.Drawable
import com.bumptech.glide.request.target.CustomTarget
import androidx.annotation.Nullable
import androidx.core.app.ShareCompat
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.bumptech.glide.request.transition.Transition
import com.qmuiteam.qmui.widget.QMUILoadingView
import jp.wasabeef.glide.transformations.BlurTransformation


/**
 * Created by N1njaC on 2019/5/19 21:27.
 * Copyright (c) 2019 IFLYTEK CO.,LTD. All rights reserved.
 * Mail:aiai173cc@gmail.com
 */
class DailySignActivity : FullScreenActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var mBinding: ActivityDailySignBinding
    private lateinit var mViewModel: DailySignViewModel
    private lateinit var mDataList: MutableList<LoadDailySignDataUseCaseResult>

    companion object {
        private const val TAG = "DailySignActivity"
        fun startDailySignActivity(activity: Activity) {
            val intent = Intent(activity, DailySignActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDailySignBinding.inflate(layoutInflater)
        mViewModel = viewModelProvider(viewModelFactory)
        mBinding.viewModel = mViewModel
        setContentView(mBinding.root)
        adjustToolbarPosition()
        initView()
    }

    private fun adjustToolbarPosition() {
        val params = mBinding.toolbarRl.layoutParams as ConstraintLayout.LayoutParams
        params.setMargins(0, getStatusBarHeight(), 0, 0)
        mBinding.toolbarRl.layoutParams = params
    }

    private fun initView() {
        mViewModel.session.observe(this, Observer {
            it ?: return@Observer
            it.reverse()
            mDataList = it
            val pagerAdapter = DailySignAdapter(this, it)
            mBinding.dailyVp.adapter = pagerAdapter
            mBinding.dailyVp.apply {
                adapter = pagerAdapter
                offscreenPageLimit = 3
                setPageTransformer(false, ZoomOutPageTransformer())
                pageMargin = 0
            }
            setCurrentBg(0)
            //设置从最后位置开始
            mBinding.dailyVp.currentItem = it.size - 1
        })
        mViewModel.errorMsg.observe(this, EventObserver {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
        mBinding.dailyVp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                Log.i(TAG, "onPageSelected pos:$position")
                setCurrentBg(position)
            }
        })

        mViewModel.quitAction.observe(this, EventObserver {
            onBackPressed()
        })

        mViewModel.shareAction.observe(this, EventObserver {
            sharePoster()
        })
    }

    private fun setCurrentBg(position: Int) {
        if (::mDataList.isInitialized && mDataList.isNotEmpty()) {
            Glide.with(this)
                    .load(mDataList[position].posterUrl)
                    .apply(bitmapTransform(BlurTransformation(25, 3)))
                    .into(object : CustomTarget<Drawable>() {
                        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                            mBinding.root.background = resource
                        }

                        override fun onLoadCleared(@Nullable placeholder: Drawable?) {
                        }
                    })
        }
    }

    /**
     * 当前海报生成图片，分享
     */
    private fun sharePoster() {
        ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("test content")
                .setChooserTitle("test title")
                .startChooser()
    }

    override fun onBackPressed() {
        finish()
    }
}