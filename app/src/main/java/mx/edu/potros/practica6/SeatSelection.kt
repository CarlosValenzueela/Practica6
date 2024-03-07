package mx.edu.potros.practica6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val title: TextView = findViewById(R.id.titleSeats)
        var posMovie = -1

        val bundle = intent.extras
        if(bundle != null){
            title.setText(bundle.getString("titulo"))
            posMovie = bundle.getInt("id")
        }


        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)


        row1.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId> -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)
            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId> -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId> -1){
                row1.clearCheck()
                row2.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId> -1){
                row1.clearCheck()
                row2.clearCheck()
                row3.clearCheck()

                row4.check(checkedId)
            }
        }

        val confirm: Button = findViewById(R.id.confirm)
        confirm.setOnClickListener {

            // Obtén el radio button seleccionado de cada grupo de radio buttons
            val selectedRadioButtonId = when {
                row1.checkedRadioButtonId != -1 -> row1.checkedRadioButtonId
                row2.checkedRadioButtonId != -1 -> row2.checkedRadioButtonId
                row3.checkedRadioButtonId != -1 -> row3.checkedRadioButtonId
                row4.checkedRadioButtonId != -1 -> row4.checkedRadioButtonId
                else -> -1
            }

            // Verifica si se seleccionó algún radio button
            if (selectedRadioButtonId != -1) {
                // Asigna un valor al radio button seleccionado
                // Resta 1 al total

                // Muestra un mensaje con el valor asignado
                Toast.makeText(this, "Enjoy the movie :D", Toast.LENGTH_LONG).show()
            } else {
                // Si no se seleccionó ningún radio button, muestra un mensaje indicando que se debe seleccionar uno
                Toast.makeText(this, "Debe seleccionar un asiento", Toast.LENGTH_LONG).show()
            }
        }

    }
}