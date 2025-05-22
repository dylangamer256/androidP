package com.example.trabajomoviles
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApiService {
    @POST("api/login")
    @FormUrlEncoded
    fun login(
        @Field("usuario") usuario: String,
        @Field("contraseña") contraseña: String
    ): Call<LoginResponse>
}