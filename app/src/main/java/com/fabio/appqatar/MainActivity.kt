package com.fabio.appqatar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabio.appqatar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var datos: ArrayList<Equipos>
    lateinit var adaptador: RecyclerView.Adapter<*>
    lateinit var layoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //layoutManager = GridLayoutManager(this, 2)
        binding.rvContenido.layoutManager = layoutManager

        llenarPokemones()

        adaptador = RVAdapter(this, datos)
        binding.rvContenido.adapter = adaptador
    }
    fun llenarPokemones() {
        datos = ArrayList()
        val arrayNombres = resources.getStringArray(R.array.nombres)
        val arrayImagenes = resources.obtainTypedArray(R.array.imagenes)
        val arrayregion = resources.getStringArray(R.array.region)
        val arrayclasificacion = resources.getStringArray(R.array.posicionClasificacion)
        for(i in arrayNombres.indices) {
            val equipo = Equipos()
            val arr = arrayNombres[i].split(" ").toTypedArray()
            equipo.nombre = "" + arr.get(0)
            equipo.posicion = "Ranking FIFA: " + arr.get(1)
            equipo.imagen = arrayImagenes.getResourceId(i, -1)
            equipo.region = arrayregion[i]
            equipo.clasificacion = arrayclasificacion[i]
            datos.add(equipo)
        }
    }

}