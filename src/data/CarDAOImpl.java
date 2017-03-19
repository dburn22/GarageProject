package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class CarDAOImpl implements CarDAO {
	private static final String FILE_NAME = "/WEB-INF/garage.csv";
	private List<Car> cars = new ArrayList<>();

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(", *");
				int carNum = Integer.parseInt(tokens[0].trim());
				String make = tokens[1];
				String model = tokens[2];
				String whp = tokens[3];
				String torque = tokens[4];
				String topSpeed = tokens[5];
				String color = tokens[6];
				String picture = tokens[7];
				cars.add(new Car(make, model, whp, torque, topSpeed, color, picture, carNum));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public List<Car> getCarByMake(String make) {
		List<Car> c = new ArrayList<>();
		for (Car car : cars) {
			if (car.getMake().equalsIgnoreCase(make)) {
				//
				// c = car;
				c.add(car);
				System.out.println(car);
			}

		}
		return c;
	}

	@Override
	public int getNextIndex(int currentIndex, ArrayList<Car> currentList) {

		currentIndex++;
		if (currentIndex == currentList.size()) {
			currentIndex = 0;
		}
		return currentIndex;
	}

	@Override
	public int getPreviousIndex(int currentIndex, ArrayList<Car> currentList) {
		currentIndex--;
		if (currentIndex < 0) {
			currentIndex = currentList.size() - 1;
		}
		return currentIndex;
	}

	@Override
	public void addCar(Car car) {
		if (car.getPicture().equals("rs4.jpg")) {
			car.setMake("Audi");
			car.setModel("RS4");
			car.setWhp("whp");
			car.setTopSpeed("topSpeed");
			car.setColor("Grey");

		} else if (car.getPicture().equals("h1.jpg")) {
			car.setMake("Hummer");
			car.setModel("H1");
			car.setWhp("whp");
			car.setTopSpeed("topSpeed");
			car.setColor("Grey");
		} else if (car.getPicture().equals("918.jpg")) {
			car.setMake("Porsche");
			car.setModel("918 Spyder");
			car.setWhp("whp");
			car.setTopSpeed("topSpeed");
			car.setColor("Grey");

		}
		else if (car.getPicture().equals(null)) {
			System.out.println("Error. You have not selected a car.");
			
		}
		cars.add(car);
}

	@Override
	public Car getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getWhp(String whp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getTopSpeed(String topSpeed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getCars() {
		return cars;
	}

	@Override
	public Car getPicture(String picture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getCarByModel(String model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getCarNum(int carNum) {
		getCarByMake("make");
		return null;
	}

	@Override
	public Car editCar(String picture) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void removeCar(int carNum) {
		Car c = null;
		for (Car car : cars) {
				if(car.getCarNum()==carNum){
					c = car;
				}
		}
		cars.remove(c);
		
	}

	@Override
	public void deleteCar(Car car) {
		// TODO Auto-generated method stub
		
	}

}
