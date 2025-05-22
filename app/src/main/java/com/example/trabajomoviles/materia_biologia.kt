package com.example.trabajomoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class materia_biologia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.materia_biologia)


        val imageView18 = findViewById<ImageView>(R.id.imageView20)
        val imageUrl8 = "https://i.postimg.cc/wjCq6jPj/image-15.png"
        Picasso.get().load(imageUrl8).into(imageView18)

    }
}