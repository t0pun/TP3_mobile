package com.example.tp3_mobile

import android.annotation.SuppressLint
import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileWriter
import java.io.IOException

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
        val boutonValider: Button = findViewById(R.id.buttonValider)



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
        val pasSynchro = intent.getStringExtra("pasSynchronise")




        textView1.text = nom
        textView2.text = prenom
        textView3.text = naissance
        textView4.text = numero
        textView5.text = mail
        if(sport!=null) {
            textViewSport.visibility = View.VISIBLE
            textViewSport.text = sport
        }
        if(musique!=null){
            textViewMusique.visibility = View.VISIBLE
            textViewMusique.text = musique
        }
        if(lecture!=null){
            textViewLecture.visibility = View.VISIBLE
            textViewLecture.text = lecture
        }
        if(programmation!=null){
            textViewProgrammation.visibility = View.VISIBLE
            textViewProgrammation.text = programmation
        }
        if(synchro!=null){
            textViewSynchro.visibility = View.VISIBLE
            textViewSynchro.text = synchro
        }
        if(pasSynchro!=null){
            textViewPasSynchro.visibility = View.VISIBLE
            textViewPasSynchro.text = pasSynchro
        }


        boutonValider.setOnClickListener{
            val donnees= "Prenom: $prenom\nNom: $nom\nDate de naissance: $naissance\nNumero de téléphone: $numero\nEmail: $mail\nSport: $sport\nMusique: $musique\nLecture: $lecture\nProgrammation: $programmation\nSynchronisation: $synchro\nPas de synchronisation: $pasSynchro"
            val donneesJson= JSONObject()
            donneesJson.put("prenom", prenom)
            donneesJson.put("nom", nom)
            donneesJson.put("naissance", naissance)
            donneesJson.put("numero", numero)
            donneesJson.put("mail", mail)
            donneesJson.put("sport", sport)
            donneesJson.put("musique", musique)
            donneesJson.put("lecture", lecture)
            donneesJson.put("programmation", programmation)
            donneesJson.put("synchro", synchro)
            donneesJson.put("pasSynchro", pasSynchro)


            val context: Context = applicationContext
            val fileName ="fichier.txt"
            val fileName2 ="info.json"
            try {
                val file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName)
                val fileWriter = FileWriter(file)
                fileWriter.write(donnees)
                fileWriter.close()

                val file2 = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName2)
                val gson = Gson()
                val jsonData = gson.toJson(donneesJson)
                val fileWriter2 = FileWriter(file2)
                fileWriter2.write(jsonData)
                fileWriter2.close()


                Log.d("FileCreation", "Fichier créé avec succès : $fileName")
                Log.d("FileCreation", "Fichier JSON créé avec succès : $fileName2")
            } catch (e: IOException) {
                Log.e("FileCreation", "Échec de la création du fichier : $fileName", e)
                Log.e("FileCreation", "Échec de la création du fichier JSON : $fileName2", e)

            }


        }



        boutonRetour.setOnClickListener{
            finish()
        }



    }




}