package com.example.myapplication


import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.Utils.local
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    private lateinit var locale: Locale
    private lateinit var configuration: Configuration


    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configuration = Resources.getSystem().configuration

        val id: String = local.getLocale(this)

        if(id=="en"){
            btnEN.setBackgroundColor(getColor(android.R.color.white))
        }else{
            btnIN.setBackgroundColor(getColor(android.R.color.white))
        }

        btnEN.setOnClickListener {
            locale = Locale("en")
            configuration.locale = locale
            resources.updateConfiguration(configuration, resources.displayMetrics)
            recreate()
        }

        btnIN.setOnClickListener {
            locale = Locale("in")
            configuration.locale = locale
            resources.updateConfiguration(configuration, resources.displayMetrics)
            recreate()
        }


        btn_login.setOnClickListener {
            if(tvUsername.text.toString().isEmpty()){
                tvUsername.error = "Isi Username !!!"
                return@setOnClickListener
            }

            if(tvPassword.text.toString().isEmpty()){
                tvPassword.error ="Isi Password !!!"
                return@setOnClickListener
            }

            val emailRegex =     "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
            val pattern = Pattern.compile(Constant.REGEX_EMAIL, Pattern.CASE_INSENSITIVE)
            if(!pattern.matcher(emailRegex).matches()){
                tvUsername.error = "Emailnya bukan format email yang valid"
                return@setOnClickListener
            }

            if (tvPassword.text.toString().length < 5){
                tvPassword.error = "Password Minimal 5 Karakter"
            }

            if (tvPassword.text.toString().length > 8) {
                tvPassword.error ="Password Maksimal 8 Karakter"
            }

                Toast.makeText(this,"MANTUL", Toast.LENGTH_SHORT).show()
        }
    }
}
