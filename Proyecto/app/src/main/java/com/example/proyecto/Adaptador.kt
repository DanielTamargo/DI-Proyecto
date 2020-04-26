package com.example.proyecto

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class Adaptador: RecyclerView.Adapter<Adaptador.ViewHolder>() {


    class ViewHolder(v: View):RecyclerView.ViewHolder(v) {
        var tv_num: TextView
        var card_view: CardView
        var tv_desc: TextView
        init {
            card_view = v.findViewById(R.id.card_view)
            tv_num = v.findViewById(R.id.tv_num)
            tv_desc = v.findViewById(R.id.tv_descripcion)
        }
    }

    //Situar celda
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_celda, parent, false)
        return ViewHolder(v)
    }

    //Número de celdas a devolver
    override fun getItemCount(): Int {
        //como la última se ve incompleta si tengo la toolbar, intentaré añadir una y a la útlima le quitaré todos los elementos
        return 20 + 1
    }

    //Modificar lo que vaya a salir en la celda
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        
        //Vaya puta maravilla cómo funcionan las cardviews y las celdas con el wrap content, maravillosisimo
        holder.tv_desc.visibility = View.GONE
        if (position % 4 == 0) {
            holder.tv_desc.visibility = View.VISIBLE
        }
        //La última que sale se buggea, así que creamos una de más pero en vez de darle info, la escondemos
        //Creo que esto puede ocasionar algún bug, pero mejor eso a que la última tarjeta no salga, ¿no?
        if (position == 20) {
            holder.card_view.visibility = View.GONE
        } else {
            if (holder.card_view.visibility == View.GONE) holder.card_view.visibility = View.VISIBLE
            holder.tv_num.text = "Celda número $position"
        }
    }

}