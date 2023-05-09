package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class Pantalla_Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)

        val btn_donde_viajes: Button = findViewById(R.id.viaje)
        val btn_agendar_viajes: Button = findViewById(R.id.agenda)
        val btn_touch: Button = findViewById(R.id.touch)
        val btn_opciones: ImageView = findViewById(R.id.opciones)

        val bienvenida : TextView = findViewById(R.id.bienvenida)

        var nombre = intent.getStringExtra("nombre")
        var correo = intent.getStringExtra("correo")

        bienvenida.text="¡Hola ${nombre}! un gusto tenerte aquí."

        btn_donde_viajes.setOnClickListener{
            val intent: Intent = Intent(this, LugarVisitar::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("correo", correo)
            startActivity(intent)
        }
        btn_agendar_viajes.setOnClickListener{
            val intent: Intent = Intent(this, Agendar_viaje::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("correo", correo)
            startActivity(intent)
        }
        btn_touch.setOnClickListener{
            val intent: Intent = Intent(this, Touch_Place::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("correo", correo)
            startActivity(intent)
        }
        btn_opciones.setOnClickListener{
            val intent: Intent = Intent(this, MenuProvisional::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("correo", correo)
            startActivity(intent)
        }
        val bundle = intent.extras
        if (bundle != null){
            val name = bundle.getString("name")
            bienvenida.setText(name)

        }
    }
}