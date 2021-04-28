package com.example.androidstudypractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent1.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        btn1.setOnClickListener {
            val intent = Intent(this@Intent1, Intent2::class.java)

            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }

            //startActivity(intent)
            startActivityForResult(intent, 200)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 200) {
            Log.d("number", "" + requestCode)
            Log.d("number", "" + resultCode)

            val result = data?.getIntExtra("result", 0)
            Log.d("number", "" + result)
        }
    }
}