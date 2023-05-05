package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Bucket_Trip : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bucket_trip)


        val btnvolverinicio : Button = findViewById(R.id.btngohome)
        btnvolverinicio.setOnClickListener{
            val  intent= Intent(this,Pantalla_Principal :: class.java )
            startActivity(intent)
        }

        val btnlist : Button = findViewById(R.id.btncabos)
        btnlist.setOnClickListener{
            val  intent= Intent(this,List :: class.java )
            startActivity(intent)
        }
    }
}