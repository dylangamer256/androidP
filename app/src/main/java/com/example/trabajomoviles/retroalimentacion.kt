package com.example.trabajomoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.ImageView
import com.squareup.picasso.Picasso

class retroalimentacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.retroalimentacion)

        val btnEspañol: Button = findViewById(R.id.button12)
        btnEspañol.setOnClickListener {
            val intent = Intent(this, materia_espanol::class.java)
            startActivity(intent)
        }

        val btnBiologia: Button = findViewById(R.id.button8)
        btnBiologia.setOnClickListener {
            val intent = Intent(this, materia_biologia::class.java)
            startActivity(intent)
        }

        val btnSociales: Button = findViewById(R.id.button9)
        btnSociales.setOnClickListener {
            val intent = Intent(this, materia_sociales::class.java)
            startActivity(intent)
        }



        val btnVolver: Button = findViewById(R.id.button10)
        btnVolver.setOnClickListener {
            finish()
        }


        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageUrl3 = "https://i.postimg.cc/x1CJk8tG/image-14.png"
        Picasso.get().load(imageUrl3).into(imageView3)


        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val imageUrl4 = "https://i.postimg.cc/wjCq6jPj/image-15.png"
        Picasso.get().load(imageUrl4).into(imageView4)

        val imageView7 = findViewById<ImageView>(R.id.imageView7)
        val imageUrl7 = "https://i.postimg.cc/tC1GYHFZ/image-16.png"
        Picasso.get().load(imageUrl7).into(imageView7)

        val imageView16 = findViewById<ImageView>(R.id.imageView16)
        val imageUrl16 = "https://i.postimg.cc/jS4Tr4zZ/image-7.png"
        Picasso.get().load(imageUrl16).into(imageView16)


    }
}