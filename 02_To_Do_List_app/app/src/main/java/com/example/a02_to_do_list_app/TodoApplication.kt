package com.example.a02_to_do_list_app

import android.app.Application
import com.example.a02_to_do_list_app.reminder.IncompleteTaskReminderScheduler
import com.example.a02_to_do_list_app.reminder.TaskNotifications

class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        TaskNotifications.createChannel(this)
        IncompleteTaskReminderScheduler.schedule(this)
    }
}
