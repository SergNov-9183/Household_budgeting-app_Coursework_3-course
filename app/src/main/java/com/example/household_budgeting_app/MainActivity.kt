package com.example.household_budgeting_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.household_budgeting_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BankAccountClickListener
{
    var moveToCategoriesButton: Button? = null
    var moveToOperationsButton: Button? = null
    var moveToAnalyticsButton: Button? = null
    private lateinit var binding: ActivityMainBinding
    private val accountViewModel: AccountViewModel by viewModels {
        BankAccountModelFactory((application as HouseholdBudgettingApplication).bankAccauntRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newBankAccountButton.setOnClickListener {
            BankAccountSheet(null).show(supportFragmentManager, "newAccauntTag")
        }
        setRecyclerView()

        moveToCategoriesButton = findViewById<Button>(R.id.move_to_categories_btn)
        moveToCategoriesButton?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, CategoriesActivity::class.java)
            startActivity(intent)
        })

        moveToOperationsButton = findViewById<Button>(R.id.move_to_operations_btn)
        moveToOperationsButton?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, OperationsActivity::class.java)
            startActivity(intent)
        })

        moveToAnalyticsButton = findViewById<Button>(R.id.see_analiytics_btn)
        moveToAnalyticsButton?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, AnalyticsActivity::class.java)
            startActivity(intent)
        })
    }

    private fun setRecyclerView()
    {
        val mainActivity = this
        accountViewModel.accauntItems.observe(this){
            binding.bankAccountsRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = BankAccountAdapter(it, mainActivity)
            }
        }
    }

    override fun editBankAccountItem(bankAccount: BankAccount)
    {
        BankAccountSheet(bankAccount).show(supportFragmentManager,"newAccauntTag")
    }
}