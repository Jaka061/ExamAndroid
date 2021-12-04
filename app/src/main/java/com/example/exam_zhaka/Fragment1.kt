package com.example.exam_zhaka

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment(R.layout.fragment) {

    private lateinit var listener: OnBtnClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<AppCompatEditText>(R.id.name)
        val num = view.findViewById<AppCompatEditText>(R.id.num)
        val add = view.findViewById<AppCompatButton>(R.id.button)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = LinearLayoutManager(activity)


        val adapter = SimpleAdapter {
            val text = it.name
            val num = it.number
            listener.setText1(text,num)

        }
                add.setOnClickListener {
                    if(name.text.toString().isNotEmpty() && num.text.toString().isNotEmpty()) {
                         val contList = Contacts(name.text.toString(),num.text.toString())
                         Toast.makeText(activity, "Number", Toast.LENGTH_SHORT).show()
                         adapter.setContact(contList)
                    }
                }

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))


    }


}

