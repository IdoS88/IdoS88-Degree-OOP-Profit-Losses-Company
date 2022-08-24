package OriNissim_IdoShamir;

import java.io.Serializable;
import java.util.ArrayList;

public class Department implements ChangableWorkType, Synchronizable,Serializable {

	private String departmentName;
	private ArrayList<Role> allRoles;
	private boolean isSynchronizable;
	private boolean isChangeable;
	private int startingHour;
	// department fields

	public Department(String departmentName) {
		this.departmentName = departmentName;
		this.allRoles = new ArrayList<>();
		this.isSynchronizable = false;
		this.isChangeable = false;
		this.startingHour = 8;
		// set up a new department
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Department))
			return false;
		Department temp = (Department) obj;
		return this.departmentName.equalsIgnoreCase(temp.departmentName);
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public ArrayList<Role> getAllRoles() {
		return allRoles;
	}

	@Override
	public void synchronizeStartingHour() {
		if (this.isSynchronizable)
			for (Role r : allRoles) {
				r.changeStartingHour(this.startingHour);
			}
	}

	@Override
	public void changeWorkType(String workType, int staringHour) {
		if (this.isChangeable)
			for (Role r : allRoles) {
				r.changeWorkType(workType, staringHour);
			}

	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n Department: " + departmentName + " is it changeable? " + this.isChangeable
				+ " is it synchronizable? " + this.isSynchronizable + " ,hour: " + startingHour);
		for (Role r : allRoles) {
			sb.append("\n" + r.toString());
		}
		return sb.toString();
	}

	public boolean addRole(Role role) {
		for (Role r1 : allRoles) {
			if (r1.equals(role))
				return false;
		}
		return allRoles.add(role);
	}

	@Override
	public boolean isSynchronizable() {

		return isSynchronizable;
	}

	@Override
	public boolean setSynchronizable(boolean b) {
		this.isSynchronizable = b;
		return isSynchronizable;
	}

	@Override
	public void setChangeable(boolean choice) {
		this.isChangeable = choice;

	}

	@Override
	public boolean isChangeable() {
		return isChangeable;
	}

	@Override
	public void setStartingHour(int startingHour) {
		this.startingHour = startingHour;

	}

	@Override
	public int getStartingHour() {
		return this.startingHour;
	}

	@Override
	public void changeStartingHour(int startingHour) {
		if (this.isChangeable)
			for (Role r : allRoles) {
				r.changeStartingHour(startingHour);
			}

	}

	public double profitPerDepartment() {
		double profit = 0;
		for (int i = 0; i < allRoles.size(); i++) {
			for (int j = 0; j < allRoles.get(i).getAllEmployees().size(); j++) {
				profit += allRoles.get(i).getAllEmployees().get(j).profitPerEmployee();
			}
		}
		return profit;
	}

}
