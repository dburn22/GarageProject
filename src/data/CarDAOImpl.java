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
		System.out.println(make);
		for (Car car : cars) {
			System.out.println(car);
			if (car.getMake().equalsIgnoreCase(make)) {
				
				c.add(car);
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
//	@Override
//    public void removeCar(String name) {
//        int index = 0;
//            for (Car car2 : cars) {
//                if(car2.getMake().equals(name)){
//                    index = cars.indexOf(car2);
//                    break;
//                }
//            }
//        cars.remove(index);
//    }

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
		if (car.getPicture().equals("gwagon.jpg")) {
			car.setColor("black");
		} else if (car.getPicture().equals("gt3.jpg")) {
			car.setColor("white");
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
	public Car deleteCar(String picture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCar(String name) {
		// TODO Auto-generated method stub
		
	}

}
