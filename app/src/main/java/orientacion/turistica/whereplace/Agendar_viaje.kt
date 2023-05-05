package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Agendar_viaje : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar_viaje)



        val btn_regreso: ImageView = findViewById(R.id.regreso)
        val btn_guardar_viaje: Button = findViewById(R.id.verviajes)
        val btn_ver_proximos_viajes: Button = findViewById(R.id.recordar)

        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            startActivity(intent)
        }
        btn_ver_proximos_viajes.setOnClickListener{
            val intent: Intent = Intent(this, Futuros_viajes::class.java)
            startActivity(intent)
        }
    }
}