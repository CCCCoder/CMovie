package com.n1njac.cmovie.ui.startup

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.n1njac.cmovie.R
import com.n1njac.cmovie.ui.about.AboutFragment
import com.n1njac.cmovie.ui.dailysign.DailySignDialog
import com.n1njac.cmovie.ui.ticketing.TicketingFragment
import com.n1njac.cmovie.ui.top.TopMovieFragment
import com.n1njac.cmovie.utils.*
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalStateException

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var mCurrentFragment: Fragment

    companion object {
        private const val FRAGMENT_ID = R.id.fragment_container
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation_bn.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_showing -> consume { replaceFragment(TicketingFragment()) }
                R.id.navigation_all -> consume { replaceFragment(TopMovieFragment()) }
                R.id.navigation_me -> consume { replaceFragment(AboutFragment()) }
                else -> false
            }
        }

        if (savedInstanceState == null) {
            navigation_bn.selectedItemId = R.id.navigation_showing
        } else {
            mCurrentFragment = supportFragmentManager.findFragmentById(FRAGMENT_ID)
                    ?: throw IllegalStateException("Activity recreated, but no fragment found!")
        }

        val dialog = DailySignDialog()
        dialog.show(supportFragmentManager, "daily_dialog")

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.inTransaction {
            mCurrentFragment = fragment
            replace(FRAGMENT_ID, fragment)
        }
    }
}
