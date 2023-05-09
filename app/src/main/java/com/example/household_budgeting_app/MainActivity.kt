package com.example.household_budgeting_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.household_budgeting_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BankAccountClickListener
{
    private lateinit var binding: ActivityMainBinding
    private val accountViewModel: AccountViewModel by viewModels {
        BankAccountModelFactory((application as HouseholdBudgettingApplication).repository)
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