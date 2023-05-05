package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
class Pantalla_Cargando : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_cargando)

        startTimer()
    }
        fun startTimer(){
            object: CountDownTimer(3000, 1000){
               override fun onTick(p0: Long) {

                }

               override fun onFinish() {
                    val intent = Intent(applicationContext, Pantalla_Huellas::class.java).apply{}
                  startActivity(intent)
                }
            }.start()

    }
}