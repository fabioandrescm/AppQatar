package com.fabio.appqatar

import android.location.Geocoder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fabio.appqatar.databinding.ActivityDetalleEquipoBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class DetalleEquipo : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivityDetalleEquipoBinding
    private lateinit var mMap: GoogleMap
    lateinit var equipo: Equipos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleEquipoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        equipo = intent.getSerializableExtra("equipo") as Equipos
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        binding.tvNombreEquipo.text = equipo.nombre
        binding.tvRankingEquipo.text = equipo.posicion
        binding.tvRegionEquipo.text = equipo.region
        binding.tvClasificacionEquipo.text = equipo.clasificacion
        binding.tvImagedetalle.setImageResource(equipo.imagen)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val geocoder = Geocoder(this)
        // Add a marker in Sydney and move the camera
        val location = LatLng(equipo.longitud.toDouble(), equipo.latitud.toDouble())
        mMap.addMarker(MarkerOptions().position(location).title(equipo.nombre))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                location, 4.0f
            )
        )
    }

}