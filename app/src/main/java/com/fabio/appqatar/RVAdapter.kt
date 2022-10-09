package com.fabio.appqatar

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.fabio.appqatar.databinding.ItemEquipoBinding

class RVAdapter(val context: FragmentActivity?, private val items: ArrayList<Equipos>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemEquipoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEquipoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {
            with(items[position]) {
                binding.tvNombre.text = this.nombre
                binding.tvposicion.text = this.posicion
                binding.ivImagen.setImageResource(this.imagen)

                holder.itemView.setOnClickListener {
                    val intent = Intent(context, DetalleEquipo::class.java)
                    intent.putExtra("equipo", this)
                    context?.startActivity(intent)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}