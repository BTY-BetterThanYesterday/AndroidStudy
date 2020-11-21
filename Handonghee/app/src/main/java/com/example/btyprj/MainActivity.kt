package com.example.btyprj


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    //lateinit var button: Button
    private val button: Button by lazy{ findViewById<Button>(R.id.btn_2WeekWork)}
    private val buttonweek3: Button by lazy{ findViewById<Button>(R.id.btn_3WeekWork)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            AlertDialog.Builder(this).setTitle("2주차 숙제").setMessage("2주차 숙제는 화면전환 예제를 구현하는 것입니다.").setPositiveButton("확인") {_,_ ->
                next()
            }.create().show()
        }

        buttonweek3.setOnClickListener{
            AlertDialog.Builder(this).setTitle("2주차 숙제").setMessage("3주차 숙제는 로그인 화면 예제를 구현하는 것입니다.").setPositiveButton("확인") {_,_ ->
                OpenWeek3()
            }.create().show()
        }
    }

    private fun next() {
        var intent = Intent(this, MainActivityWeek2::class.java)
        //intent.putExtra("name", edt_input.text.toString())
        startActivity(intent)
    }

    private fun OpenWeek3() {
        var intent = Intent(this, MainActivityWeek3::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Resume Test", Toast.LENGTH_SHORT).show()

    }
}
