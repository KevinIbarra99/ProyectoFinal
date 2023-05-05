package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        val btnvolverbucket : Button = findViewById(R.id.btngobucket)
        btnvolverbucket.setOnClickListener{
            val  intent= Intent(this,Bucket_Trip :: class.java )
            startActivity(intent)
        }
    }
}