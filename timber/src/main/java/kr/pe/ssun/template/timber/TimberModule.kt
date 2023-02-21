package kr.pe.ssun.template.timber

import timber.log.Timber

object TimberModule {

    fun initialize() {
        Timber.plant(Timber.DebugTree())
    }
}