package cbass.apptareasroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import cbass.apptareasroom.R
import cbass.apptareasroom.databinding.ItemLayoutBinding
import cbass.apptareasroom.model.Tarea

class TareaAdapter : RecyclerView.Adapter<TareaAdapter.CustomViewHolder>() {
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemLayoutBinding.bind(itemView)

        fun bindData(tarea:Tarea)
        {
            with(binding)
            {
                tvTarea.text = tarea.nombre
            }
        }

    }

    var lista:List<Tarea> = ArrayList<Tarea>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun actualizar(lista:List<Tarea>)
    {
        this.lista = lista
        notifyDataSetChanged()
    }

}