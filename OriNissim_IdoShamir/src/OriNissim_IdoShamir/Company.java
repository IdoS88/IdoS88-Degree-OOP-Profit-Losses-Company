package OriNissim_IdoShamir;

import java.io.Serializable;
import java.util.ArrayList;

public class Company implements Serializable{
	private String name;
	private int totalProfit;
	// profit can be positive or negative
	private ArrayList<Department> allDepartments;
	private ArrayList<Employee> allEmployees;
	private ArrayList<Role> allRoles;

	public Company(String name) {
		this.name = name;
		this.allDepartments = new ArrayList<>();
		this.allEmployees = new ArrayList<>();
		this.allRoles = new ArrayList<>();
		this.totalProfit = 0;

		// set a new company
	}

	public boolean addEmployee(Employee e) {
		if (allEmployees.contains(e)) {
			return false;
			// checking if the employee is already on the list
		}
		allEmployees.add(e);
		return true;
		// if not, add it
	}

	public boolean addRole(Role role) {
		if (allRoles.contains(role)) {
			return false;
		} else {
			allRoles.add(role);
			return true;
		}

	}

	public boolean addDepartment(Department department) {
		if (allDepartments.contains(department)) {
			return false;
		} else {
			allDepartments.add(department);
			return true;
		}
	}

	public String getName() {
		return name;
	}

	public int gettotalProfit() {
		return totalProfit;
	}

	public ArrayList<Department> getAllDepartments() {
		return allDepartments;
	}

	public ArrayList<Employee> getAllEmployees() {
		return allEmployees;
	}

	public ArrayList<Role> getAllRoles() {
		return allRoles;
	}

	public Role getSpecificRole(String roleName) {
		for (Role r : allRoles) {
			if (r.getRoleName().equalsIgnoreCase(roleName)) {
				return r;
			}
		}
		return null;
	}

	public Department getSpecificDepartment(String departmentName) {
		for (Department d : allDepartments) {
			if (d.getDepartmentName().equalsIgnoreCase(departmentName)) {
				return d;
			}
		}
		return null;
	}

	public boolean addRoleToDepartment(Role r, Department d) {
		for (int i = 0; i < allDepartments.size(); i++) {
			if (d.getDepartmentName().equalsIgnoreCase(allDepartments.get(i).getDepartmentName())) {
				allDepartments.get(i).addRole(r);
				return true;
			}
		}
		return false;
	}

	public boolean addEmployeeToRole(Role r, Employee e) {
		for (int i = 0; i < allRoles.size(); i++) {
			if (r.getRoleName().equalsIgnoreCase(allRoles.get(i).getRoleName())) {
				allRoles.get(i).addEmployee(e);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Department d : allDepartments) {
			sb.append(d.toString());
		}

		return sb.toString();
	}

	public double profitPerCompany() {
		double profit = 0;
		for (Employee emp : allEmployees)
			profit += emp.profitPerEmployee();
		return profit;
	}
}
