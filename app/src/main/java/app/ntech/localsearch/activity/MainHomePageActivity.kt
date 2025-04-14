package app.ntech.localsearch.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import app.ntech.localsearch.R
import app.ntech.localsearch.databinding.HomedashboardactivityBinding
import app.ntech.localsearch.fragments.FoodFrag
import app.ntech.localsearch.fragments.HomePageFrag
import app.ntech.localsearch.fragments.MovieTheaterFrag
import app.ntech.localsearch.fragments.ProfilePageFrag

class MainHomePageActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<HomedashboardactivityBinding>(this,
            R.layout.homedashboardactivity
        )
        openFragment(HomePageFrag())
        binding.bottomNavigationView?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    openFragment(HomePageFrag())
                }
                R.id.movie -> {
                    openFragment(MovieTheaterFrag())
                }
                R.id.food -> {
                    openFragment(FoodFrag())
                }
              /*  R.id.homelist -> {
                    openFragment(ProfilePageFrag())
                }*/
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun openFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
    }

        override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }
}