package com.kenkorcak.registrationformapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.kenkorcak.registrationformapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupSpinner()
        setupButton()


    }

    private fun setupSpinner() {
        val titles = arrayOf("Miss", "Mrs", "Ms", "Mr", "Mx", "Dr", "Prof")
        val titleAdaper = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, titles)
        binding.spinnerTitle.adapter = titleAdaper
    }

    private fun setupButton() {
        binding.buttonCreateAccount.setOnClickListener {
            createAccount()
        }
    }

    private fun createAccount() {
        val user = User(
            binding.spinnerTitle.selectedItem as String,
            binding.editTextFirstName.text.toString(),
            binding.editTextLastName.text.toString(),
            binding.editTextEmail.text.toString(),
            binding.editTextPhoneNumber.text.toString(),
            binding.editTextPassword.text.toString(),
        )
        val intent = Intent(this, SummaryActivity::class.java)
        intent.putExtra("User", user)
        startActivity(intent)

    }
}