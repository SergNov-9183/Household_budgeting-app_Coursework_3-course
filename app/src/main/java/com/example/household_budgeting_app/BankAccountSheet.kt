package com.example.household_budgeting_app

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.household_budgeting_app.databinding.FragmentNewBankAccountSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BankAccountSheet(var bankAccount: BankAccount?) : BottomSheetDialogFragment()
{
    private lateinit var binding: FragmentNewBankAccountSheetBinding
    private lateinit var bankAccountViewModel: AccountViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (bankAccount != null)
        {
            binding.newBankAccountTitle.text = "Edit Bank Account"
            val editable = Editable.Factory.getInstance()
            binding.name.text = editable.newEditable(bankAccount!!.name)
            binding.desc.text = editable.newEditable(bankAccount!!.desc)
            binding.moneyAmount.text = editable.newEditable(bankAccount!!.moneyAmount.toString())
        }
        else
        {
            binding.newBankAccountTitle.text = "New Bank Account"
        }

        bankAccountViewModel = ViewModelProvider(activity).get(AccountViewModel::class.java)
        binding.saveButton.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewBankAccountSheetBinding.inflate(inflater,container,false)
        return binding.root
    }


    private fun saveAction()
    {
        val name = binding.name.text.toString()
        val desc = binding.desc.text.toString()
        val moneyAmount= binding.moneyAmount.text.toString()
        if(bankAccount == null)
        {
            val newAccaunt = BankAccount(name, desc, moneyAmount.toInt())
            bankAccountViewModel.addAccauntItem(newAccaunt)
        }
        else
        {
            bankAccount!!.name = name
            bankAccount!!.desc = desc
            bankAccount!!.moneyAmount = moneyAmount.toInt()

            bankAccountViewModel.updateAccauntItem(bankAccount!!)
        }
        binding.name.setText("")
        binding.desc.setText("")
        dismiss()
    }

}