package OriNissim_IdoShamir;

import java.io.Serializable;
import java.util.ArrayList;

public class Role implements ChangableWorkType,Serializable {
	private String roleName;
	private ArrayList<Employee> allEmployees;
	private boolean isSynchronizable;
	private boolean isChangeable;
	private int startingHour;
	// role fields

	public Role(String roleName) {
		this.roleName = roleName;
		this.allEmployees = new ArrayList<>();
		this.isSynchronizable = false;
		this.isChangeable = false;
		this.startingHour = 8;
		// set up a new role
	}

	public boolean addEmployee(Employee e1) {
		for (Employee e : allEmployees) {
			if (e.equals(e1))
				return false;
		}
		return allEmployees.add(e1);
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Role))
			return false;
		Role temp = (Role) obj;
		return this.roleName.equalsIgnoreCase(temp.roleName);

	}

	public String getRoleName() {
		return roleName;
	}

	public ArrayList<Employee> getAllEmployees() {
		return allEmployees;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n Role: " + roleName + "is synchronized? "+ isSynchronizable + " is changeable? "+isChangeable);
		for (Employee e : allEmployees) {
			sb.append("\n" + e.toString());
		}
		return sb.toString();
	}

	@Override
	public void changeWorkType(String type, int startingHour) {
		for (Employee e : allEmployees) {
			e.setManagerDecision(type, startingHour);
		}

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
	public void changeStartingHour(int startingHour) {
		for (Employee e : allEmployees) {
			e.setManagerDecision(e.getManagerDecision().getWorkType(), startingHour);
		}
		
	}

	public int getStartingHour() {
		return startingHour;
	}

	public void setStartingHour(int startingHour2) {
		this.startingHour = startingHour2;
	}
}

