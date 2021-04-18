package com.example.android.lab_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.lab_4.data.Car
import com.example.android.lab_4.model.CarAdapter
import com.example.android.lab_4.viewmodel.CarViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var carViewModel: CarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //RecyclerViewer
        val adapter = CarAdapter()
        val rvCars: RecyclerView = findViewById(R.id.rvCars)
        rvCars.apply{
            this.adapter = adapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }


        //UserViewModel
        carViewModel = ViewModelProvider(this).get(CarViewModel::class.java)
        carViewModel.readAllData.observe(this, Observer {car ->
            adapter.setData(car)
        })

    }

}