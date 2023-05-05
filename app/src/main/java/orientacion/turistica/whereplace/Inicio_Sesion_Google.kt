package orientacion.turistica.whereplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task

const val RC_SIGN_IN = 343
const val LOG_OUT = 234
@Suppress("DEPRECATION")
class Inicio_Sesion_Google : AppCompatActivity() {

    lateinit var mGoogleSignInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion_google)

        val btn_regreso: ImageView = findViewById(R.id.regreso)
        val text_usuario: EditText = findViewById(R.id.usuario)
        val btn_signin: Button = findViewById(R.id.siguiente)

        btn_regreso.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla_Inicio::class.java)
            startActivity(intent)
        }
        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        fun updateUI(account: GoogleSignInAccount?) {
            if (account != null){
                val intent = Intent(this, Pantalla_Principal::class.java)

                intent.putExtra("name", account.getDisplayName())
                startActivityForResult(intent, LOG_OUT)
            }
        }

        fun onStart() {
            super.onStart()

            val account = GoogleSignIn.getLastSignedInAccount(this)
            updateUI(account)

        }

        fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
            try {
                val account =
                    completedTask.getResult(ApiException::class.java)

                updateUI(account)
            } catch (e: ApiException) {
                Log.w("test_signin", "signInResult:failed code=" + e.statusCode)
                updateUI(null)
            }
        }


        fun signOut() {
            mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, OnCompleteListener<Void?> {
                    Toast.makeText(this,"Sesión terminada", Toast.LENGTH_SHORT).show()
                })
        }


        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == RC_SIGN_IN){
                val task =
                    GoogleSignIn.getSignedInAccountFromIntent(data)
                handleSignInResult(task)

            }

            if(requestCode == LOG_OUT){
                signOut()
            }
        }






    }
}