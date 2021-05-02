package com.example.androidstudypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get

class AddView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        val carForList = ArrayList<CarForList>()
        for (i in 0 until 10) {
            carForList.add(CarForList(""+i+" 번째 자동차", ""+i+"엔진 입니다."))
        }

        val container = findViewById<LinearLayout>(R.id.addView_container)
        val inflater = LayoutInflater.from(this)

        for (i in 0 until carForList.size) {
            val itemView = inflater.inflate(R.layout.item_view, null)
            val carNameView = itemView.findViewById<TextView>(R.id.car_name)
            val carEngineView = itemView.findViewById<TextView>(R.id.car_engine)

            carNameView.setText(carForList.get(i).name)
            carEngineView.setText(carForList.get(i).engine)
            container.addView(itemView)
        }
    }
}

class CarForList(val name: String, val engine: String) {

}