package com.example.trabajomoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val imageView6 = findViewById<ImageView>(R.id.imageView6)
        Picasso.get().load(R.drawable.captura_de_pantalla_2025_03_13_153928).into(imageView6)

        val imageView8 = findViewById<ImageView>(R.id.imageView8)
        Picasso.get().load(R.drawable.image_7).into(imageView8)

        val imageView9 = findViewById<ImageView>(R.id.imageView9)
        Picasso.get().load(R.drawable.adobe_express___file_1).into(imageView9)

        val imageView10 = findViewById<ImageView>(R.id.imageView10)
        Picasso.get().load(R.drawable.image_6).into(imageView10)

        val imageView11 = findViewById<ImageView>(R.id.imageView11)
        Picasso.get().load(R.drawable.image_10).into(imageView11)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, apiej::class.java)
            startActivity(intent)
        }
    }
}
