package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Futuros_viajes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_futuros_viajes)

        val btn_regreso: ImageView = findViewById(R.id.regreso)
        val btn_agendar_viaje: Button = findViewById(R.id.agendar)
        val btn_inicio: Button = findViewById(R.id.inicio)

        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            startActivity(intent)
        }
        btn_agendar_viaje.setOnClickListener{
            val intent: Intent = Intent(this, Agendar_viaje::class.java)
            startActivity(intent)
        }
        btn_inicio.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            startActivity(intent)
        }
    }
}