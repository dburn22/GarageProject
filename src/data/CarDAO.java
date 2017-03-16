package data;

public interface CarDAO {
	public Car getCarByModel(String model);

	public Car getCarBymake(String make);

	public void addCar(Car car);

	public Car getColor(String color);
}
