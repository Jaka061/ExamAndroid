package com.example.exam_zhaka

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment2){

private lateinit var listener : OnBtnClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txt = view.findViewById<AppCompatTextView>(R.id.name2)
        val num = view.findViewById<AppCompatTextView>(R.id.num2)

        val textFr = arguments?.getString("textF")
        val textNum = arguments?.get("Num")
        txt.text = textFr
        num.text = textNum.toString()


    }
}