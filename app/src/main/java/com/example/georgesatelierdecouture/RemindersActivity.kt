package com.example.georgesatelierdecouture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.Calendar

class RemindersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminders)

        val reminderNameEditText = findViewById<EditText>(R.id.editText_reminder_name)
        val reminderTimeEditText = findViewById<EditText>(R.id.editText_reminder_time)
        val setReminderButton = findViewById<Button>(R.id.button_set_reminder)

        setReminderButton.setOnClickListener {
            val reminderName = reminderNameEditText.text.toString()
            val reminderTime = reminderTimeEditText.text.toString()

            if (reminderName.isNotEmpty() && reminderTime.isNotEmpty()) {
                setReminder(reminderName, reminderTime)
                Toast.makeText(this, "Reminder set", Toast.LENGTH_SHORT).show()
                reminderNameEditText.text.clear()
                reminderTimeEditText.text.clear()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setReminder(reminderName: String, reminderTime: String) {
        val calendar = Calendar.getInstance().apply {
            // Assuming reminderTime is in "HH:mm" format
            val timeParts = reminderTime.split(":")
            set(Calendar.HOUR_OF_DAY, timeParts[0].toInt())
            set(Calendar.MINUTE, timeParts[1].toInt())
            set(Calendar.SECOND, 0)
        }

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, ReminderReceiver::class.java).apply {
            putExtra("reminderName", reminderName)
        }
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }
}
