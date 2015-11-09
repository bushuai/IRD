package me.donkey.service.impl;

import java.util.List;

import me.donkey.dao.CarDao;
import me.donkey.dao.impl.CarDaoImpl;
import me.donkey.entity.Car;
import me.donkey.service.CarService;

public class CarServiceImpl implements CarService {

	CarDao carDao = new CarDaoImpl();

	public List<Car> getAllCars() {
		return carDao.getAllCars();

	}

	public boolean addCar(Car car) {
		return carDao.addCar(car);
	}

	public boolean removeCar(int id) {
		return carDao.removeCar(id);
	}

	public boolean updateCar(Car car) {
		return carDao.updateCar(car);
	}

	@Override
	public Car getCarById(int id) {
		// TODO Auto-generated method stub
		return carDao.getCarById(id);
	}
}
