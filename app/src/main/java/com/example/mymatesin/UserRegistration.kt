package com.example.mymatesin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class UserRegistration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userregistration)

        supportActionBar?.hide()

        var registerbutton = findViewById<Button>(R.id.confermaregistrazione)
        var numero = findViewById<EditText>(R.id.NumeroTelefono)
        var password = findViewById<EditText>(R.id.Password)
        var nome = findViewById<EditText>(R.id.Nome)
        var cognome = findViewById<EditText>(R.id.Cognome)
        var email = findViewById<EditText>(R.id.Mail)

        registerbutton.setOnClickListener {
            if ((nome.length() == 0) || (cognome.length() == 0) || (email.length() == 0) || (numero.length() == 0) || (password.length() == 0))
                Toast.makeText(applicationContext, "Non sono stati compilati tutti i campi", Toast.LENGTH_LONG).show()
             else if (numero.length() != 10)
                Toast.makeText(applicationContext, "Numero di telefono non valido", Toast.LENGTH_LONG).show()
              else if (password.length() < 8)
                Toast.makeText(applicationContext, "La password deve contenere almeno 8 caratteri", Toast.LENGTH_LONG).show()
                else Toast.makeText(applicationContext, "Registrazione effettuata con Successo! Torna al Login", Toast.LENGTH_LONG).show()
        }
    }


}

