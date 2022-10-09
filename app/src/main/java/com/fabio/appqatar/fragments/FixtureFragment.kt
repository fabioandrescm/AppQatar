package com.fabio.appqatar.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fabio.appqatar.Equipos
import com.fabio.appqatar.GrupoActivity
import com.fabio.appqatar.R
import com.fabio.appqatar.databinding.FragmentFixtureBinding


class FixtureFragment : Fragment() {
    lateinit var binding: FragmentFixtureBinding
    lateinit var datos: ArrayList<Equipos>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFixtureBinding.inflate(inflater, container, false)

        binding.btnA.setOnClickListener { cambiarActividad(GrupoActivity::class.java, 1) }
        binding.btnB.setOnClickListener { cambiarActividad(GrupoActivity::class.java, 2) }
        binding.btnC.setOnClickListener { cambiarActividad(GrupoActivity::class.java, 3) }
        binding.btnD.setOnClickListener { cambiarActividad(GrupoActivity::class.java, 4) }
        binding.btnE.setOnClickListener { cambiarActividad(GrupoActivity::class.java, 5) }
        binding.btnF.setOnClickListener { cambiarActividad(GrupoActivity::class.java, 6) }
        binding.btnG.setOnClickListener { cambiarActividad(GrupoActivity::class.java, 7) }
        binding.btnH.setOnClickListener { cambiarActividad(GrupoActivity::class.java, 8) }
        return binding.root
    }

    fun cambiarActividad(open: Class<*>?, tipo: Int) {

        val intent = Intent(getActivity(), open)
        when (tipo) {
            1 -> {
                agregarEquipo(0, 17, 21, 11)
                intent.putExtra("nombregrupo", binding.btnA.text)
            }

            2 -> {
                agregarEquipo(9, 13, 28, 29)
                intent.putExtra("nombregrupo", binding.btnB.text)
            }

            3 -> {
                agregarEquipo(12, 16, 27, 25)
                intent.putExtra("nombregrupo", binding.btnC.text)
            }
            4 -> {
                agregarEquipo(4, 30, 2, 23)
                intent.putExtra("nombregrupo", binding.btnD.text)
            }
            5 -> {
                agregarEquipo(7, 31, 1, 15)
                intent.putExtra("nombregrupo", binding.btnE.text)
            }
            6 -> {
                agregarEquipo(5, 6, 22, 19)
                intent.putExtra("nombregrupo", binding.btnF.text)
            }
            7 -> {
                agregarEquipo(3, 8, 10, 26)
                intent.putExtra("nombregrupo", binding.btnG.text)
            }
            8 -> {
                agregarEquipo(24, 20, 18, 14)
                intent.putExtra("nombregrupo", binding.btnH.text)
            }
        }
        intent.putExtra("grupo", datos)

        getActivity()?.startActivity(intent)
    }

    fun agregarEquipo(equipo1: Int, equipo2: Int, equipo3: Int, equipo4: Int): ArrayList<Equipos> {
        val arrayNombres = resources.getStringArray(R.array.nombres)
        val arrayImagenes = resources.obtainTypedArray(R.array.imagenes)
        var equipo = Equipos()
        datos = ArrayList()
        var int = equipo1
        var arr = arrayNombres[int].split(" ").toTypedArray()
        equipo.nombre = "" + arr.get(0)
        equipo.imagen = arrayImagenes.getResourceId(int, -1)
        datos.add(equipo)
        equipo = Equipos()
        int = equipo2
        arr = arrayNombres[int].split(" ").toTypedArray()
        equipo.nombre = "" + arr.get(0)
        equipo.imagen = arrayImagenes.getResourceId(int, -1)
        datos.add(equipo)
        equipo = Equipos()
        int = equipo3
        arr = arrayNombres[int].split(" ").toTypedArray()
        equipo.nombre = "" + arr.get(0)
        equipo.imagen = arrayImagenes.getResourceId(int, -1)
        datos.add(equipo)
        equipo = Equipos()
        int = equipo4
        arr = arrayNombres[int].split(" ").toTypedArray()
        equipo.nombre = "" + arr.get(0)
        equipo.imagen = arrayImagenes.getResourceId(int, -1)
        datos.add(equipo)
        return datos

    }

}


