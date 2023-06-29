package com.step.krm.logapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.step.krm.logapp.R
import com.step.krm.logapp.data.LogRepositoryImpl

class LogsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_logs_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.list).apply {
            setHasFixedSize(true)
        }
    }

    override fun onResume() {
        super.onResume()
        recyclerView.adapter = LogsViewAdapter(LogRepositoryImpl.instance.getAllLogs())
    }
}
