package com.example.household_budgeting_app

import android.R
import android.app.Application
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.household_budgeting_app.databinding.FragmentNewOperationSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class OperationSheet(private var application: Application, private var operation: Operation?) : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNewOperationSheetBinding
    private lateinit var operationViewModel: OperationViewModel
    private val categoryViewModel: CategoryViewModel by viewModels {
        CategoryModelFactory((application as HouseholdBudgettingApplication).categoryRepository)
    }
    private val bankAccountViewModel: AccountViewModel by viewModels {
        BankAccountModelFactory((application as HouseholdBudgettingApplication).bankAccauntRepository)
    }
    private val categoryIds: ArrayList<Int> = ArrayList<Int>()
    private val bankAccountIds: ArrayList<Int> = ArrayList<Int>()
    private var categoryId: Int = 0
    private var bankAccountId: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (operation != null) {
            binding.newOperationTitle.text = "Edit Operation"
            val editable = Editable.Factory.getInstance()
            binding.desc.text = editable.newEditable(operation!!.desc.toString())
            binding.sum.text = editable.newEditable(operation!!.sum.toString())
            binding.count.text = editable.newEditable(operation!!.count.toString())
            categoryId = operation!!.categoryID
            bankAccountId = operation!!.bankAccauntID
        } else {
            binding.newOperationTitle.text = "New Operation"
        }

        operationViewModel = ViewModelProvider(activity).get(OperationViewModel::class.java)

        binding.categorySpinner.adapter = getCategorySpinnerAdapter(activity)
        binding.bankAccauntSpinner.adapter = getBanlAccountSpinnerAdapter(activity)

        binding.saveButton.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewOperationSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun getCategorySpinnerAdapter(activity: FragmentActivity): ArrayAdapter<String> {
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(activity, R.layout.simple_spinner_item, ArrayList<String>())
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        categoryViewModel.categoryItems.observe(this){
            var list = ArrayList<String>()
            if (it != null) {
                for (item in it) {
                    list.add(item.name)
                    categoryIds.add(item.id)
                }
            }
            Log.d("Category names", list.toString())
            Log.d("Category ids", categoryIds.toString())
            Log.d("Category id", categoryId.toString())
            adapter.apply {
                addAll(list)
                binding.categorySpinner.setSelection(categoryIds.indexOf(categoryId))
            }
        }
        return adapter
    }

    private fun getBanlAccountSpinnerAdapter(activity: FragmentActivity): ArrayAdapter<String> {
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(activity, R.layout.simple_spinner_item, ArrayList<String>())
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        bankAccountViewModel.accauntItems.observe(this){
            var list = ArrayList<String>()
            if (it != null) {
                for (item in it) {
                    list.add(item.name)
                    bankAccountIds.add(item.id)
                }
            }
            Log.d("Bank Account names", list.toString())
            Log.d("Bank Account ids", bankAccountIds.toString())
            Log.d("Bank Account id", bankAccountId.toString())
            adapter.apply {
                addAll(list)
                binding.bankAccauntSpinner.setSelection(bankAccountIds.indexOf(bankAccountId))
            }
        }
        return adapter
    }

    private fun saveAction() {
        if (!::operationViewModel.isInitialized) {
            return
        }
        val desc = binding.desc.text.toString()
        val sum = binding.sum.text.toString()
        val count = binding.count.text.toString()
        Log.d("Selected Category index", binding.categorySpinner.selectedItemPosition.toString())
        Log.d("Save Category ids", categoryIds.toString())
        Log.d("Selected Bank Account index", binding.bankAccauntSpinner.selectedItemPosition.toString())
        Log.d("Save Bank Account ids", bankAccountIds.toString())
        val newCategoryID = categoryIds[binding.categorySpinner.selectedItemPosition]
        val newBankAccauntID = bankAccountIds[binding.bankAccauntSpinner.selectedItemPosition]
        Log.d("New Category id", newCategoryID.toString())
        Log.d("New Bank Account id", newBankAccauntID.toString())

        if (operation == null) {
            val newOperation = Operation(desc, sum.toInt(), count.toInt(), newCategoryID, newBankAccauntID)
            operationViewModel.addOperationItem(newOperation)
        } else {
            operation!!.desc = desc
            operation!!.sum = sum.toInt()
            operation!!.count = count.toInt()
            operation!!.categoryID = newCategoryID
            operation!!.bankAccauntID = newBankAccauntID

            operationViewModel.updateOperationItem(operation!!)
        }
        binding.desc.setText("")
        binding.sum.setText("")
        binding.count.setText("")
        dismiss()
    }
}
