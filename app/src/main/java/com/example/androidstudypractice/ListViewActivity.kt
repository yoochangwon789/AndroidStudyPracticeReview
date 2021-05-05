package com.example.androidstudypractice

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carForList = ArrayList<CarForList>()
        for (i in 0 until 10) {
            carForList.add(CarForList("" + i + " 번째 자동차", "" + i + "엔진 입니다."))
        }


        // LayoutInflater 를 사용 하기 위한 셋팅
        val layoutInflaterTest = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // this 키워드를 넣어줘도 되고 위에 선언한 layoutInflaterTest 을 넣어줘도 된다
        val container = LayoutInflater.from(this)

        val adapter = ListViewAdapter(carForList, layoutInflaterTest)
        val listViewResult = findViewById<ListView>(R.id.list_view)
        listViewResult.adapter = adapter

        listViewResult.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this, carName + " " + carEngine, Toast.LENGTH_SHORT).show()
        }
    }
}

class ListViewAdapter(val carForList: ArrayList<CarForList>, val layoutInflater: LayoutInflater) :
    BaseAdapter() {

    override fun getCount(): Int {
        return carForList.size
    }

    override fun getItem(position: Int): Any {
        return carForList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.item_view, null)

        val carName = view.findViewById<TextView>(R.id.car_name)
        val carEngine = view.findViewById<TextView>(R.id.car_engine)

        carName.setText(carForList.get(position).name)
        carEngine.setText(carForList.get(position).engine)

        return view
    }
}
