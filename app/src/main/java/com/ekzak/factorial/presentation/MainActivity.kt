package com.ekzak.factorial.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ekzak.factorial.R
import com.ekzak.factorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::bind)
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setObservers()
        binding.calculate.setOnClickListener {
            viewModel.calculate(binding.number.text.toString())
        }
    }

    private fun setObservers() {
        viewModel.observeError(this) { isError ->
            if (isError) {
                Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.observeProgress(this) { isProgress ->
            binding.progress.visibility = if (isProgress) View.VISIBLE else View.GONE
        }
        viewModel.observeResult(this) { result ->
            binding.result.text = result
        }
    }
}
