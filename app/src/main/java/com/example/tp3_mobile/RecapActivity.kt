package com.example.tp3_mobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RecapActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscrip)

        val intent = intent

        val textView1: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.textView2)
        val textView3: TextView = findViewById(R.id.textView3)
        val textView4: TextView = findViewById(R.id.textView4)
        val textView5: TextView = findViewById(R.id.textView5)
        val textViewSport: TextView = findViewById(R.id.textViewSport)
        val textViewMusique: TextView = findViewById(R.id.textViewMusique)
        val textViewLecture: TextView = findViewById(R.id.textViewlecture)
        val textViewProgrammation: TextView = findViewById(R.id.textViewProgrammation)
        val textViewSynchro: TextView = findViewById(R.id.textViewSynchro)
        val textViewPasSynchro: TextView = findViewById(R.id.textViewPasSynchro)

        val boutonRetour: Button = findViewById(R.id.button)



        val nom = intent.getStringExtra("nom")
        val prenom = intent.getStringExtra("prenom")
        val naissance = intent.getStringExtra("naissance")
        val numero = intent.getStringExtra("numero")
        val mail = intent.getStringExtra("mail")
        val sport = intent.getStringExtra("sport")
        val musique = intent.getStringExtra("musique")
        val lecture = intent.getStringExtra("lecture")
        val programmation = intent.getStringExtra("programmation")
        val synchro = intent.getStringExtra("synchronisation")
        val PasSynchro = intent.getStringExtra("pasSynchronise")



        Toast.makeText(this, nom, Toast.LENGTH_SHORT).show()

        textView1.text = nom
        textView2.text = prenom
        textView3.text = naissance
        textView4.text = numero
        textView5.text = mail
        textViewSport.text = sport
        textViewMusique.text = musique
        textViewLecture.text = lecture
        textViewProgrammation.text = programmation
        textViewSynchro.text = synchro
        textViewPasSynchro.text = PasSynchro

        boutonRetour.setOnClickListener{
            finish()
        }

    }




}