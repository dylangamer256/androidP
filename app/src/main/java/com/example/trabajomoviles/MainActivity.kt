package com.example.trabajomoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var usuarioEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var forgotPasswordTextView: TextView

    private lateinit var loginApiService: LoginApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Asegúrate de tener un EditText con id usuarioEditText en tu layout
        usuarioEditText = findViewById(R.id.editTextTextEmailAddress)
        passwordEditText = findViewById(R.id.editTextTextPassword)
        loginButton = findViewById(R.id.button)
        forgotPasswordTextView = findViewById(R.id.textView)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        loginApiService = retrofit.create(LoginApiService::class.java)

        loginButton.setOnClickListener {
            val usuario = usuarioEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (usuario.isNotEmpty() && password.isNotEmpty()) {
                val call = loginApiService.login(usuario, password)
                call.enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful) {
                            val loginResponse = response.body()
                            if (loginResponse != null && loginResponse.success) {
                                Toast.makeText(this@MainActivity, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this@MainActivity, MainActivity2::class.java))
                                finish()
                            } else {
                                Toast.makeText(this@MainActivity, loginResponse?.message ?: "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(this@MainActivity, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Error de red: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        forgotPasswordTextView.setOnClickListener {
            Toast.makeText(this, "Funcionalidad de recuperar contraseña no implementada", Toast.LENGTH_SHORT).show()
        }

    }
}
