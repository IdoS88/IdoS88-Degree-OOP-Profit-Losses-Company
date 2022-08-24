package OriNissim_IdoShamir;

import java.io.Serializable;

public abstract class Employee implements Serializable{
	private String name;
	private int id;
	private int age;
	private String role;
	private String department;
	private Preference preference;
	private ManagerDecision managerDecision;
	private int baseSalary;
	public final int HOURS_PER_MONTH = 160;
	public final int HOURS_PER_DAY = 8;
	public final double PROFIT_PER_HOUR = 0.2;
	public final double PROFIT_FROM_HOME = 0.1;
	// employee fields

	public Employee(String name, int id, int age, String role, String department, int baseSalary, int startingHour,
			String workType) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.role = role;
		this.department = department;
		this.baseSalary = baseSalary;
		this.preference = new Preference(workType, startingHour);
		this.managerDecision = new ManagerDecision();
		// set up a new employee
	}

	public abstract int getSalary();

	public int getId() {
		return id;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public String getDepartment() {
		return this.department;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Employee))
			return false;
		Employee temp = (Employee) obj;
		return this.id == temp.getId();
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", age=" + age + ", role=" + role + ", Preference: workType= "
				+ this.preference.getWorktype() + ", startingHour= " + this.preference.getStartHour() + ", baseSalary="
				+ baseSalary + " Manager-Decision: workType= " + this.managerDecision.getWorkType() + ", start Hour="
				+ this.managerDecision.getStartHour() + "]";
	}

	protected abstract String getPaymentMethod();

	public double profitPerEmployee() {
		
		int preferenceHours = Math.abs(8 - preference.getStartHour());
		int difference = Math.abs(managerDecision.getStartHour() - preference.getStartHour());
		if (preference.getWorktype().equalsIgnoreCase(managerDecision.getWorkType())
				&& preference.getWorktype().equalsIgnoreCase("work from home")) {
			return PROFIT_FROM_HOME * (HOURS_PER_DAY);
		} else if (preference.getWorktype().equalsIgnoreCase("work from home")
				&& !preference.getWorktype().equalsIgnoreCase(managerDecision.getWorkType()))
			return -PROFIT_FROM_HOME * (HOURS_PER_DAY);
		else if (managerDecision.getStartHour() == preference.getStartHour()) {
			return preferenceHours * (PROFIT_PER_HOUR);
		} else
			return difference * (-PROFIT_PER_HOUR);

	}

	public Preference getPreference() {
		return preference;
	}

	public void setPreference(String workType, int startHour) {
		this.preference.setWorktype(workType);
		this.preference.setStartHour(startHour);
	}

	public ManagerDecision getManagerDecision() {
		return managerDecision;
	}

	public void setManagerDecision(String workType, int startHour) {
		this.managerDecision.setWorkType(workType);
		this.managerDecision.setStartHour(startHour);
	}
}
