package com.example.georgesatelierdecouture

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val reminderName = intent.getStringExtra("reminderName")
        Toast.makeText(context, "Reminder: $reminderName", Toast.LENGTH_LONG).show()

        // Here you could trigger a notification instead of a Toast, for a more robust reminder system
    }
}
