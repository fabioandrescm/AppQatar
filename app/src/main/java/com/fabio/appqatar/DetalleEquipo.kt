package com.fabio.appqatar

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fabio.appqatar.databinding.ActivityDetalleEquipoBinding

class DetalleEquipo : AppCompatActivity() {
    lateinit var binding: ActivityDetalleEquipoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleEquipoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val equipo = intent.getSerializableExtra("equipo") as Equipos

        binding.tvNombreEquipo.text = equipo.nombre
        binding.tvRankingEquipo.text = equipo.posicion
        binding.tvRegionEquipo.text = equipo.region
        binding.tvClasificacionEquipo.text = equipo.clasificacion
        binding.tvImagedetalle.setImageResource(equipo.imagen)

    }
}