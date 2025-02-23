package online.clugo19.edad_sesion1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Aplica los insets de las barras del sistema al contenedor principal.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias a los elementos de la interfaz
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val btnVerificar = findViewById<Button>(R.id.btnVerificar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Acción al presionar el botón
        btnVerificar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val edadText = etEdad.text.toString()

            // Validación: Verifica que los campos no estén vacíos
            if (nombre.isEmpty() || edadText.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa todos los datos", Toast.LENGTH_SHORT).show()
            } else {
                // Intenta convertir la edad a entero
                val edad = edadText.toIntOrNull()
                if (edad == null) {
                    Toast.makeText(this, "Ingresa una edad válida", Toast.LENGTH_SHORT).show()
                } else {
                    // Verifica si la persona es mayor de edad o no
                    if (edad >= 18) {
                        tvResultado.text = "Hola $nombre, eres mayor de edad."
                    } else {
                        tvResultado.text = "Hola $nombre, eres menor de edad."
                    }
                }
            }
        }
    }
}
