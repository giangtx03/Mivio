package com.mivio.wallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mivio.wallet.core.navigation.AppNavigation
import com.mivio.wallet.core.designsystem.theme.MivioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MivioTheme {
                AppNavigation()
            }
        }
    }
}