package com.test.mansatest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var incDecAdapter:IncDecAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        incDecAdapter= IncDecAdapter { item-> doClick(item)}
        setRecyclerView()
        setData()
    }

    private fun setData() {
        val list= mutableListOf<ModelClass>()
        for(i in 0 until 100){
           val data= ModelClass(0)
            list.add(data)
            Log.e("count=",i.toString())
        }
        incDecAdapter?.addData(list)
    }

    private fun setRecyclerView() {
        val manager= LinearLayoutManager(this)
        rv.layoutManager = manager
        rv.adapter = incDecAdapter
    }
    fun doClick(count:Int) {
      tv_count.text= count.toString()
    }
}
