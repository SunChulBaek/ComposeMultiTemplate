package kr.pe.ssun.template.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataStore @Inject constructor(
    val pref: DataStore<Preferences>
) {
    companion object {
        val PHOTO_IDS = stringPreferencesKey("photo_ids")
    }

    val bookmarks = pref.data
        .map {
            (it[PHOTO_IDS] ?: "").split(",").mapNotNull { it.toIntOrNull() }
        }

    suspend fun toggle(id: Int): Boolean {
        pref.edit {
            val old = (it[PHOTO_IDS] ?: "").split(",").mapNotNull { it.toIntOrNull() }
            if (!old.contains(id)) {
                it[PHOTO_IDS] = old.plus(id).fold("") { acc, x -> "$acc,$x"}
            } else {
                it[PHOTO_IDS] = old.filterNot { it == id }.fold("") { acc, x -> "$acc,$x"}
            }
        }
        return true
    }
}