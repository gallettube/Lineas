package com.casa
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

class PedidoAdapter(private var items: ArrayList<PedidoDto>):
        RecyclerView.Adapter<PedidoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(p0?.context).inflate(R.layout.pedido_list_row, p0, false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        var titleDto = items[p1]
        holder?.txtDate?.text = titleDto.date
        holder?.txtLine?.text = titleDto.line
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        init{
            row.setOnClickListener {
                var intent = Intent(row.context, CocinaDetailsActivity::class.java)
                intent.putExtra("key", getAdapterPosition())
                row.context.startActivity(intent)
            }
        }
        var txtDate: TextView? = null
        var txtLine: TextView? = null
        init {
            this.txtDate = row?.findViewById<TextView>(R.id.txtDate)
            this.txtLine = row?.findViewById<TextView>(R.id.txtLine)
        }

    }
}