package com.casa
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast

class CocinaDetailsActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.cocina_details)

        val position = getIntent().getExtras().getInt("key")
        Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT).show()

        recyclerView = findViewById(R.id.recyclerView)
        var adapter = LineaPedidoAdapter(generateData())
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()

        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun generateData(): ArrayList<LineaPedidoDto> {
        var result = ArrayList<LineaPedidoDto>()
        for (i in 0..9) {
            var user: LineaPedidoDto = LineaPedidoDto("Pedido")
            result.add(user)
        }
        return result
    }

}
