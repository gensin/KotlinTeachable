package es.pau.kotlinteachable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("hello")
    }

    // Two ways of create functions. One as a typical method
    private fun toast(message: String) { // functions on kotlin always return somethign, 'Unit' by default
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    // Other way as an expression with the body of the method after '='
    fun getIntx2(int: Int) = 2 * int // Returned type (Int) is implicit on the body of the function
}
