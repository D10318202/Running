package com.springboot.running;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private CarDao carDao;
	
	public Person current;
	
	@RequestMapping("/")
	public String hello() {
		return "Hello! My name is Daren. 今晩は、紫です。よろしくお願いします。";
	}
	
	@RequestMapping("/start")
	public String hello2() {
		return "Nice to meet you.";
	}
	
	@RequestMapping("/insert")
	public String insert() {
		
//		Person person = new Person();
//		person.setFirstName("儂安");
//		person.setLastName("張");
//		personDao.save(person);
		
		return "new a data.";
	}
	
	@RequestMapping("/show")
	public String show() {
		List<Car> carList = carDao.findAll();
		StringBuilder sb = new StringBuilder();
		for(Car car : carList) {
			sb.append(String.format("%d: %s, %s <br>", car.getId(), car.getCarType(), car.getOwner().getFirstName()));
		}
			return sb.toString();
	}
	
	@RequestMapping("/show2")
	public int show2() {

		List<Person> personList = personDao.findByFirstName("韋豪");
		return personList.size();
	}
	
	@RequestMapping("/dataSize")
	public String dataSize() {
		
		Person person = new Person();
		person.setFirstName("韋豪");
		person.setLastName("葉");
		personDao.save(person);
		
		Car car = new Car();
		car.setCarType("BZ");
		car.setOwner(person);
		car.setCreateDatetime(LocalDateTime.now());
		carDao.save(car);

		person = new Person();
		person.setFirstName("丞邑");
		person.setLastName("徐");
		personDao.save(person);
		
		car = new Car();
		car.setCarType("ToyoTa");
		car.setOwner(person);
		car.setCreateDatetime(LocalDateTime.now());
		carDao.save(car);
		
		person = new Person();
		person.setFirstName("盛烽");
		person.setLastName("洪");
		personDao.save(person);
		
		person = new Person();
		person.setFirstName("宜謙");
		person.setLastName("陳");
		personDao.save(person);
		
		//Car car = carDao.findAll().get(0);
		
		return String.format("Save(%s)", personDao.count());
	}
	
	@GetMapping("/test/{username}")
	public String getPerson(@PathVariable("username") String name) {
		return name;
	}
	
	@GetMapping("/active")
	public String getValue(@RequestParam(value="name", defaultValue = "Nothing") String name) {
		return name;
	}
	
	@GetMapping("/activeTest")
	public String getValue2(@RequestParam("name") String name) {
		return name;
	}
	
	@GetMapping(value = {"/","/login"})
	public String loginPage(Model model) {
		model.addAttribute("message", "Hello! My name is Daren.");
		return "daren";
	}
	
		
	@GetMapping("/daren")
	//public String show3(Model model, @RequestParam(value="serialNo", defaultValue = "ff8080818282fa06018282fb0ce00000") String serialNo) {
	public String show3(Model model) {
		HashMap<String, String> mapList = new HashMap<>();
		mapList.put("good", "1234567890ABCDEFG");
		mapList.put("Name", "名前");
		mapList.put("Name.Help", "名前を表示してください。");
		
		mapList.put("show", "12345678901234567890");
		
		model.addAttribute("label", mapList);
		return "daren";
	}
	
	@PostMapping("/login2")
	public String login() {
		return "redirect:/daren.html";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save(@RequestParam(value = "firstname", required = true) String firstName, 
			           @RequestParam(value = "lastname", defaultValue = "doNothing", required = false) String lastName) {
	
		if(!lastName.equals("doNothing")) {
			Person person = new Person();
			person.setFirstName(firstName);
			person.setLastName(lastName);
			personDao.save(person);
		}
		
		return String.format("[%s, %s] を新規しました。データベースの数は%d%n",lastName, firstName, personDao.count());
	}
	

}
