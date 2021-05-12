package com.example.androidstudypractice

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.iulilkafragment_one.*

class IuLilkaFragmentOne: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.iulilkafragment_one, container, false)

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

        val adapter = FragmentRecyclerViewAdapterOne(iuLilkaImageTextList)
        val recyclerView = view.findViewById<RecyclerView>(R.id.iu_lilka_recycler_view_one)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = GridLayoutManager(this.context, 2)

        return view
    }
}

class FragmentRecyclerViewAdapterOne(
    val iuLilkaImageTextList: IuLilkaImageTextList,
) : RecyclerView.Adapter<FragmentRecyclerViewAdapterOne.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var personImage: ImageView? = null
        var personName: TextView? = null
        var personAge: TextView? = null

        init {
            personImage = itemView.findViewById(R.id.singer_image)
            personName = itemView.findViewById(R.id.singer_name)
            personAge = itemView.findViewById(R.id.singer_age)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.singer_item_view, parent, false)
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