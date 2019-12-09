package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //create/declare an instant of view model
    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialise ViewModel
        viewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        //add observer
        viewModel.counter.observe(this, Observer<Int>{
            if(viewModel.counter.value == 10) endGame()
        })

        buttonPlus.setOnClickListener{
            viewModel.increment()
            textViewCounter.text = viewModel.counter.value.toString()
        }

        buttonMinus.setOnClickListener{
            viewModel.decrement()
            textViewCounter.text = viewModel.counter.value.toString()
        }

    }

    private fun endGame(){
        Toast.makeText(applicationContext, "Counter == 10", Toast.LENGTH_LONG).show()
    }
}
