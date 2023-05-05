package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registro_Usuario : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)

        auth = Firebase.auth

        val btn_crear: Button = findViewById(R.id.crear)
        val btn_regreso: ImageView = findViewById(R.id.regreso)

        btn_crear.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Inicio::class.java)
            validar_registro()
            startActivity(intent)
        }
        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Inicio::class.java)
            startActivity(intent)
        }
    }
    private fun validar_registro(){
        val et_nombre: EditText = findViewById(R.id.nombre_usuario)
        val et_correo: EditText = findViewById(R.id.correo_usuario)
        val et_contra1: EditText = findViewById(R.id.contra_usuario)
        val et_contra2: EditText = findViewById(R.id.confir_contra)

        var nombre: String = et_nombre.text.toString()
        var correo: String = et_correo.text.toString()
        var contra1: String = et_contra1.text.toString()
        var contra2: String = et_contra2.text.toString()

        if(!nombre.isNullOrBlank() && !correo.isNullOrBlank() && !contra1.isNullOrBlank() &&
            !contra2.isNullOrBlank()){
            if (contra1 == contra2){
                registrarFirebase(correo, contra1)
            }else{
                Toast.makeText(this, "las contraseñas no coinciden",
                    Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Ingresar Datos",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun registrarFirebase(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    if (user != null) {
                        Toast.makeText(baseContext, "${user.email}Se ha creado correctamente.",
                            Toast.LENGTH_SHORT).show()
                    }
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }
}