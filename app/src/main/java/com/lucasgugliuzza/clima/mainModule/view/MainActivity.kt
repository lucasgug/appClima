package com.lucasgugliuzza.clima.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.lucasgugliuzza.clima.BR
import com.lucasgugliuzza.clima.R
import com.lucasgugliuzza.clima.common.entities.Forecast
import com.lucasgugliuzza.clima.common.utils.CommonUtils
import com.lucasgugliuzza.clima.databinding.ActivityMainBinding
import com.lucasgugliuzza.clima.mainModule.view.adapters.ForecastAdapter
import com.lucasgugliuzza.clima.mainModule.view.adapters.OnClickListener
import com.lucasgugliuzza.clima.mainModule.viewModel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : ForecastAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this , R.layout.activity_main)


        setupViewModel()
        setupObservers()

        setupAdapter()
        setupRecyclerView()


    }


    private fun setupViewModel() {
        val vm : MainViewModel  by viewModels()
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel ,vm)

    }


    private fun setupObservers() {
        binding.viewModel?.let {
            it.getSnackMsg().observe(this){resMg ->
                Snackbar.make(binding.root,resMg,Snackbar.LENGTH_LONG).show()

            }
            it.getResult().observe(this){result ->
                adapter.submitList(result.hourly)
            }
        }

    }

    private fun setupAdapter(){
        adapter =  ForecastAdapter(this)

    }
    private fun setupRecyclerView(){
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch{
            binding.viewModel?.getWeatherAndForecast(41.461619, 14.724515 ,"6a5c325c9265883997730d09be2328e8","hourly" ,"metric","en" )
        }
    }

    //OnclickListener
    override fun onClick(forecast: Forecast) {
        Snackbar.make(binding.root, CommonUtils.getFullDate(forecast.dt) , Snackbar.LENGTH_SHORT).show()
    }


}