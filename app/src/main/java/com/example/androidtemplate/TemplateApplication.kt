package com.example.androidtemplate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kr.pe.ssun.template.timber.TimberModule

@HiltAndroidApp
class TemplateApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        TimberModule.initialize()
    }
}