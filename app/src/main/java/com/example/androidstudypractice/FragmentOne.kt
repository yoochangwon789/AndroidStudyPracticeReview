package com.example.androidstudypractice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentOne: Fragment() {

    override fun onAttach(context: Context) {
        Log.d("F_life_cycle", "F_onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("F_life_cycle", "F_onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("F_life_cycle", "F_onCreateView")

        return inflater.inflate(R.layout.fargment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("F_life_cycle", "F_onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("F_life_cycle", "F_onActivityCreated")

        val data = arguments?.getString("hello")
        Log.d("data", data.toString())

        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("F_life_cycle", "F_onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("F_life_cycle", "F_onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("F_life_cycle", "F_onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("F_life_cycle", "F_onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("F_life_cycle", "F_onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("F_life_cycle", "F_onDetach")
        super.onDetach()
    }
}