package com.example.household_budgeting_app

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class OperationViewModel(private val repository: OperationRepository): ViewModel()
{
    val operationItems: LiveData<List<Operation>> = repository.allOperationItems.asLiveData()

    fun addOperationItem(operation: Operation) = viewModelScope.launch {
        repository.insertOperationItem(operation)
    }

    fun updateOperationItem(operation: Operation) = viewModelScope.launch {
        repository.updateOperation(operation)
    }
}

class OperationModelFactory(private val repository: OperationRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(OperationViewModel::class.java))
            return OperationViewModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}