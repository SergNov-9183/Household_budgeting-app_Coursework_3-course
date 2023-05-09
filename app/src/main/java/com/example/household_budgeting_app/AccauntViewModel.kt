package com.example.household_budgeting_app

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class AccountViewModel(private val repository: BankAccountRepository): ViewModel()
{
    val accauntItems: LiveData<List<BankAccount>> = repository.allAccauntItems.asLiveData()

    fun addAccauntItem(bankAccount: BankAccount) = viewModelScope.launch {
        repository.insertAccauntItem(bankAccount)
    }

    fun updateAccauntItem(bankAccount: BankAccount) = viewModelScope.launch {
        repository.updateBankAccount(bankAccount)
    }
}

class BankAccountModelFactory(private val repository: BankAccountRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(AccountViewModel::class.java))
            return AccountViewModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}