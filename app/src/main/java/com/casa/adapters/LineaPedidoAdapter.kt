package com.casa

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import kotlinx.android.synthetic.main.linea_pedido_list_row.view.*
import java.util.*


class LineaPedidoAdapter(private var items: ArrayList<LineaPedidoDto>):
        RecyclerView.Adapter<LineaPedidoAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.checkBoxOK?.setOnClickListener {
            p0?.itemView.setBackgroundColor(Color.parseColor("#ff99cc00"))
            if(p0?.checkBoxNOK?.isChecked!!) {
                p0?.checkBoxNOK?.toggle();
            }
            if(p0?.checkBoxIP?.isChecked!!) {
                p0?.checkBoxIP?.toggle();
            }
        }
        p0?.checkBoxNOK?.setOnClickListener {
            p0?.itemView.setBackgroundColor(Color.parseColor("#ffff4444"))
            if(p0?.checkBoxOK?.isChecked!!)
                p0?.checkBoxOK?.toggle();
            if(p0?.checkBoxIP?.isChecked!!) {
                p0?.checkBoxIP?.toggle();
            }
        }

        p0?.checkBoxIP?.setOnClickListener {
            p0?.itemView.setBackgroundColor(Color.parseColor("#ffe65d"))

            if(p0?.checkBoxOK?.isChecked!!)
                p0?.checkBoxOK?.toggle();
            if(p0?.checkBoxNOK?.isChecked!!) {
                p0?.checkBoxNOK?.toggle();
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(p0?.context).inflate(R.layout.linea_pedido_list_row, p0, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var txtName: TextView? = null
        var checkBoxOK: CheckBox? = null
        var checkBoxIP: CheckBox? = null
        var checkBoxNOK: CheckBox? = null
        init {
            this.txtName = row?.findViewById<TextView>(R.id.txtName)
            this.checkBoxOK = row?.findViewById<CheckBox>(R.id.checkBoxOK)
            this.checkBoxIP = row?.findViewById<CheckBox>(R.id.checkBoxIP)
            this.checkBoxNOK = row?.findViewById<CheckBox>(R.id.checkBoxNOK)
        }
    }
}