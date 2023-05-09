package com.example.household_budgeting_app

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: CategoryRepository): ViewModel()
{
    val categoryItems: LiveData<List<Category>> = repository.allCategoryItems.asLiveData()

    fun addCategoryItem(category: Category) = viewModelScope.launch {
        repository.insertCategoryItem(category)
    }

    fun updateCategoryItem(category: Category) = viewModelScope.launch {
        repository.updateCategory(category)
    }
}

class CategoryModelFactory(private val repository: CategoryRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java))
            return CategoryViewModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}