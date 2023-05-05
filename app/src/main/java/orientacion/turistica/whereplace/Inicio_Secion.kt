package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class   Inicio_Secion : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_secion)

        auth = Firebase.auth

        val btn_iniciar: Button = findViewById(R.id.iniciar_sesion_2)
        val btn_regreso: ImageView = findViewById(R.id.regreso)
        val btn_olvido: TextView = findViewById(R.id.olvido)

        btn_iniciar.setOnClickListener{
            valida_ingreso()
        }
        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Inicio::class.java)
            startActivity(intent)
        }
        btn_olvido.setOnClickListener{
            val intent: Intent = Intent(this, Contrasena::class.java)
            startActivity(intent)
        }
    }
    private fun valida_ingreso(){
        val text_usuario: EditText = findViewById(R.id.usuario)
        val text_contra: EditText = findViewById(R.id.contra)

        var correo: String = text_usuario.text.toString()
        var contra: String = text_contra.text.toString()

        if(!correo.isNullOrBlank() && !contra.isNullOrBlank()){
            ingresaFirebase(correo, contra)
        }else{
            Toast.makeText(this, "Ingresar Datos",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun ingresaFirebase(email: String, password:String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    val intent: Intent = Intent(this, Pantalla_Principal::class.java)
                    startActivity(intent)

                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Fallo la autenticacion este correo no esta registrado.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }
}