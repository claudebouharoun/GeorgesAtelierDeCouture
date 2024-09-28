package com.example.georgesatelierdecouture

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CustomerDao {
    @Insert
    suspend fun insertCustomer(customer: Customer)

    @Query("SELECT * FROM customers")
    suspend fun getAllCustomers(): List<Customer>
}
