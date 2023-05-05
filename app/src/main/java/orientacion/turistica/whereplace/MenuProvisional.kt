package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MenuProvisional : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_provisional)

        val btn_regreso: ImageView = findViewById(R.id.regreso)
        val btn_perfil_usuario: Button = findViewById(R.id.perfil)
        val btn_favoritos: Button = findViewById(R.id.favoritos)
        val btn_ajustes_configuracion: Button = findViewById(R.id.config)
        val btn_notificiones: Button = findViewById(R.id.notificacion)

        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            startActivity(intent)
        }
        btn_perfil_usuario.setOnClickListener{
            val intent: Intent = Intent(this, Perfil_Usuario::class.java)
            startActivity(intent)
        }
        btn_favoritos.setOnClickListener{
            val intent: Intent = Intent(this, Favoritos::class.java)
            startActivity(intent)
        }
        btn_ajustes_configuracion.setOnClickListener{
            val intent: Intent = Intent(this, Ajustes::class.java)
            startActivity(intent)
        }
        btn_notificiones.setOnClickListener{
            val intent: Intent = Intent(this, Notificaciones::class.java)
            startActivity(intent)
        }
    }
}