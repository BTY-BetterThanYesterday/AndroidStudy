package study.bty.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import study.bty.androidstudy.cat.ApiClient
import study.bty.androidstudy.cat.Cat

class CatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat)

        btn_cat.setOnClickListener {
            downloadCat()
        }
    }

    private fun downloadCat() {
        val callback: (String?) -> Unit = { url ->
            loadCatImage(url)
        }

        ApiClient.api.getRandomCat().enqueue(
            object : Callback<List<Cat>>{
                override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                }

                override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                    callback(
                        response.body()?.get(0)?.url
                    )
                }

            }
        )
    }

    fun loadCatImage(url: String?) {
        Glide.with(this)
            .asBitmap()
            .load(url)
            .centerCrop()
            .into(image_cat)
    }
}