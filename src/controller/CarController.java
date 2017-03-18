package controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.Car;
import data.CarDAO;

@Controller
@SessionAttributes({"currentList"})
public class CarController {
	@Autowired
	private CarDAO carDao;
	
	@ModelAttribute("currentList")
	public ArrayList<Car> currentList(){
		return new ArrayList<Car>();
	}

	// @RequestMapping(path = "GetCarData.do", params = "name", method =
	// RequestMethod.GET)
	// public ModelAndView getByName(@RequestParam("make") String m) {
	// ModelAndView mv = new ModelAndView();
	// mv.setViewName("result.jsp");
	// mv.addObject("cars", carDao.getCarByModel(m));
	// return mv;
	// }

	@RequestMapping(path = "GetCarData.do", params = "make", method = RequestMethod.GET)
	public ModelAndView getCarNum(@RequestParam("make") String a) {
		ModelAndView mv = new ModelAndView();
		// if(make ! make){
		System.out.println("*********" + a);
		mv.setViewName("result.jsp");
		mv.addObject("cars", carDao.getCarByMake(a));
		mv.getModelMap().addAttribute("currentList", carDao.getCarByMake(a));
		mv.addObject("index", 0);

		return mv;
	}
	
	@RequestMapping(path = "GetCarData.do", params = "next", method = RequestMethod.GET)
	public ModelAndView getNextCarIndex(@ModelAttribute("currentList") ArrayList<Car> list, @RequestParam("next") int a) {
		ModelAndView mv = new ModelAndView();
		// if(make ! make){
		mv.setViewName("result.jsp");
		mv.addObject("index", carDao.getNextIndex(a, list));
		
		return mv;
	}
	@RequestMapping(path = "GetCarData.do", params = "back", method = RequestMethod.GET)
	public ModelAndView getPreviousCarIndex(@ModelAttribute("currentList") ArrayList<Car> list, @RequestParam("back") int a) {
		ModelAndView mv = new ModelAndView();
		// if(make ! make){
		mv.setViewName("result.jsp");
		mv.addObject("index", carDao.getPreviousIndex(a, list));
		
		return mv;
	}
	
	

	@RequestMapping(path = "GetCarData.do", method = RequestMethod.GET)
	public ModelAndView getAllCars() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("garage.jsp");
		mv.addObject("carList", carDao.getCars());
		return mv;
	}

	@RequestMapping(path = "newCar.do", method = RequestMethod.GET)
	public ModelAndView newCar(Car car) {
		System.out.println(car);
		car.setCarNum(carDao.getCars().size()+1);
		carDao.addCar(car);
		ModelAndView mv = new ModelAndView();
		mv.addObject("carList", carDao.getCars());
		mv.setViewName("garage.jsp");
		return mv;
	}
	
	@RequestMapping(path = "DeleteCar.do", method = RequestMethod.GET)
	public ModelAndView deleteCar(@RequestParam("name") int carNum) {
		System.out.println(carNum);
		carDao.removeCar(carNum);
		ModelAndView mv = new ModelAndView();
		mv.addObject("carList", carDao.getCars());
		mv.setViewName("garage.jsp");
		return mv;
	}
}
