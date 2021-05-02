package com.example.androidstudypractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phone_book_select.*

class PhoneBookSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_select)

        back_btn.setOnClickListener {
            val resultIntent = Intent()
            finish()
        }
    }
}