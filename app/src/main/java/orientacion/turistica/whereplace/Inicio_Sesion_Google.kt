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
import com.google.android.gms.common.SignInButton
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
        var sign_in_button: SignInButton = findViewById(R.id.sign_in_button)

        btn_regreso.setOnClickListener {
            val intent: Intent = Intent(this, Pantalla_Inicio::class.java)
            startActivity(intent)
        }
        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        sign_in_button.setSize(SignInButton.SIZE_WIDE)

        sign_in_button.setOnClickListener{
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)

        }
    }

    override fun onStart() {
        super.onStart()

        val account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
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

    private fun signOut() {
        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this, OnCompleteListener<Void?> {
                Toast.makeText(this,"Sesión terminada", Toast.LENGTH_SHORT).show()
            })
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account =
                completedTask.getResult(ApiException::class.java)

            updateUI(account)
        } catch (e: ApiException) {
            Log.w("test_signin", "signInResult:failed code=" + e.statusCode)
            updateUI(null)
        }
    }

    private fun updateUI(acct: GoogleSignInAccount?) {

        if (acct != null){
            val intent = Intent(this, Pantalla_Principal::class.java)
            intent.putExtra("name", acct.getDisplayName())
            intent.putExtra("email", acct.getEmail())
            startActivityForResult(intent, LOG_OUT)
        }


    }
}