package kr.pe.ssun.template.core.datastore.di

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.userDataStore by preferencesDataStore(
    name = "kr.pe.ssun.template.core.datastore"
)

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    fun providePrefDataStore(
        @ApplicationContext applicationContext: Context
    ) = applicationContext.userDataStore
}