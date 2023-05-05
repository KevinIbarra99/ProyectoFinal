package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Pantalla_Huellas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_huellas)

        val btn : Button= findViewById(R.id.btnfin1)
        btn.setOnClickListener{
            val  intent= Intent(this,Fin_Dinamica :: class.java )
            startActivity(intent)
        }

        val btn2 : Button= findViewById(R.id.btnfin2)
        btn.setOnClickListener{
            val  intent= Intent(this,Fin_Dinamica :: class.java )
            startActivity(intent)
        }


        }


    }
