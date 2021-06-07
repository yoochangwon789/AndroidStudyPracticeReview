package com.example.androidstudypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rec_test)

        val dataList = ArrayList<TextListTest>()
        dataList.add(TextListTest("TEST"))
        dataList.add(TextListTest("TEST1"))
        dataList.add(TextListTest("TEST2"))

        val container = LayoutInflater.from(this)
        val adapter = RecAdapterView(dataList, container)
        val recyclerView = findViewById<RecyclerView>(R.id.rec_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}

class TextListTest(val recText: String)

class RecAdapterView(
    val dataList : List<TextListTest>,
    val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<RecAdapterView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null

        init {
            textView = itemView.findViewById(R.id.rec_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.rec_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView?.setText(dataList[position].recText)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}