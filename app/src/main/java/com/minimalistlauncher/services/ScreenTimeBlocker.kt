package com.minimalistlauncher.services

import android.app.usage.UsageStatsManager
import android.content.Context

object ScreenTimeBlocker {
    fun isAppBlocked(context: Context, packageName: String): Boolean {
        val usageStatsManager = context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
        val endTime = System.currentTimeMillis()
        val startTime = endTime - (24 * 60 * 60 * 1000)

        val stats = usageStatsManager.queryAndAggregateUsageStats(startTime, endTime)
        val totalTime = stats[packageName]?.totalTimeInForeground ?: 0L

        return totalTime > 60 * 60 * 1000  // Block if used over 1 hour
    }
}
