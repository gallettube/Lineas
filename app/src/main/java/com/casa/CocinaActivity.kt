package com.casa
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import java.text.SimpleDateFormat
import java.util.*



class CocinaActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cocina_main)
        recyclerView = findViewById(R.id.recyclerView)
        var adapter = PedidoAdapter(generateData())
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun generateData(): ArrayList<PedidoDto> {
        var result = ArrayList<PedidoDto>()
        for (i in 0..9) {
            val format = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH)
            val date = Date()
            val Pendientes = (0..10).random()
            val Completos =  (0..10).random()
            var data = PedidoDto(format.format(date),
                    "Total "+(Pendientes+Completos)+" "+Pendientes+" Pendientes "+Completos+" Completos ")
            result.add(data)
        }
        return result
    }

}
