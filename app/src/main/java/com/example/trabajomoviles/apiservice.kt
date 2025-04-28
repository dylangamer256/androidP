package com.example.trabajomoviles

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

object ApiService {
    fun obtenerProfesores(context: Context, estudianteId: Int, onSuccess: (JSONArray) -> Unit, onError: (String) -> Unit) {
        val url = "http://10.0.2.2:8081/api/profesores/estudiante/$estudianteId"

        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response -> onSuccess(response) },
            { error -> onError(error.message ?: "Error desconocido") }
        )

        Volley.newRequestQueue(context).add(request)
    }
}
