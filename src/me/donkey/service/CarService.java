package me.donkey.service;

import java.util.List;

import me.donkey.entity.Car;

public interface CarService {
	public List<Car> getAllCars();

	public boolean addCar(Car car);

	public boolean removeCar(int id);

	public boolean updateCar(Car car);

	public Car getCarById(int id);
}
