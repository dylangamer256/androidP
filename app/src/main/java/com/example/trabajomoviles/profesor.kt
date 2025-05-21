package com.example.trabajomoviles

// Clase de datos para representar la información de un profesor
// Asegúrate de que los nombres de las propiedades (nombre, materia, imagen, usuario, contraseña)
// coincidan exactamente con las claves JSON que tu backend devuelve para un profesor.
data class profesor(
    val nombre: String,
    val materia: String,
    val imagen: String, // URL de la imagen del profesor

)
