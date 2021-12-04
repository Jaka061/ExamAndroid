package com.example.exam_zhaka

import android.content.Context
import android.os.Bundle
import android.view.View
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
    private var index = 0
    private val nameList = mutableListOf<String>()
    private val numList = mutableListOf<String>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<AppCompatEditText>(R.id.name)
        val num = view.findViewById<AppCompatEditText>(R.id.num)
        val add = view.findViewById<AppCompatButton>(R.id.bottom)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = LinearLayoutManager(activity)


        val adapter = SimpleAdapter {
            val text = nameList[index]
            val num = numList[index]
            listener.setText1(text,num)


        }
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))

        if(name.text?.isNotEmpty() == true) {
            if(num.text?.isNotEmpty() == true) {
                add.setOnClickListener {
                    for (i in 0..50) {
//                nameList.add(i,name.toString())
//                numList.add(i,num.toString())
                        nameList.add("Name - $it")
                        numList.add("05 - $it 745")
                    }
                    val contact = Contacts(nameList[index], numList[index])
                    adapter.setContact(contact)
                    index++
                }
            }
        }

    }


}

