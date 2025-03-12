package com.minimalistlauncher.data

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val PREFS_NAME = "MinimalistLauncherPrefs"
    private const val KEY_ESSENTIAL_APPS = "essential_apps"

    fun getEssentialApps(context: Context): List<String> {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getStringSet(KEY_ESSENTIAL_APPS, emptySet())?.toList() ?: emptyList()
    }

    fun setEssentialApps(context: Context, apps: List<String>) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putStringSet(KEY_ESSENTIAL_APPS, apps.toSet()).apply()
    }
}
