package com.fabio.appqatar.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabio.appqatar.Equipos
import com.fabio.appqatar.R
import com.fabio.appqatar.RVAdapter
import com.fabio.appqatar.databinding.FragmentEquiposBinding


class EquiposFragment : Fragment() {
    lateinit var binding: FragmentEquiposBinding
    lateinit var datos: ArrayList<Equipos>
    lateinit var adaptador: RecyclerView.Adapter<*>
    lateinit var layoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEquiposBinding.inflate(inflater, container, false)
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        //layoutManager = GridLayoutManager(this, 2)
        binding.rvContenido.layoutManager = layoutManager

        llenarEquipos()

        adaptador = RVAdapter(activity, datos)
        binding.rvContenido.adapter = adaptador
        return binding.root
    }
    fun llenarEquipos() {
        datos = ArrayList()
        val arrayNombres = resources.getStringArray(R.array.nombres)
        val arrayImagenes = resources.obtainTypedArray(R.array.imagenes)
        val arrayregion = resources.getStringArray(R.array.region)
        val arrayLocation = resources.getStringArray(R.array.location)

        val arrayclasificacion = resources.getStringArray(R.array.posicionClasificacion)
        for(i in arrayNombres.indices) {
            val equipo = Equipos()
            val arr = arrayNombres[i].split(" ").toTypedArray()
            val locationArr = arrayLocation[i].split(",").toTypedArray()
            equipo.nombre = "" + arr.get(0)
            equipo.posicion = "Ranking FIFA: " + arr.get(1)
            equipo.imagen = arrayImagenes.getResourceId(i, -1)
            equipo.region = arrayregion[i]
            equipo.clasificacion = arrayclasificacion[i]
            equipo.longitud = locationArr.get(0)
            equipo.latitud = locationArr.get(1)
            datos.add(equipo)
        }
    }
}