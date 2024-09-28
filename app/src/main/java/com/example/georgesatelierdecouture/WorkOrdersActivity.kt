package com.example.georgesatelierdecouture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class WorkOrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_orders)

        val orderNameEditText = findViewById<EditText>(R.id.editText_order_name)
        val orderDeadlineEditText = findViewById<EditText>(R.id.editText_order_deadline)
        val orderStatusEditText = findViewById<EditText>(R.id.editText_order_status)
        val saveOrderButton = findViewById<Button>(R.id.button_save_order)

        saveOrderButton.setOnClickListener {
            val orderName = orderNameEditText.text.toString()
            val orderDeadline = orderDeadlineEditText.text.toString()
            val orderStatus = orderStatusEditText.text.toString()

            if (orderName.isNotEmpty() && orderDeadline.isNotEmpty() && orderStatus.isNotEmpty()) {
                // Save the work order details to a database or shared preferences
                Toast.makeText(this, "Order saved", Toast.LENGTH_SHORT).show()
                // Optionally, clear the input fields
                orderNameEditText.text.clear()
                orderDeadlineEditText.text.clear()
                orderStatusEditText.text.clear()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
