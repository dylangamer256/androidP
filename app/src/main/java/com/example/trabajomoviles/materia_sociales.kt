package com.example.trabajomoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class materia_sociales : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.materia_sociales)


        val imageView19 = findViewById<ImageView>(R.id.imageView19)
        val imageUrl19 = "https://i.postimg.cc/tC1GYHFZ/image-16.png"
        Picasso.get().load(imageUrl19).into(imageView19)

    }
}