package com.example.androidtemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidtemplate.ui.SsunApp
import dagger.hilt.android.AndroidEntryPoint
import kr.pe.ssun.template.core.designsystem.theme.SsunTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SsunTheme {
                SsunApp()
            }
        }
    }
}