package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Perfil_Usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_usuario)

        val btn_regreso: ImageView = findViewById(R.id.regreso)

        var nombre = intent.getStringExtra("nombre")
        var correo = intent.getStringExtra("correo")


        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("correo", correo)
            startActivity(intent)
        }


    }
}