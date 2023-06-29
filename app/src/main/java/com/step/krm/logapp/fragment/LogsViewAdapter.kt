package com.step.krm.logapp.fragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.step.krm.logapp.R

class LogsViewAdapter(private val values: List<Int>) :
    RecyclerView.Adapter<LogsViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView

        init {
            idView = view.findViewById(R.id.item_log)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.text_logs, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.idView.text = "ITEMS = ${values[position]}"
    }

    override fun getItemCount(): Int = values.size
}