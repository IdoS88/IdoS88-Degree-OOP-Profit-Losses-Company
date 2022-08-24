package OriNissim_IdoShamir;

public class EmployeeSalesSalary extends Employee{

	int percentageOfSales;
	
	public EmployeeSalesSalary(String name, int id, int age, String role, String department, int salary, int percentageOfSales, int startingHour, String workType) {
		super(name, id, age, role, department, salary, startingHour, workType);
		this.percentageOfSales = percentageOfSales;
	}

	@Override
	public int getSalary() {
		return this.getBaseSalary() + percentageOfSales;
	}

	public int getPercentageOfSales() {
		return percentageOfSales;
	}

	@Override
	protected String getPaymentMethod() {
		return "Sales + bonus salary";
	}

	

	
}
