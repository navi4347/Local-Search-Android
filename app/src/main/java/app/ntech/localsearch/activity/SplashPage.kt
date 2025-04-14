package app.ntech.localsearch.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import app.ntech.localsearch.CommonUtils
import app.ntech.localsearch.R
import app.ntech.localsearch.databinding.SplashpageBinding
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.os.Build
import android.content.pm.PackageManager

class SplashPage : AppCompatActivity() {

    lateinit var mBinding : SplashpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.splashpage)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    1001
                )
            }
        }

        Handler().postDelayed({
            startnextscreen()
        }, 2000)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    fun startnextscreen() {
        if (CommonUtils.isConnected(this)){
            startActivity(Intent(this, MainHomePageActivity::class.java))
            finish()
        }else{
            Toast.makeText(this,"Check your internet connection", Toast.LENGTH_SHORT).show()
            finish()
        }


    }
}