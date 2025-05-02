package com.example.trabajomoviles

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import com.squareup.picasso.Picasso
import android.widget.ImageView

class apiej : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.apiej)
        val imageView = findViewById<ImageView>(R.id.imageView17)
        val imagenUrl = "https://fastly.picsum.photos/id/1071/200/300.jpg?hmac=y09-AL4WisOkuQR4SOKzDWjPHWptbCDbEaFP0yJkKNY"
        Picasso.get().load(imagenUrl).into(imageView)

        val listView = findViewById<ListView>(R.id.listView) // <-- ID corregido

        val estudianteId = 1

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

                val adapter = ProfesorAdapter(this, listaProfesores)
                listView.adapter = adapter
            },
            onError = { errorMsg ->
                Toast.makeText(this, "Error: $errorMsg", Toast.LENGTH_LONG).show()
            }
        )
    }
}
