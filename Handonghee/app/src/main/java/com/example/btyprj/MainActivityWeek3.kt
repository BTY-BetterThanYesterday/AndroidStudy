package com.example.btyprj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivityWeek3 : AppCompatActivity() {

    private val buttonClose: Button by lazy{ findViewById<Button>(R.id.btn_close)}
    private val buttonLogin: Button by lazy{ findViewById<Button>(R.id.btn_login)}

    //추후 데이터 베이스에서 읽어올 예정
    private val setUser = mapOf<String,String>("admin" to "1", "handonghee" to "1")

    private val edittextInputid: EditText by lazy{ findViewById<EditText>(R.id.edt_id)}
    private val edittextInputpw: EditText by lazy{ findViewById<EditText>(R.id.edt_password)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_week3)


        buttonLogin.setOnClickListener{
             AlertDialog.Builder(this).setTitle("로그인 하시겠습니까?").setMessage("아이디와 비밀번호가 정확한가요?").setPositiveButton("확인") { _, _ ->
                 OnLogin()
            }.create().show()
             }
    }

    private fun OnLogin() {

        val inputId = edittextInputid.text.toString()
        val inputPw = edittextInputpw.text.toString()

        if(setUser.containsKey(inputId) and (setUser.getValue(inputId).compareTo(inputPw) == 0))
        {
            //추후 일치하는 유저 객체를 다음화면에 넘길 예정
            var intent = Intent(this, MainActivitySearchWeek3::class.java)
            startActivity(intent)
            return
        }

        AlertDialog.Builder(this).setTitle("로그인 실패").setMessage("아이디와 비밀번호를 확인해주세요.").setPositiveButton("확인"){ _, _ ->}.create().show()
    }
}
