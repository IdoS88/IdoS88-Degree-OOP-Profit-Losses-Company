package OriNissim_IdoShamir;

public class EmployeeByHourSalary extends Employee {

	public EmployeeByHourSalary(String name, int id, int age, String role, String department, int baseSalary, int startingHour, String workType) {
		super(name, id, age, role,department, baseSalary,startingHour,workType);

	}

	@Override
	public int getSalary() {
		return this.getBaseSalary() * HOURS_PER_MONTH;
		// paid by the hour, 160 hours per month
	}

	@Override
	protected String getPaymentMethod() {
		return "Paid by the hour";
	}
	
}
