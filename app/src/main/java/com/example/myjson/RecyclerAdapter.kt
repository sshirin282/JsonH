package com.example.myjson

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val context: Context, val  list:ArrayList<DataModel>)
    :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text1)
        val image1: ImageView =view.findViewById(R.id.image2)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val rowView=inflater.inflate(R.layout.list, parent, false)
        return ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val dataModel = list.get(position)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}