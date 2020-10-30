package com.example.mymatesin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        val btn_sign_up = findViewById<Button>(R.id.btn_sign_up)
        btn_sign_up.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            finish()
        }

        val btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener {
            doLogin()
        }
    }

    private fun doLogin() {
        val email = findViewById<EditText>(R.id.input_email)
        val password = findViewById<EditText>(R.id.input_password)

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
        if (password.text.toString().isEmpty()) {
            password.error = "Inserire password "
            password.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(baseContext, "Login OK", Toast.LENGTH_SHORT).show()
                        updateUI(user)
                    } else {
                        updateUI(null)
                    }
                }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        //updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            startActivity(Intent(this@LoginActivity,DashboardActivity::class.java))
            finish()
        }
        if (currentUser == null) {
            Toast.makeText(baseContext, "Login failed", Toast.LENGTH_SHORT).show()
        }
    }
}