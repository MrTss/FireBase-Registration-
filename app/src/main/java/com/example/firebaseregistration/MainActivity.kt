package com.example.firebaseregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        registrationButton.setOnClickListener {

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "ველი/ველები ცარიელია!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "რეგისტრაცია წარმატებით დასრულდა", Toast.LENGTH_SHORT)
                            .show()

                    } else {
                        Toast.makeText(this, "არასწორი ფორმატი", Toast.LENGTH_SHORT).show()
                    }


                }


        }
    }
}
