package com.example.georgesatelierdecouture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerManagementActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_management)

        db = AppDatabase.getDatabase(this)

        val nameEditText = findViewById<EditText>(R.id.editText_name)
        val phoneEditText = findViewById<EditText>(R.id.editText_phone)
        val addressEditText = findViewById<EditText>(R.id.editText_address)
        val measurementsEditText = findViewById<EditText>(R.id.editText_measurements)
        val saveButton = findViewById<Button>(R.id.button_save_customer)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val address = addressEditText.text.toString()
            val measurements = measurementsEditText.text.toString()

            if (name.isNotEmpty() && phone.isNotEmpty()) {
                val customer = Customer(name = name, phone = phone, address = address, measurements = measurements)
                CoroutineScope(Dispatchers.IO).launch {
                    db.customerDao().insertCustomer(customer)
                }
                Toast.makeText(this, "Customer saved", Toast.LENGTH_SHORT).show()
                nameEditText.text.clear()
                phoneEditText.text.clear()
                addressEditText.text.clear()
                measurementsEditText.text.clear()
            } else {
                Toast.makeText(this, "Please enter name and phone number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
