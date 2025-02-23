package online.clugo19.edad_sesion1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilita edge-to-edge usando WindowCompat
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)

        // Configura el Toolbar como ActionBar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val btnVerificar = findViewById<Button>(R.id.btnVerificar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnVerificar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val edadText = etEdad.text.toString()

            if (nombre.isEmpty() || edadText.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa todos los datos", Toast.LENGTH_SHORT).show()
            } else {
                val edad = edadText.toIntOrNull()
                if (edad == null) {
                    Toast.makeText(this, "Ingresa una edad válida", Toast.LENGTH_SHORT).show()
                } else {
                    if (edad >= 18) {
                        tvResultado.text = "Hola $nombre, eres mayor de edad."
                    } else {
                        tvResultado.text = "Hola $nombre, eres menor de edad."
                    }
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
                Toast.makeText(this, "Ya estás en Calcular Edad", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_calcular_nota -> {
                val intent = Intent(this, gradeActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
