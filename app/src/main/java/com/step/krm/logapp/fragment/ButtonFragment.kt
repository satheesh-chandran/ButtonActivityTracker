package com.step.krm.logapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.step.krm.logapp.R
import com.step.krm.logapp.composable.ButtonPage
import com.step.krm.logapp.data.LogRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ButtonFragment : Fragment() {
    @Inject
    lateinit var repository: LogRepository
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_button, container, false)
        return view.apply {
            findViewById<ComposeView>(R.id.compose_view).setContent {

                ButtonPage(repository) {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.activity_main, LogsFragment())
                        .addToBackStack(LogsFragment::class.java.canonicalName)
                        .commit()
                }
            }
        }
    }
}