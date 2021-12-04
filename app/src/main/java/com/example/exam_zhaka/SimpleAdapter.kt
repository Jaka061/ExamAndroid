package com.example.exam_zhaka

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter(
    private val click: (pos: Int) -> Unit) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    var contList = ArrayList<Contacts>()

    fun setContact(contact : Contacts) {
        contList.add(contact)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.recycle, parent, false)
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacts = contList[position]
        holder.bind(contacts)
    }

    override fun getItemCount(): Int {
        return contList.size
    }

    class ViewHolder(itemView: View, private val click: (pos: Int) -> Unit ) : RecyclerView.ViewHolder(itemView) {
        fun bind(contacts: Contacts) {
            val txt = itemView.findViewById<AppCompatTextView>(R.id.item_txt)
            val btn = itemView.findViewById<AppCompatButton>(R.id.btn)

            txt.text = contacts.name
            btn.setOnClickListener {
                click.invoke(adapterPosition)
            }
        }
    }
}