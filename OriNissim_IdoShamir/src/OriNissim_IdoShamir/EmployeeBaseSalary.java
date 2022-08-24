package OriNissim_IdoShamir;

public class EmployeeBaseSalary extends Employee{

	public EmployeeBaseSalary(String name, int id, int age, String role, String department, int baseSalary, int startingHour, String workType) {
		super(name, id, age, role,department , baseSalary, startingHour,workType);
	}
	

	@Override
	public int getSalary() {
		return this.getBaseSalary();
	}


	@Override
	protected String getPaymentMethod() {
		return "Base salary";
	}



}
