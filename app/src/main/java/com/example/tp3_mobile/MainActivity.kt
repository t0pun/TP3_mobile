package com.example.tp3_mobile

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nom : EditText = findViewById(R.id.editTextNom)
        val prenom : EditText = findViewById(R.id.editTextPrenom)
        val naissance : EditText = findViewById(R.id.editTextDateNaissance)
        val numero : EditText = findViewById(R.id.editTextTelephone)
        val mail : EditText = findViewById(R.id.editTextAdresseMail)
        val sport : CheckBox = findViewById(R.id.checkbox_sport)
        val musique : CheckBox = findViewById(R.id.checkbox_musique)
        val lecture : CheckBox = findViewById(R.id.checkbox_lecture)
        val programmation : CheckBox = findViewById(R.id.checkbox_Programmation)
        val synchro : ToggleButton = findViewById(R.id.toggle_sync)
        val submit : Button = findViewById(R.id.button2)
        val nomLayout: TextInputLayout = findViewById(R.id.textInputLayoutNom)
        val prenomLayout: TextInputLayout = findViewById(R.id.textInputLayoutPrenom)
        val naissanceLayout: TextInputLayout = findViewById(R.id.textInputLayoutDateNaissance)
        val telephoneLayout: TextInputLayout = findViewById(R.id.textInputLayoutTelephone)
        val mailLayout: TextInputLayout = findViewById(R.id.textInputLayoutAdresseMail)

        submit.setOnClickListener {


            val nom_text  = nom.text.toString()
            val prenom_text  = prenom.text.toString()
            val naissance_text  = naissance.text.toString()
            val numero_text  = numero.text.toString()
            val mail_text = mail.text.toString()

            Toast.makeText(this, nom_text, Toast.LENGTH_SHORT).show()

            //SSval isSynchro = synchro.isChecked()

            val intent = Intent(this, RecapActivity::class.java)

            if (nom_text.isEmpty() || nom_text.contains(Regex("\\d"))) {
                nomLayout.error = "le champ saisi contient une erreur"
            }
            if (prenom_text.isEmpty() || prenom_text.contains(Regex("\\d"))) {
                prenomLayout.error = "le champ saisi contient une erreur"
            }
            //faire quelque chose pour la date de naissance
            naissance.setOnClickListener {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                val datePickerDialog = DatePickerDialog(
                    this,
                    { view, selectedYear, selectedMonth, selectedDay ->
                        val formattedDate = String.format(
                            Locale.getDefault(),
                            "%02d/%02d/%04d",
                            selectedDay,
                            selectedMonth + 1,
                            selectedYear
                        )
                        naissance.setText(formattedDate)
                    },
                    year,
                    month,
                    day
                )
                datePickerDialog.show()
            }
            val phoneNumberPattern = Regex("^(0|\\+33|0033)[1-9][1-9][0-9]{8}$")
            if (numero_text.isEmpty() || numero_text.matches(phoneNumberPattern)) {
                telephoneLayout.error = "numero de téléphone invalide"
            }
            val emailPattern = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
            if (mail_text.isEmpty() || !mail_text.matches(emailPattern)) {
                mailLayout.error = "adresse email invalide"
            }

            intent.putExtra("nom", nom_text)
            intent.putExtra("prenom", prenom_text)
            intent.putExtra("naissance", naissance_text)
            intent.putExtra("numero", numero_text)
            intent.putExtra("mail", mail_text)
            if(sport.isChecked){
                intent.putExtra("sport", "sport")
            }
            if(musique.isChecked){
                intent.putExtra("musique", "musique ")
            }
            if(lecture.isChecked){
                intent.putExtra("lecture", "lecture")
            }
            if(programmation.isChecked){
                intent.putExtra("programmation", "programmation")
            }
            if(synchro.isChecked){
                intent.putExtra("synchronisation", "synchronisation")
            }else{
                intent.putExtra("pasSynchronise", "pas synchronisé")
            }

            startActivity(intent)

        }

        }



}