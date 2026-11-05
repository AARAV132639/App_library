package com.example.a02_to_do_list_app.reminder

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

object IncompleteTaskReminderScheduler {
    const val UNIQUE_WORK_NAME = "incomplete_tasks_reminder"

    fun schedule(context: Context) {
        val request = PeriodicWorkRequestBuilder<IncompleteTasksWorker>(2, TimeUnit.HOURS)
            .build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            UNIQUE_WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            request,
        )
    }
}
