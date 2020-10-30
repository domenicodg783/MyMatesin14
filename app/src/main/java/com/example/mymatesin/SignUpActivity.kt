package com.example.mymatesin

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        val conferma_sign_up = findViewById<Button>(R.id.conferma_sign_up)
        conferma_sign_up.setOnClickListener {
            signUpUser()
        }
    }

    private fun signUpUser() {
        val nome = findViewById<EditText>(R.id.input_nome)
        val cognome = findViewById<EditText>(R.id.input_cognome)
        val email = findViewById<EditText>(R.id.input_email)
        val numero = findViewById<EditText>(R.id.input_cellulare)
        var password = findViewById<EditText>(R.id.input_password)

        if (numero.text.toString().isEmpty()) {
            numero.error = "Inserire numero di telefono"
            numero.requestFocus()
            return
        }
        if (!Patterns.PHONE.matcher(numero.text.toString()).matches()) {
            numero.error = "Numero non valido"
            numero.requestFocus()
            return
        }
        if (password.text.toString().isEmpty()) {
            password.error = "Inserire password "
            password.requestFocus()
            return
        }
        if (nome.text.toString().isEmpty()) {
            nome.error = "Inserire nome"
            nome.requestFocus()
            return
        }
        if (cognome.text.toString().isEmpty()) {
            cognome.error = "Inserire cognome"
            cognome.requestFocus()
            return
        }
        if (email.text.toString().isEmpty()) {
            email.error = "Inserire email"
            email.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            email.error = "Email non valida"
            email.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(
                        baseContext, "Registrazione fallita. Riprova!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}

