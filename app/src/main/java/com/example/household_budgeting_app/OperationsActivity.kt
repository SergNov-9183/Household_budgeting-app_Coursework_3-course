package com.example.household_budgeting_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.household_budgeting_app.databinding.ActivityCategoriesBinding
import com.example.household_budgeting_app.databinding.ActivityOperationsBinding

class OperationsActivity : AppCompatActivity(), OperationClickListener
{
    private lateinit var binding: ActivityOperationsBinding
    private val operationViewModel: OperationViewModel by viewModels {
        OperationModelFactory((application as HouseholdBudgettingApplication).operationRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityOperationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newOperationButton.setOnClickListener {
            OperationSheet(application, null).show(supportFragmentManager, "newOperationTag")
        }
        setRecyclerView()
    }

    private fun setRecyclerView()
    {
        val mainActivity = this
        operationViewModel.operationItems.observe(this){
            binding.operationsRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = OperationAdapter(it, mainActivity)
            }
        }
    }

    override fun editOperationItem(operation: Operation)
    {
        OperationSheet(application, operation).show(supportFragmentManager,"newEditOperationTag")
    }
}