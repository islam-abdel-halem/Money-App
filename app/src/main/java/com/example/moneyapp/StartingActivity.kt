package com.example.moneyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.moneyapp.routes.StartNavHost
import com.example.moneyapp.ui.theme.MoneyAppTheme

class StartingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoneyAppTheme {
                StartNavHost()
            }
        }
    }
}
