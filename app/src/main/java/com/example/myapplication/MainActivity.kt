package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            if(tvUsername.text.toString().isEmpty()){
                tvUsername.error = "Isi Username !!!"
                return@setOnClickListener
            }
            if(tvPassword.text.toString().isEmpty()){
                tvPassword.error ="Isi Password !!!"
                return@setOnClickListener
            }

            val emailRegex =  "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$"
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
            Toast.makeText(this,"MANTUL BOS", Toast.LENGTH_SHORT ).show()


        }
    }
}
