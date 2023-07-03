package com.step.krm.logapp.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.step.krm.logapp.R
import com.step.krm.logapp.composable.LogList
import com.step.krm.logapp.data.LogRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LogsFragment : Fragment() {

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
        Handler(Looper.getMainLooper()).post {
            repository.getAllLogs { logs ->
                view.apply {
                    findViewById<ComposeView>(R.id.logs_compose_view).setContent {
                        LogList(logs)
                    }
                }
            }
        }
    }
}
