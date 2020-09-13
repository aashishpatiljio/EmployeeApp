package in.nareshit.aashish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nareshit.aashish.model.Employee;
import in.nareshit.aashish.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService service; //HAS-A
	
	/**
	 * 1. show register page 
	 *    on enter  /register URL  (GET)
	 */
	@GetMapping("/register")
	public String showRegister() {
		return "EmployeeRegister";
	}
	
	/**
	 * 2. This method will read form data as ModelAttribute.
	 *    It performs save() operation using service and returns generated ID.
	 *    Construct one message and send to UI using Model memory.
	 *    On entering URL: /save with Type : POST
	 */
	//@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String saveEmployee(
			@ModelAttribute Employee employee,
			Model model
			) {
		Integer id = service.saveEmployee(employee);
		//String message = "Employee '"+id+"' Saved";
		//String message = String.format("Employee '%d' Saved", id);
		String message = new StringBuffer()
				.append("Employee '").append(id).append("' Saved")
				.toString();
		model.addAttribute("msg", message);
		return "EmployeeRegister";
	}
	/**
	 * 3. This method gets data from database using service 
	 * 	  and send to UI using model. It is called when 
	 *    Path: /all with type GET is requested.
	 * @param model is used to send data from controller to UI.
	 * @return the page i.e. EmployeeData
	 */
	@GetMapping("/all")
	public String showAll(Model model) {
		//fetching data from service
		List<Employee> list = service.getAllEmployees();
		//sending to UI
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	

}
