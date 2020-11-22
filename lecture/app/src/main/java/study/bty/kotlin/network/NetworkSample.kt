package study.bty.kotlin.network

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

fun main() {
    val client = OkHttpClient()


    val request = Request.Builder()
        .url("https://api.thecatapi.com/v1/images/search")
        .build()

    try {
        val response = client.newCall(request).execute()
        println(
//            response.body?.string() ?: "통신 실패"
        )
    } catch (e: IOException) {
        e.printStackTrace()
    }
}