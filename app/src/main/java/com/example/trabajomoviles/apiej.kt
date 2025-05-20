package com.example.trabajomoviles

import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class apiej : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.apiej)

        val listView = findViewById<ListView>(R.id.listView)
        val estudianteId = 2

        ApiService.obtenerProfesores(
            context = this,
            estudianteId = estudianteId,
            onSuccess = { response ->
                val listaProfesores = mutableListOf<profesor>()
                for (i in 0 until response.length()) {
                    val obj = response.getJSONObject(i)
                    val nombre = obj.getString("nombre")
                    val materia = obj.getString("materia")
                    val imagen = obj.getString("imagen")
                    listaProfesores.add(profesor(nombre, materia, imagen))
                }


                if (listaProfesores.isNotEmpty()) {
                    val imageView = findViewById<ImageView>(R.id.imageView17)
                    Picasso.get().load(listaProfesores[0].imagen).into(imageView)
                }


                val adapter = ProfesorAdapter(this, listaProfesores)
                listView.adapter = adapter
            },
            onError = { errorMsg ->
                Toast.makeText(this, "Error: $errorMsg", Toast.LENGTH_LONG).show()
            }
        )
    }
}
