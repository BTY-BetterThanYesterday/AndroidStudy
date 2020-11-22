package study.bty.androidstudy.cat

import retrofit2.Call
import retrofit2.http.GET

interface CatApi {
    @GET("v1/images/search")
    fun getRandomCat() : Call<List<Cat>>
}