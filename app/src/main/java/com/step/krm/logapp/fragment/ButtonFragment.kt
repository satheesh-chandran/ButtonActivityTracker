package com.step.krm.logapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.step.krm.logapp.R
import com.step.krm.logapp.data.LogRepositoryImpl

class ButtonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            requireActivity().baseContext.let { LogRepositoryImpl.instance(it).addLog(1) }
        }

        view.findViewById<Button>(R.id.button2).setOnClickListener {
            requireActivity().baseContext.let { LogRepositoryImpl.instance(it).addLog(2) }
        }

        view.findViewById<Button>(R.id.button3).setOnClickListener {
            requireActivity().baseContext.let { LogRepositoryImpl.instance(it).addLog(3) }
        }

        view.findViewById<Button>(R.id.all_logs).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.activity_main, LogsFragment())
                .addToBackStack(LogsFragment::class.java.canonicalName)
                .commit()
        }

        view.findViewById<Button>(R.id.delete_logs).setOnClickListener {
            requireActivity().baseContext.let { LogRepositoryImpl.instance(it).removeAllLogs()}
        }
    }
}