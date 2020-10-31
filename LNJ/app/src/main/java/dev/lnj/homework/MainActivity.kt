package dev.lnj.homework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.time.temporal.TemporalAdjusters.next
/*==================================================================================================
    https://coding-factory.tistory.com/203 : intent 기능 설명 및 예제
==================================================================================================*/
class MainActivity : AppCompatActivity() {
    var button : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn_two)
        button?.setOnClickListener {
            //Toast.makeText(this,"화면 전환", Toast.LENGTH_SHORT).show()
            AlertDialog.Builder(this).setTitle("2" + getString(R.string.homework_title)).setMessage(getString(R.string.two_naeyong)).setPositiveButton("확인하기"){_,_-> next()}.create().show()
        }

    }

    private fun next() {
        // 송신할 인텐트 설정
        var intent= Intent(this,MainActivity2::class.java)

        /*송신할 자료 생성 */
        //val text = findViewById<EditText>(R.id.tv_name).text.toString()
        val text = "2주차 숙제 완료!"

        //송신
        intent.putExtra("name",text.toString())

        //송신한 값 표출
        startActivity(intent)
    }


    // 어플이 다시 열렸을 때 반응하는 함수
    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"반가워",Toast.LENGTH_SHORT).show()
    }



}
