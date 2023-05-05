package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Fin_Dinamica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fin_dinamica)

        val btn : Button = findViewById(R.id.btnintentar)
        btn.setOnClickListener{
            val  intent= Intent(this,Pantalla_Huellas :: class.java )
            startActivity(intent)
        }

         val btnvolverinicio : Button= findViewById(R.id.btnvolverinicio)
        btnvolverinicio.setOnClickListener{
         val  intent= Intent(this,Pantalla_Principal :: class.java )
         startActivity(intent)
        }
    }
}