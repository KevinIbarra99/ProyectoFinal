package orientacion.turistica.whereplace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button

class Touch_Place : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_place)



         val btn : Button = findViewById(R.id.btngohome)
        btn.setOnClickListener{
          val intent: Intent= Intent(this,Pantalla_Principal:: class.java )
        startActivity(intent)
        }


        val btn2 : Button = findViewById(R.id.btntouchplace)
        btn.setOnClickListener{
            val intent: Intent= Intent(this,Pantalla_Cargando:: class.java )
            startActivity(intent)
        }
    }
}