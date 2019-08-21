package github.vege19.mybaseproject.api

import github.vege19.mybaseproject.models.DefaultModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("pokemon")
    fun getPokemons(): Call<DefaultModel>

}