package com.example.household_budgeting_app

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.household_budgeting_app.databinding.FragmentNewCategorySheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CategorySheet(var category: Category?) : BottomSheetDialogFragment()
{
    private lateinit var binding: FragmentNewCategorySheetBinding
    private lateinit var categoryViewModel: CategoryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (category != null)
        {
            binding.newCategoryTitle.text = "Edit Category"
            val editable = Editable.Factory.getInstance()
            binding.newCategoryName.text = editable.newEditable(category!!.name)
            binding.newCategoryType.text = editable.newEditable(category!!.type)
        }
        else
        {
            binding.newCategoryTitle.text = "New Category"
        }

        categoryViewModel = ViewModelProvider(activity).get(CategoryViewModel::class.java)
        binding.saveButton.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewCategorySheetBinding.inflate(inflater,container,false)
        return binding.root
    }


    private fun saveAction()
    {
        val name = binding.newCategoryName.text.toString()
        val type = binding.newCategoryType.text.toString()
        if(category == null)
        {
            val newCategory = Category(name, type)

            categoryViewModel.addCategoryItem(newCategory)
        }
        else
        {
            category!!.name = name
            category!!.type = type

            categoryViewModel.updateCategoryItem(category!!)
        }
        binding.newCategoryName.setText("")
        binding.newCategoryType.setText("")
        dismiss()
    }

}