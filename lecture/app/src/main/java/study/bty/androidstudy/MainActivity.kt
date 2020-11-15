package study.bty.androidstudy

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //    lateinit var button: Button
    val button: Button by lazy {
        Log.e("BTY", "by lazy")
        findViewById<Button>(R.id.btn_next)
    }
//    var button: Button? = findViewById(R.id.btn_next)

    init {
        Log.e("BTY", "init")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("BTY", "onCreate0")
//        button = findViewById(R.id.btn_next)

        Log.e("BTY", "onCreate1")
        button.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("스터디")
                .setMessage("이름을 입력하면 다음페이지에 이릅이 출력됩니다.")
                .setPositiveButton("확인") { _, _ -> next() }
                .create()
                .show()
        }
        Log.e("BTY", "onCreate2")
        button.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("스터디")
                .setMessage("이름을 입력하면 다음페이지에 이릅이 출력됩니다.")
                .setPositiveButton("확인") { _, _ -> next() }
                .create()
                .show()
        }
    }


    private fun next() {
        // val text = findViewById<EditText>(R.id.edt_input).text.toString() // 남주는 이거

//        val intent = Intent(this, MainActivity2::class.java)
//        intent.putExtra("name", edt_input.text.toString())
//        startActivity(intent)
        startActivity(
            Intent(this, MainActivity2::class.java).apply {
                putExtra("name", edt_input.text.toString())
            }
        )
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "반가워", Toast.LENGTH_SHORT).show()
    }
}