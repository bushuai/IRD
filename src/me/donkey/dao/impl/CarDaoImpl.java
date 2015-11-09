package me.donkey.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.donkey.dao.CarDao;
import me.donkey.entity.Car;
import me.donkey.util.DBUtil;

public class CarDaoImpl implements CarDao {
	DBUtil db = new DBUtil();

	public List<Car> getAllCars() {
		try {
			String sql = "select * from car";

			ResultSet resultSet = db.executeQuery(sql, null);
			List<Car> cars = new ArrayList();
			while (resultSet.next()) {
				Car car = new Car();
				car.setCar_position_num(resultSet.getString("car_position_num"));
				car.setId(resultSet.getInt("id"));
				car.setCustomerId(resultSet.getInt("customer_id"));
				car.setRoomId(resultSet.getInt("room_id"));
				cars.add(car);
			}
			return cars;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean addCar(Car car) {
		String sql = "insert into car(room_id,customer_id,car_position_num) values("
				+ car.getRoomId()
				+ ","
				+ car.getCustomerId()
				+ ",'"
				+ car.getCar_position_num() + "')";
		return (db.query(sql, null)) == 0 ? false : true;
	}

	public boolean removeCar(int id) {
		String sql = "delete from car where id  = " + id;
		return (db.query(sql, null)) == 0 ? false : true;
	}

	public boolean updateCar(Car car) {
		String sql = "update car set room_id = " + car.getRoomId()
				+ ",customer_id=" + car.getCustomerId() + ",car_position_num='"
				+ car.getCar_position_num() + "' where id=" + car.getId();
		return (db.query(sql, null)) == 0 ? false : true;
	}

	@Override
	public Car getCarById(int id) {
		String sql = "select * from car where id = " + id;
		ResultSet resultSet = db.executeQuery(sql, null);
		Car car = new Car();
		try {
			if (resultSet.next()) {
				car.setCar_position_num(resultSet.getString("car_position_num"));
				car.setId(resultSet.getInt("id"));
				car.setCustomerId(resultSet.getInt("customer_id"));
				car.setRoomId(resultSet.getInt("room_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;

	}
}
