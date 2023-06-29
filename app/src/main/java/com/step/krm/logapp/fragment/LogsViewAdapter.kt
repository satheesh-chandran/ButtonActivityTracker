package com.step.krm.logapp.fragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.step.krm.logapp.R
import com.step.krm.logapp.data.LogDTO
import java.sql.Date
import java.sql.Timestamp
import java.util.LinkedList

class LogsViewAdapter(private val logs: LinkedList<LogDTO>) :
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
        val logDTO = logs[position]

        val stamp = Timestamp(logDTO.timestamp)
        val date = Date(stamp.time)

        holder.idView.text = "${logDTO.id}) Button with ID - ${logDTO.buttonId} clicked on $date"
    }

    override fun getItemCount(): Int = logs.size
}