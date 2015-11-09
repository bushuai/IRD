package me.donkey.test;

import me.donkey.entity.Car;
import me.donkey.service.impl.CarServiceImpl;

public class CarDaoTest {
	public static void main(String[] args) {
		CarServiceImpl cs = new CarServiceImpl();
		
		//add
	Car car = new Car();
//		car.setRoomId(1006);
//		car.setCustomerId(1002);
//		car.setCar_position_num("gsls_C_0939");
		
		//delete
	
		
		//update
		
		
//		cs.addCar(car)
//		cs.removeCar(1000)
		
		
//		cs.update(car)
//		
//		car = new Car();
//		car.setRoomId(10011);
//		car.setCustomerId(1003);
//		car.setCar_position_num("new_position");
//		car.setId(1003);
//		
	
	System.out.println(cs.getCarById(1001));
//		if (cs.updateCar(car))
//			System.out.println("success");
//		else
//			System.out.println("failed");
//	}
	}
}
