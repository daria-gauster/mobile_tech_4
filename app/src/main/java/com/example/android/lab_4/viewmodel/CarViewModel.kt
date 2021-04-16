package com.example.android.lab_4.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.lab_4.data.Car
import com.example.android.lab_4.data.CarDataBase
import com.example.android.lab_4.repository.CarRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Car>>
    private val repository: CarRepository

    init {
        val carDao = CarDataBase.getDatabase(application, viewModelScope).carDao()
        repository = CarRepository(carDao)
        readAllData = repository.readAllData
    }

    fun addCar(car: Car) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.addCar(car)
        }
    }

    fun deleteAllCars(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCars()
        }
    }
}