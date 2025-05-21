package com.example.trabajomoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso
import android.widget.ImageView
import android.widget.EditText // Importa la clase EditText
import android.widget.Toast // Importa la clase Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST // Importa la anotación POST

class MainActivity : AppCompatActivity() {

    // Declaración de las variables para los EditText y el botón
    private lateinit var editTextTextEmailAddress: EditText
    private lateinit var editTextTextPassword: EditText
    private lateinit var button: Button
    private lateinit var apiService: ApiService  // Declarar la variable para la interfaz de la API

    // Interfaz para definir los endpoints de la API (Retrofit)
    interface ApiService {
        // Esta función envía el usuario y la contraseña al servidor.
        // El servidor será el encargado de comparar estos datos con los de la base de datos.
        // Asegúrate de que "api/login" sea la ruta correcta en tu backend.
        @POST("api/login")
        @FormUrlEncoded
        fun login(
            @Field("usuario") usuario: String,
            @Field("contraseña") contraseña: String
        ): Call<LoginResponse>
    }

    // Clase de datos para representar la respuesta de la API
    data class LoginResponse(val success: Boolean, val message: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicialización de la ImageView para cargar la imagen con Picasso
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val imageUrl5 = "https://i.postimg.cc/k4K0xBn4/adobe-express-file.png"
        Picasso.get().load(imageUrl5).into(imageView5)

        // Inicialización de las variables para los EditText y el botón
        // Asegúrate de que estos IDs coincidan con los IDs en activity_main.xml
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress)
        editTextTextPassword = findViewById(R.id.editTextTextPassword)
        button = findViewById(R.id.button)

        // Configuración de Retrofit para la comunicación con la API
        // IMPORTANTE: Para conectar con XAMPP en tu máquina local desde un emulador,
        // usa "10.0.2.2" en lugar de "localhost".
        // El puerto "8081" debe ser el puerto en el que tu backend de IntelliJ está escuchando.
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8081/") // Base URL de tu backend
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(ApiService::class.java)  // Inicializa la interfaz de la API

        // Modificación del OnClickListener del botón para realizar la autenticación
        button.setOnClickListener {
            val email = editTextTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()

            // Validación de que los campos no estén vacíos
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Llama a la función de inicio de sesión de la interfaz de la API
                // Esto envía los datos ingresados por el usuario al servidor para su validación.
                val call = apiService.login(email, password)
                // Ejecuta la llamada de manera asíncrona
                call.enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        // Maneja la respuesta del servidor
                        // Aquí es donde se recibe el resultado de la comparación de la base de datos.
                        if (response.isSuccessful) {
                            val loginResponse = response.body() // Obtiene el cuerpo de la respuesta
                            // Si loginResponse.success es true, significa que el servidor confirmó las credenciales.
                            if (loginResponse?.success == true) {
                                // Si el inicio de sesión es exitoso, muestra un mensaje y navega a la siguiente actividad
                                Toast.makeText(this@MainActivity, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                                // Inicia MainActivity2
                                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                                startActivity(intent)
                                finish() // Cierra esta actividad para que el usuario no pueda volver atrás
                            } else {
                                // Si las credenciales son incorrectas (según la comparación del servidor), muestra un mensaje de error
                                Toast.makeText(this@MainActivity, "Credenciales incorrectas: ${loginResponse?.message}", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            // Si hay un error en la respuesta del servidor (ej. 404, 500), muestra un mensaje de error
                            Toast.makeText(this@MainActivity, "Error en la autenticación: ${response.code()} - ${response.message()}", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        // Si hay un error de red, muestra un mensaje de error
                        Toast.makeText(this@MainActivity, "Error de red: ${t.message}", Toast.LENGTH_LONG).show()
                        t.printStackTrace() // Imprime la traza de la pila para depuración
                    }
                })
            } else {
                // Si los campos están vacíos, muestra un mensaje pidiendo al usuario que los llene
                Toast.makeText(this@MainActivity, "Por favor, ingresa correo y contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
