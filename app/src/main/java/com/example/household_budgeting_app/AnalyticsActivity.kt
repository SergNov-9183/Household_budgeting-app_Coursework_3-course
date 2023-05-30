package com.example.household_budgeting_app

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.household_budgeting_app.databinding.ActivityAnalyticsBinding
import com.example.household_budgeting_app.databinding.ActivityOperationsBinding
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnalyticsBinding
    private var beginDate: Long = System.currentTimeMillis().minus(Duration.ofDays(1).toMillis()) / 1000;
    private var endDate: Long = System.currentTimeMillis() / 1000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnalyticsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.beginDateBtn.setOnClickListener {openBeginDatePicker() }
        binding.endDateBtn.setOnClickListener { openEndDatePicker() }

        setRecyclerView()
    }

    private fun openBeginDatePicker() {
        val date = LocalDateTime.ofEpochSecond(beginDate, 0, ZoneOffset.UTC);
        val listener = DatePickerDialog.OnDateSetListener{ _, year, month, day ->
            beginDate = LocalDateTime.of(year, month + 1, day, 0, 0).toEpochSecond(ZoneOffset.UTC)
            setRecyclerView()
        }
        val dialog = DatePickerDialog(this, listener, date.year, date.monthValue - 1, date.dayOfMonth)
        dialog.setTitle("Begin Date")
        dialog.show()
    }

    private fun openEndDatePicker() {
        val date = LocalDateTime.ofEpochSecond(endDate, 0, ZoneOffset.UTC);
        val listener = DatePickerDialog.OnDateSetListener{ _, year, month, day ->
            endDate = LocalDateTime.of(year, month + 1, day, 0, 0).toEpochSecond(ZoneOffset.UTC)
            setRecyclerView()
        }
        val dialog = DatePickerDialog(this, listener, date.year, date.monthValue - 1, date.dayOfMonth)
        dialog.setTitle("End Date")
        dialog.show()
    }

    private fun setRecyclerView()
    {
        val repository =AnalyticsRepository(HouseholdBudgettingDatabase.getDatabase(this).operationDao(), beginDate, endDate)
        repository.operationItems.asLiveData().observe(this){
            binding.operationsRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = AnalyticsAdapter(it)
            }
        }

    }
}