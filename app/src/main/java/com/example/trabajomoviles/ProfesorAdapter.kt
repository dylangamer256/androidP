package com.example.trabajomoviles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.squareup.picasso.Picasso // Importa Picasso para cargar imágenes

// Adaptador personalizado para mostrar una lista de objetos 'profesor' en un ListView
class ProfesorAdapter(context: Context, private val profesores: List<profesor>) :
    ArrayAdapter<profesor>(context, 0, profesores) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Reutiliza la vista si existe, de lo contrario, infla una nueva.
        // Usamos android.R.layout.simple_list_item_2 que tiene dos TextViews: text1 y text2.
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)

        // Obtiene el objeto 'profesor' para la posición actual
        val profesor = profesores[position]

        // Asigna el nombre del profesor al primer TextView (text1)
        view.findViewById<TextView>(android.R.id.text1).text = profesor.nombre
        // Asigna la materia del profesor al segundo TextView (text2)
        view.findViewById<TextView>(android.R.id.text2).text = profesor.materia

        // Si tu layout personalizado para cada elemento de la lista tuviera un ImageView,
        // aquí cargarías la imagen usando Picasso:
        // val imageView = view.findViewById<ImageView>(R.id.imageViewProfesor) // Asegúrate de tener este ID en tu layout
        // Picasso.get().load(profesor.imagen).into(imageView)

        return view
    }
}
