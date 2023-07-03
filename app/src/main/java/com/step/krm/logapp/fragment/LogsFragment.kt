package com.step.krm.logapp.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.step.krm.logapp.R
import com.step.krm.logapp.data.LogRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LogsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var repository: LogRepository
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
        repository.getAllLogs { logs ->
            Handler(Looper.getMainLooper()).post {
                recyclerView.adapter = LogsViewAdapter(logs)
            }
        }
    }
}
