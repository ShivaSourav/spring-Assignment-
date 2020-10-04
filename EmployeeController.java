package com.SpringExample1mainexample.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringExample1mainexample.demo.Dao.EmployeeDao;
import com.SpringExample1mainexample.demo.module.Department;
import com.SpringExample1mainexample.demo.module.Employee;
import com.SpringExample1mainexample.demo.module.EmployeeDTO;
@RestController
public class EmployeeController {

	@Autowired
	 private EmployeeDao employeeDao;
	
	
	@GetMapping(value="/getData")
	public List<Employee> getEmployeeData()
	   {
		List<Employee>list=employeeDao.getAllEmployees();
		return list ;
		
		
}
 @GetMapping(value="/getDeptNames")
 public List<String> getDeptData()
 {
	 List<String> list=employeeDao.getDept();
	return list;
 }
	
	@PostMapping(value="/insertData")
	public String insertData(@RequestBody Employee emp)
	{
		return employeeDao.insertData(emp);
		 
	}
	
	
	
	@RequestMapping(value="/deleteData/{id}",method = RequestMethod.GET)    
    public String deleteEmp(@PathVariable int id){    
        employeeDao.deleteEmployees(id);   
        return "you have deleted "+id; }
	

	
	
	
	
	@PutMapping(value="/updateData")
	public String update(@RequestBody EmployeeDTO empdto)
	{
		employeeDao.updateEmp(empdto);
		return "updated successfully";
		
	}
	@GetMapping(value="/joinData")
	public List<Map<String,Object>>getJoinData()
	{
		return employeeDao.getCombinedData();
	}
	
	
	
	@PostMapping(value="getName")
	public String disp(@RequestParam("name")String name)
	{
		return name;
		
	}
	
	
}

//@GetMapping("/insertData/{id}/{name}/{location}")
//public String insertdata(@PathVariable Integer id,@PathVariable String name,@PathVariable String location)
//{
//	employeeDao.insertEmployees(id, name, location);
//	return "You have inserted "+id;
//}

//@PutMapping(value="/updatename/{name}/{id}")
//public String updateEmp(@PathVariable String name,@PathVariable Integer id)
//{
//	return employeeDao.updateEmployeesById(name, id);
//}