package com.example.androidstudypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_book)

        val sampleDataImage = mutableListOf<Int>(
            R.drawable.lilka,
            R.drawable.iu_one,
            R.drawable.iu_two,
            R.drawable.iu_three,
            R.drawable.iu_four
        )
        val sampleDataName = mutableListOf<String>("릴카", "아이유", "아이유", "아이유", "아이유")
        val sampleDataAge = mutableListOf<String>("30", "28", "28", "28", "28")

        val iuLilkaImageTextList: IuLilkaImageTextList = IuLilkaImageTextList()

        for (i in 0 until sampleDataAge.size) {
            val personIuLilka = PersonIuLilka(
                sampleDataImage.get(i),
                sampleDataName.get(i), sampleDataAge.get(i)
            )

            iuLilkaImageTextList.addPersonIuLilka(personIuLilka)
        }

        val container = LayoutInflater.from(this)
        val adapter = AdapterRecyclerView(iuLilkaImageTextList, container)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_book)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}

class IuLilkaImageTextList() {
    val personIuLilkaList = ArrayList<PersonIuLilka>()

    fun addPersonIuLilka(personIuLilka: PersonIuLilka) {
        personIuLilkaList.add(personIuLilka)
    }
}

class PersonIuLilka(val image: Int, val name: String, val age: String) {
}

class AdapterRecyclerView(
    val iuLilkaImageTextList: IuLilkaImageTextList,
    val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var personImage: ImageView? = null
        var personName: TextView? = null
        var personAge: TextView? = null

        init {
            personImage = itemView.findViewById<ImageView>(R.id.singer_image)
            personName = itemView.findViewById<TextView>(R.id.singer_name)
            personAge = itemView.findViewById<TextView>(R.id.singer_age)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.singer_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personImage?.setImageResource(iuLilkaImageTextList.personIuLilkaList.get(position).image)
        holder.personName?.setText(iuLilkaImageTextList.personIuLilkaList.get(position).name)
        holder.personAge?.setText(iuLilkaImageTextList.personIuLilkaList.get(position).age)
    }

    override fun getItemCount(): Int {
        return iuLilkaImageTextList.personIuLilkaList.size
    }
}