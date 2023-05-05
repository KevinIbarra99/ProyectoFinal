package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Pantalla_Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_inicio)

        val btn_registro: Button = findViewById(R.id.crear_cuenta)
        val btn_inicio: Button = findViewById(R.id.iniciar_sesion)
        val btn_inicio_google: ImageView = findViewById(R.id.inicio_google)

        btn_registro.setOnClickListener{
            val intent: Intent = Intent(this, Registro_Usuario::class.java)
            startActivity(intent)
        }
        btn_inicio.setOnClickListener{
            val intent: Intent = Intent(this, Inicio_Secion::class.java)
            startActivity(intent)
        }
        btn_inicio_google.setOnClickListener{
            val intent: Intent = Intent(this, Inicio_Sesion_Google::class.java)
            startActivity(intent)
        }

    }
}