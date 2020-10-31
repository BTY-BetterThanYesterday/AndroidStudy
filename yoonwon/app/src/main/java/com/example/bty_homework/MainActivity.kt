package com.example.bty_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.time.temporal.TemporalAdjusters.next

class MainActivity : AppCompatActivity() {
    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn_next1)
        button?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("2주차 숙제")
                .setMessage("2주차 숙제는 화면전환 예제를 구현하는 내용입니다.")
                .setPositiveButton("확인") { _, _ -> next() }
                .create()
                .show()
        }


    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "반가워,", Toast.LENGTH_SHORT).show()
    }

    private fun next() {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", "2주차 숙제 완료!")
            startActivity(intent)

    }
}
