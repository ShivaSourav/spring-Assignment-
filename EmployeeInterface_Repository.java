package com.SpringExample1mainexample.demo.Repository;

import java.util.List;
import java.util.Map;

import com.SpringExample1mainexample.demo.module.Department;
import com.SpringExample1mainexample.demo.module.Employee;
import com.SpringExample1mainexample.demo.module.EmployeeDTO;

public interface EmployeeInterface_Repository {
	List<Employee> getAllEmployees();
	
   
	public String insertData(Employee emp);
    public int deleteEmployees(int id);
 
    public void updateEmp(EmployeeDTO empdto);
   List<Map<String,Object>> getCombinedData();
   
   
// public void insertEmployees(int id,String names,String location);
// public String updateEmployeesById(String name,Integer id);
	
	
}
