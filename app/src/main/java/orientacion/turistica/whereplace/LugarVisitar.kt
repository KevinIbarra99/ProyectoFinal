package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LugarVisitar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugar_visitar)

        val btn_perfil_usuario: Button = findViewById(R.id.perfil)
        val btnRegreso: Button = findViewById(R.id.regreso)

        var nombre = intent.getStringExtra("nombre")
        var correo = intent.getStringExtra("correo")

        btn_perfil_usuario.setOnClickListener{
            val intent: Intent = Intent(this, Perfil_Usuario::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("correo", correo)
            startActivity(intent)
        }

        btnRegreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("correo", correo)
            startActivity(intent)
        }
    }
}