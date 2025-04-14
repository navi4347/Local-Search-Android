package app.ntech.localsearch.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import app.ntech.localsearch.R
import app.ntech.localsearch.databinding.LoginpageBinding
import com.google.firebase.auth.FirebaseAuth

class Loginpage : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var mbinding : LoginpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding  = DataBindingUtil.setContentView(this, R.layout.loginpage)

        mbinding.btlogin.setOnClickListener {
                   startActivity(Intent(this, MainHomePageActivity::class.java))
            finish()
        }
        mbinding.txtsignin.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))

        }
    }
}