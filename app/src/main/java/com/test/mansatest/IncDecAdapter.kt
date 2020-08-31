package com.test.mansatest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.in_dec_item.view.*

class IncDecAdapter(val adapterOnClick : (Int) -> Unit) : RecyclerView.Adapter<IncDecAdapter.MyViewHolder>() {
    var list= mutableListOf<ModelClass>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val view=LayoutInflater.from(parent.context).inflate(R.layout.in_dec_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         holder.bind(list[position])
    }

    fun addData(list: MutableList<ModelClass>) {
        this.list=list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
         itemView.tv_m.setOnClickListener { list[adapterPosition].count= list[adapterPosition].count-1
         itemView.tv_val.text= (list[adapterPosition].count).toString()
         }
            itemView.tv_p.setOnClickListener { list[adapterPosition].count= list[adapterPosition].count+1
            itemView.tv_val.text= (list[adapterPosition].count).toString()}
            itemView.tv_print.setOnClickListener { adapterOnClick(list[adapterPosition].count) }
        }
        fun bind(data: ModelClass) {
           itemView.tv_val.text=data.count.toString()
        }
    }

}