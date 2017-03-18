package data;

import java.util.ArrayList;
import java.util.List;

public interface CarDAO {
	public Car getCarByModel(String model);

	public List<Car> getCarByMake(String make);

	public void addCar(Car car);

	public Car getColor(String color);

	public Car getWhp(String whp);
	
	public Car getCarNum(int carNum);

	public Car getTopSpeed(String topSpeed);
	
	public Car getPicture(String picture);
	public Car editCar(String picture);
	public void removeCar(int carNum);
	

	public List<Car> getCars();

	int getPreviousIndex(int currentIndex, ArrayList<Car> currentList);

	int getNextIndex(int currentIndex, ArrayList<Car> currentList);


	public void deleteCar(Car car);

}
