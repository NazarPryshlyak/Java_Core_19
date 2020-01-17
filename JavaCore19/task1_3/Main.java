package JavaCore19.task1_3;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File fileEmployee = new File("Employee.obj");
		Employee employee = new Employee(23, "Вася", 7500);
		System.out.println("Наш робітник:");
		System.out.println(employee);
		
		System.out.println("Робітник після сереалізації / десереалізації:");
		Methods.serialize(employee, fileEmployee);
		System.out.println(Methods.desealize(fileEmployee));
		
		System.out.println();
		
		File fileEmployeeList = new File("EmployeeList.obj");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		employeeList.add(new Employee(50,"Іван", 9000));
		employeeList.add(new Employee(68,"Тарас", 28000));
		employeeList.add(new Employee(40,"Олег", 10000));
		employeeList.add(new Employee(30,"Дмитро", 5000));
		employeeList.add(new Employee(43,"Таня", 11000));
		employeeList.add(new Employee(48,"Наталя", 20000));
		
		System.out.println("Список робітників:");
		for (Employee eachEmployee : employeeList) {
			System.out.println(eachEmployee);
		}
		
		System.out.println();
		Methods.serialize((Serializable) employeeList, fileEmployeeList);
		
		List<Employee> employeeListDeserialized = new ArrayList<Employee>();
		employeeListDeserialized = (List<Employee>) Methods.desealize(fileEmployeeList);
		
		for (Employee eachEmployee : employeeListDeserialized) {
			System.out.println(eachEmployee);
		}
	}
}
