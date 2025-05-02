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

        val imageView8 = findViewById<ImageView>(R.id.imageView8)
        val imageUrl8 = "https://i.postimg.cc/k4K0xBn4/adobe-express-file.png"
        Picasso.get().load(imageUrl8).into(imageView8)

        val imageView9 = findViewById<ImageView>(R.id.imageView9)
        val imageUrl9 = "https://i.postimg.cc/0rRrV6SB/adobe-express-file-1.png"
        Picasso.get().load(imageUrl9).into(imageView9)

        val imageView10 = findViewById<ImageView>(R.id.imageView10)
        val imageUrl10 = "https://i.postimg.cc/J04WMRLz/image-6.png"
        Picasso.get().load(imageUrl10).into(imageView10)


        val imageView11 = findViewById<ImageView>(R.id.imageView11)
        val imageUrl11 = "https://i.postimg.cc/50sR5vhf/image-10.png"
        Picasso.get().load(imageUrl11).into(imageView11)

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