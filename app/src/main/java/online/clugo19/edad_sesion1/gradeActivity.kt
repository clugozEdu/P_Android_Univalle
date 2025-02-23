package online.clugo19.edad_sesion1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class gradeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)

        // Referencias a los elementos del layout
        val etNota1 = findViewById<EditText>(R.id.etNota1)
        val etNota2 = findViewById<EditText>(R.id.etNota2)
        val etNota3 = findViewById<EditText>(R.id.etNota3)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvPromedio = findViewById<TextView>(R.id.tvPromedio)

        btnCalcular.setOnClickListener {
            val nota1Text = etNota1.text.toString()
            val nota2Text = etNota2.text.toString()
            val nota3Text = etNota3.text.toString()

            if(nota1Text.isEmpty() || nota2Text.isEmpty() || nota3Text.isEmpty()){
                Toast.makeText(this, "Por favor, ingresa todas las notas", Toast.LENGTH_SHORT).show()
            } else {
                val nota1 = nota1Text.toDoubleOrNull()
                val nota2 = nota2Text.toDoubleOrNull()
                val nota3 = nota3Text.toDoubleOrNull()

                if(nota1 == null || nota2 == null || nota3 == null){
                    Toast.makeText(this, "Ingresa valores válidos", Toast.LENGTH_SHORT).show()
                } else {
                    val promedio = (nota1 + nota2 + nota3) / 3
                    tvPromedio.text = "Promedio: %.2f".format(promedio)
                }
            }
        }
    }

    // Inflar el menú de navegación
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_navigation, menu)
        return true
    }

    // Manejar la selección de opciones del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_calcular_edad -> {
                // Navegar a la pantalla de calcular edad (MainActivity)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_calcular_nota -> {
                // Ya estamos en la pantalla de calcular nota
                Toast.makeText(this, "Ya estás en Calcular Nota", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
