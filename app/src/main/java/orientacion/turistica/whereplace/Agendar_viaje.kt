package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class Agendar_viaje : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar_viaje)

        //Firebase
        storage = FirebaseFirestore.getInstance()

        //Botones
        val btn_regreso: ImageView = findViewById(R.id.regreso)
        val btn_guardar_viaje: Button = findViewById(R.id.guardar)
        val btn_ver_proximos_viajes: Button = findViewById(R.id.recordar)

        // Calendario
        val calendar: CalendarView = findViewById(R.id.calendarView)

        //Edit Text
        val viaje: EditText = findViewById(R.id.multiAutoCompleteTextView)

        //Extras
        var nombre = intent.getStringExtra("nombre")
        var correo = intent.getStringExtra("correo")

        fun initCalendarView() {
            calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
                calendar.date = Calendar.getInstance()
                    .apply { set(year, month, dayOfMonth) }
                    .timeInMillis
            }
        }

        btn_guardar_viaje.setOnClickListener {

            initCalendarView()
            storage.collection("viajes").document("${correo}").set(
                hashMapOf(
                    "lugar" to viaje.text.toString(),
                    "fecha" to convertLongToTime(calendar.date)
                )
            ).addOnSuccessListener {
                Toast.makeText(baseContext, "Viaje guardado", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(baseContext, "ERROR", Toast.LENGTH_SHORT).show()
            }

            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("correo", correo)
            startActivity(intent)
        }

        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("correo", correo)
            startActivity(intent)
        }
        btn_ver_proximos_viajes.setOnClickListener{
            val intent: Intent = Intent(this, Futuros_viajes::class.java)
            startActivity(intent)
        }
    }

    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy/MM/dd")
        return format.format(date)
    }

}