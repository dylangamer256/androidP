package com.example.trabajomoviles


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class tareas: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.tareas)


        val imageView31 = findViewById<ImageView>(R.id.imageView31)
        val imageUrl31 = "https://i.postimg.cc/tC1GYHFZ/image-16.png"
        Picasso.get().load(imageUrl31).into(imageView31)
        val imageView41 = findViewById<ImageView>(R.id.imageView41)
        val imageUrl41 = "https://i.postimg.cc/tC1GYHFZ/image-16.png"
        Picasso.get().load(imageUrl41).into(imageView41)
        val imageView51 = findViewById<ImageView>(R.id.imageView51)
        val imageUrl51 = "https://i.postimg.cc/tC1GYHFZ/image-16.png"
        Picasso.get().load(imageUrl51).into(imageView51)

    }
}