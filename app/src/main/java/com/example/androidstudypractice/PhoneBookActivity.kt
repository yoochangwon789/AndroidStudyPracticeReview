package com.example.androidstudypractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.phone_view.*

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        val phoneNumberList = ArrayList<PhoneNumber>()
        for (i in 1..30) {
            phoneNumberList.add(PhoneNumber("" + i, "" + i + "name"))
        }

        val container = findViewById<LinearLayout>(R.id.phoneBook_container)
        val inflater = LayoutInflater.from(this)

        for (i in 0 until phoneNumberList.size) {
            val phoneItemView = inflater.inflate(R.layout.phone_view, null)
            val phoneFirstName = phoneItemView.findViewById<TextView>(R.id.phoneNumber_first_name)
            val phoneName = phoneItemView.findViewById<TextView>(R.id.phoneNumber_name)

            phoneFirstName.setText(phoneNumberList.get(i).firstName)
            phoneName.setText(phoneNumberList.get(i).name)

            phoneFirstName.setOnClickListener {
                val intent = Intent(this, PhoneBookSelect::class.java)
                startActivity(intent)
            }

            container.addView(phoneItemView)
        }
    }
}

class PhoneNumber(val firstName: String, val name: String) {

}