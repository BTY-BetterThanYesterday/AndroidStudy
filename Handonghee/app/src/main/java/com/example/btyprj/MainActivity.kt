package com.example.btyprj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.time.temporal.TemporalAdjusters.next

class MainActivity : AppCompatActivity() {

    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.btn_2WeekWork)
        button?.setOnClickListener{
            AlertDialog.Builder(this).setTitle("2주차 숙제").setMessage("2주차 숙제는 화면전환 예제를 구현하는 것입니다.").setPositiveButton("확인") {_,_ ->
                next()
            }.create().show()
        }

    }

    private fun next() {
        var intent = Intent(this, MainActivityWeek2::class.java)
        //intent.putExtra("name", edt_input.text.toString())
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Resume Test", Toast.LENGTH_SHORT).show()
    }
}