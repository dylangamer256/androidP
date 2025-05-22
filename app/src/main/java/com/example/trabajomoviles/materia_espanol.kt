package com.example.trabajomoviles
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class materia_espanol : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.materia_espanol)


        val imageView12 = findViewById<ImageView>(R.id.imageView12)
        val imageUrl2 = "https://i.postimg.cc/x1CJk8tG/image-14.png"
        Picasso.get().load(imageUrl2).into(imageView12)

    }
}