package com.example.android.lab_4.repository

import androidx.lifecycle.LiveData
import com.example.android.lab_4.data.Car
import com.example.android.lab_4.data.CarDao

class CarRepository(private val carDao: CarDao) {
    val readAllData: LiveData<List<Car>> = carDao.readAllData()

    suspend fun addCar(car: Car) {
        carDao.addCar(car)
    }

    suspend fun deleteAllCars() {
        carDao.deleteAllCars()
    }
}