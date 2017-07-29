package es.pau.kotlinteachable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val message: EditText = findViewById(R.id.message) as EditText
        val button: Button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            if (message.text.toString().isEmpty()){
                toast("Escribe algo!")
            } else {
                toast("Hello ${message.text}")
            }
        }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
