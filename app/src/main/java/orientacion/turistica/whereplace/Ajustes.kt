package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ajustes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes)

        val btn_perfil_usuario: Button = findViewById(R.id.perfil)

        btn_perfil_usuario.setOnClickListener{
            val intent: Intent = Intent(this, Perfil_Usuario::class.java)
            startActivity(intent)
        }
    }
}