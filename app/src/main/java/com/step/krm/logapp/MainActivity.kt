package com.step.krm.logapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.step.krm.logapp.fragment.ButtonFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_main, ButtonFragment())
            .addToBackStack(ButtonFragment::class.java.canonicalName)
            .commit()
    }
}