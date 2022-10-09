package com.fabio.appqatar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fabio.appqatar.databinding.ActivityDetalleEquipoBinding
import com.fabio.appqatar.databinding.ActivityGrupoBinding

class GrupoActivity : AppCompatActivity() {
    lateinit var binding: ActivityGrupoBinding
    lateinit var equipo: ArrayList<Equipos>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGrupoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nombre = intent.getSerializableExtra("nombregrupo").toString()
        equipo = intent.getSerializableExtra("grupo") as ArrayList<Equipos>
        binding.tvGruponombre.text = intent.getSerializableExtra("nombregrupo").toString()


        var a = ""
        for (i in 1..equipo.size) {
            when (i) {
                1 -> {
                    binding.tvtEq1.text = equipo.get(0).nombre
                    binding.imEq1.setImageResource(equipo.get(0).imagen)
                }
                2 -> {
                    binding.tvtEq2.text = equipo.get(1).nombre
                    binding.imEq2.setImageResource(equipo.get(1).imagen)
                }
                3 -> {
                    binding.tvtEq3.text = equipo.get(2).nombre
                    binding.imEq3.setImageResource(equipo.get(2).imagen)
                }
                4 -> {
                    binding.tvtEq4.text = equipo.get(3).nombre
                    binding.imEq4.setImageResource(equipo.get(3).imagen)
                }
            }
        }
        for (i in 1..6) {
            when (i) {
                1 -> {
                    binding.im1p1.setImageResource(equipo.get(0).imagen)
                    binding.tv1p1.text = equipo.get(0).nombre
                    binding.im2p1.setImageResource(equipo.get(1).imagen)
                    binding.tv2p1.text = equipo.get(1).nombre
                }
                2 -> {
                    binding.im1p2.setImageResource(equipo.get(2).imagen)
                    binding.tv1p2.text = equipo.get(2).nombre
                    binding.im2p2.setImageResource(equipo.get(3).imagen)
                    binding.tv2p2.text = equipo.get(3).nombre
                }
                3 -> {
                    binding.im1p3.setImageResource(equipo.get(0).imagen)
                    binding.tv1p3.text = equipo.get(0).nombre
                    binding.im2p3.setImageResource(equipo.get(2).imagen)
                    binding.tv2p3.text = equipo.get(2).nombre
                }
                4 -> {
                    binding.im1p4.setImageResource(equipo.get(3).imagen)
                    binding.tv1p4.text = equipo.get(3).nombre
                    binding.im2p4.setImageResource(equipo.get(1).imagen)
                    binding.tv2p4.text = equipo.get(1).nombre
                }
                5 -> {
                    binding.im1p5.setImageResource(equipo.get(3).imagen)
                    binding.tv1p5.text = equipo.get(3).nombre
                    binding.im2p5.setImageResource(equipo.get(0).imagen)
                    binding.tv2p5.text = equipo.get(0).nombre
                }
                6 -> {
                    binding.im1p6.setImageResource(equipo.get(1).imagen)
                    binding.tv1p6.text = equipo.get(1).nombre
                    binding.im2p6.setImageResource(equipo.get(2).imagen)
                    binding.tv2p6.text = equipo.get(2).nombre
                }
            }
        }


    }

//        binding.tvNombreEquipo.text = equipo.nombre
//        binding.tvRankingEquipo.text = equipo.posicion
//        binding.tvRegionEquipo.text = equipo.region
//        binding.tvClasificacionEquipo.text = equipo.clasificacion
    //binding.tvImagedetalle.setImageResource(equipo.imagen)

}


