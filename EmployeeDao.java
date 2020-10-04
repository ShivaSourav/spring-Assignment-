package com.SpringExample1mainexample.demo.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SpringExample1mainexample.demo.Repository.EmployeeInterface_Repository;
import com.SpringExample1mainexample.demo.module.Department;
import com.SpringExample1mainexample.demo.module.Employee;
import com.SpringExample1mainexample.demo.module.EmployeeDTO;
@Repository
public class EmployeeDao implements EmployeeInterface_Repository{
		 
			@Autowired
			private JdbcTemplate jdbcTemplate;
			@Override
			public List<Employee> getAllEmployees() {
				String sql="select * from springex1_emp";
				List<Employee>list=jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employee.class));
				return list;
				
			}
			public List<String> getDept() {
				String sql="select dname from springex1_dept";
				List<String>list=jdbcTemplate.queryForList(sql, String.class);
				return list;
				
			}
			
			
		public int getIdByName(String name)
		{
			String sql="select id from springex1_dept where dname='"+name+"'";
			return jdbcTemplate.queryForObject(sql, Integer.class);
			
		}
			
			@Override
			public String insertData(Employee emp)
			{
				String dept_name=emp.getDept().getDname();
				List<String> checkdept=getDept();
				if(!checkdept.contains(dept_name))
				{
					String sql="insert into springex1_dept values(1,?)";
					jdbcTemplate.update(sql,dept_name);
				}
				String sql="insert into springex1_emp values(?,?,?,?)";
				jdbcTemplate.update(sql,new Object[] {emp.getId(),emp.getName(),emp.getLocation(),getIdByName(dept_name)});
				return "Employee saved";
			}
			
			@Override
			public int deleteEmployees(int id){    
			    String sql="delete from springex1_emp where id="+id+"";    
			    return jdbcTemplate.update(sql);  }

			@Override
			public void updateEmp(EmployeeDTO empdto) {
				String sql="update springex1_emp set location=? where id=?";
				jdbcTemplate.update(sql, new Object[] {empdto.getLocation(),empdto.getId()});
				
			}

			@Override
			public List<Map<String, Object>> getCombinedData() {
				String sql="select a.id,a.name,a.location,b.dname from springex1_emp a,springex1_dept b where a.deptid=b.id";
				List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
				return list;
			}

			

			
}

//@Override
//public void insertEmployees(int id, String name, String location) {
//	// TODO Auto-generated method stub
//	Object[]obj=new Object[] {id,name,location};
//	List<Object[]>list=new ArrayList<>();
//	list.add(obj);
//	String sql="insert into springex1_emp values(?,?,?)";
//	jdbcTemplate.batchUpdate(sql,list);
//}


//@Override
//public String updateEmployeesById(String name, Integer id) {
//	String sql="update springex1_emp set name=? where id=?";
//	jdbcTemplate.update(sql,new Object[] {name,id});
//	return "update Successfull";
//}

