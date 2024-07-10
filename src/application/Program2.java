package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("\n=== Test 1: department insert ===");
		Department newDepartment =  new Department(null, "Garden");
		//departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n=== Test 2: department update ===");
		Department dep2 = departmentDao.findById(6);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("\n=== Test 3: department findById ===");
		Department dep = departmentDao.findById(7);
		System.out.println(dep);
		
		System.out.println("\n=== Test 4: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 5: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = input.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
	}

}
