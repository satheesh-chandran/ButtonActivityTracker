package com.step.krm.logapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.step.krm.logapp.composable.ButtonActionTracker
import com.step.krm.logapp.data.LogRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var repository: LogRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContent {
            var isOnFirstPage by remember { mutableStateOf(true) }
            onBackPressedDispatcher.addCallback(this) {
                if (isOnFirstPage) {
                    finish()
                } else {
                    isOnFirstPage = true
                }
            }
            ButtonActionTracker(repository, isOnFirstPage) { isOnFirstPage = false }
        }
    }
}