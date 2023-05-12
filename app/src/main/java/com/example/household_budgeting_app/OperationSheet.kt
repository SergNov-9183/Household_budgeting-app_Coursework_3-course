package com.example.household_budgeting_app

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.household_budgeting_app.databinding.FragmentNewOperationSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class OperationSheet(var operation: Operation?) : BottomSheetDialogFragment()
{
    private lateinit var binding: FragmentNewOperationSheetBinding
    private lateinit var operationViewModel: OperationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (operation != null)
        {
            binding.newOperationTitle.text = "Edit Operation"
            val editable = Editable.Factory.getInstance()
            binding.desc.text = editable.newEditable(operation!!.desc.toString())
            binding.sum.text = editable.newEditable(operation!!.sum.toString())
            binding.count.text = editable.newEditable(operation!!.count.toString())
            binding.categoryID.text = editable.newEditable(operation!!.categoryID.toString())
            binding.bankAccauntID.text = editable.newEditable(operation!!.bankAccauntID.toString())
        }
        else
        {
            binding.newOperationTitle.text = "New Operation"
        }

        operationViewModel = ViewModelProvider(activity).get(OperationViewModel::class.java)
        binding.saveButton.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewOperationSheetBinding.inflate(inflater,container,false)
        return binding.root
    }


    private fun saveAction()
    {
        if (!::operationViewModel.isInitialized) {
            return
        }
        val desc = binding.desc.text.toString()
        val sum = binding.sum.text.toString()
        val count= binding.count.text.toString()
        val categoryID = binding.categoryID.text.toString()
        val bankAccauntID= binding.bankAccauntID.text.toString()
        if(operation == null)
        {
            val newOperation = Operation( desc, sum.toInt(), count.toInt(), categoryID.toInt(), bankAccauntID.toInt())
            operationViewModel.addOperationItem(newOperation)
        }
        else
        {
            operation!!.desc = desc
            operation!!.sum = sum.toInt()
            operation!!.count = count.toInt()
            operation!!.categoryID = categoryID.toInt()
            operation!!.bankAccauntID = bankAccauntID.toInt()

            operationViewModel.updateOperationItem(operation!!)
        }
        binding.desc.setText("")
        binding.sum.setText("")
        binding.count.setText("")
        binding.categoryID.setText("")
        binding.bankAccauntID.setText("")
        dismiss()
    }

}