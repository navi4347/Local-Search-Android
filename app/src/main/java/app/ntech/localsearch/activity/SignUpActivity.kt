package app.ntech.localsearch.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import app.ntech.localsearch.R
import app.ntech.localsearch.databinding.SignupBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var mbinding : SignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this, R.layout.signup)
    }
}