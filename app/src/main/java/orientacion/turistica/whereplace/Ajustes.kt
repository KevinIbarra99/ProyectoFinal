package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class Ajustes : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes)

        //FB
        storage = FirebaseFirestore.getInstance()

        //Botones
        val btn_perfil_usuario: Button = findViewById(R.id.perfil)
        val btn_regreso: Button = findViewById(R.id.regreso)
        val btnConfirmar: Button = findViewById(R.id.confirmar)

        //EditTexts
        val etCorreo: EditText = findViewById(R.id.correo)
        val etContra: EditText = findViewById(R.id.contrasena)
        val etTelef: EditText = findViewById(R.id.telefono)

        //Extras
        var nombre = intent.getStringExtra("nombre")
        var correo = intent.getStringExtra("correo")



        storage.collection("usuarios").whereEqualTo("correo",correo)
            .get()
            .addOnSuccessListener {
                if (it.documents.isNotEmpty()){
                    etCorreo.setText(it.documents.get(0).data?.get("correo").toString())
                    nombre = it.documents.get(0).data?.get("nombre").toString()
                }
            }.addOnFailureListener {
                Toast.makeText(this, "Fallo al obtener datos", Toast.LENGTH_SHORT).show()
            }


        btn_perfil_usuario.setOnClickListener{
            val intent: Intent = Intent(this, Perfil_Usuario::class.java)
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
        btnConfirmar.setOnClickListener{
            storage.collection("usuarios").document(etCorreo.text.toString()).set(
                hashMapOf(
                    "nombre" to nombre,
                    "contrasena" to etContra.text.toString(),
                    "correo" to etCorreo.text.toString(),
                    "telefono" to etTelef.text.toString())
            ).addOnSuccessListener {
                Toast.makeText(baseContext, "Datos actualizados", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(baseContext, "ERROR", Toast.LENGTH_SHORT).show()
            }

            val intent: Intent = Intent(this, Pantalla_Principal::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("correo", correo)
            startActivity(intent)
        }
    }
}