package com.example.trabajomoviles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProfesorAdapter(context: Context, private val profesores: List<profesor>) :
    ArrayAdapter<profesor>(context, 0, profesores) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)

        val profesor = profesores[position]
        view.findViewById<TextView>(android.R.id.text1).text = profesor.nombre
        view.findViewById<TextView>(android.R.id.text2).text = profesor.materia


        return view
    }
}

