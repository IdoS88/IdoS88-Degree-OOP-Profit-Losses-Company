package OriNissim_IdoShamir;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Platform;

public class CompanyController {

	// TODO tomorrow :
	// fix problem of labels added twice
	// check edge-scenarios
	// check everything works according to the exercise request
	// employees wont add to list after loading from file

	Company c;
	View v;

	public static void saveToFile(Company c) throws IOException, FileNotFoundException {
		ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("Company.dat"));
		outFile.writeObject(c);
		outFile.close();

	}

	public static Company loadFromFile() throws IOException, FileNotFoundException, ClassNotFoundException {
		ObjectInputStream inFile = new ObjectInputStream(new FileInputStream("Company.dat"));
		Company c = (Company) inFile.readObject();
		inFile.close();
		return c;

	}

	public CompanyController(Company company, View theView) {
		this.v = theView;
		try {
			c = loadFromFile();
			updateEmployeeList();
			updateComboBoxes();
			v.showAlert("Data loaded from existing file");

		} catch (Exception e) {
			this.c = company;
			v.showAlert("No file found, enter data ");
		}

		v.saveAndExit(e -> {
			try {
				saveToFile(c);
				v.showAlert("Saved succefully!");
				Platform.exit();
			} catch (Exception e2) {
				v.showAlert("An error accured, file did not save");
			}

		});

		v.addEmployee(e -> {
			try {

				String id2 = v.getID();
				validInputID(id2);
				// check id is valid
				int id = Integer.parseInt(id2);
				// convert id from string to id
				String name = v.getName();
				validInputName(name);
				// check if name is valid
				String age2 = v.getAge();
				validInputAge(age2);
				// check age is valid
				int age = Integer.parseInt(age2);
				// convert age from string to id
				String baseSalary2 = v.getBaseSalary();
				validInputSalary(baseSalary2);
				// check salary is valid
				int baseSalary = Integer.parseInt(baseSalary2);
				int startingHour;

				String role = v.getRole();
				String department = v.getDepartment();
				// get working type
				String workType = "Normal";
				if (v.rbPreferenceEarly.isSelected()) {
					workType = "Start early";
				} else if (v.rbPreferenceHome.isSelected()) {
					workType = "Work from home";
				} else if (v.rbPreferenceLater.isSelected()) {
					workType = "Start later";
				}

				if (v.rbPreferenceEarly.isSelected() || v.rbPreferenceLater.isSelected()) {
					String startingHour2 = v.getStartingHour();
					validInputStartingHour(startingHour2);

					startingHour = Integer.parseInt(startingHour2);
					// change starting hour if "later" or "early" radio buttons are selected
				} else {
					startingHour = 8;
					// if not, keep it at 08:00
				}

				checkDepartmentRole(c.getSpecificDepartment(department), c.getSpecificRole(role));

				if (v.rbSalaryBasic.isSelected()) {
					if (!c.addEmployee(new EmployeeBaseSalary(name, id, age, role, department, baseSalary, startingHour,
							workType))) {
						v.showAlert("This employee already exists!");
						// send message to the user if employee is already on the list
					} else {
						c.addEmployeeToRole(c.getSpecificRole(role), new EmployeeBaseSalary(name, id, age, role,
								department, baseSalary, startingHour, workType));
						c.addRoleToDepartment(c.getSpecificRole(role), c.getSpecificDepartment(department));
						System.out.println(c.toString());
						v.showAlert("Employee added successfully!");
						v.addEmployeeList(name, id, age, "Base salary", baseSalary, 0, role, department, startingHour,
								workType);
					}

					// if employee is paid by base salary only
				} else if (v.rbSalarybyHour.isSelected()) {
					if (!c.addEmployee(new EmployeeByHourSalary(name, id, age, role, department, baseSalary,
							startingHour, workType))) {
						v.showAlert("This employee already exists!");

					} else {
						// paid by the hour so multiply by 160 - working hours per month
						v.addEmployeeList(name, id, age, "Paid by the hour", baseSalary * 160, 0, role, department,
								startingHour, workType);
						c.addEmployeeToRole(c.getSpecificRole(role), new EmployeeByHourSalary(name, id, age, role,
								department, baseSalary, startingHour, workType));
						c.addRoleToDepartment(c.getSpecificRole(role), c.getSpecificDepartment(department));
						System.out.println(c.toString());
						v.showAlert("Employee added successfully!");

					}
					// if employee is paid by the hour salary
				} else {
					String percentageOfSales2 = v.getPercentageOfSales();
					validInputSalary(percentageOfSales2);
					// check if sales bonus is valid
					int percentageOfSales = Integer.parseInt(percentageOfSales2);
					if (!c.addEmployee(new EmployeeSalesSalary(name, id, age, role, department, baseSalary,
							percentageOfSales, startingHour, workType))) {
						v.showAlert("This employee already exists!");
					} else {
						c.addEmployeeToRole(c.getSpecificRole(role), new EmployeeSalesSalary(name, id, age, role,
								department, baseSalary, percentageOfSales, startingHour, workType));
						c.addRoleToDepartment(c.getSpecificRole(role), c.getSpecificDepartment(department));
						System.out.println(c.toString());
						v.addEmployeeList(name, id, age, "Sales + bonus salary", baseSalary, percentageOfSales, role,
								department, startingHour, workType);
						v.showAlert("Employee added successfully!");

					}
					// last option - employee is paid by sales and a base salary
				}

				// possible text fields exception handling:
			} catch (IDException e2) {
				v.showAlert("Id must contains numbers only and length of 9 digits");
			} catch (NameException e3) {
				v.showAlert("Name must contains letters only and can't be blank");
			} catch (AgeException e4) {
				v.showAlert("Age must contains numbers only and must be above 16");
			} catch (SalaryException e5) {
				v.showAlert("Salary must contains numbers only and must be positive");
			} catch (StartingHourException e6) {
				v.showAlert("new starting hour must be between 00 - 24");
			} catch (ChangeUnchangeableException e8) {
				v.showAlert(
						"there is a contradiction with department and role properties. please enter a role and department of the same worktype and starting hour");
			}

		});
		for (int i = 0; i < c.getAllRoles().size(); i++) {
			v.addRolesList(c.getAllRoles().get(i).getRoleName(), 8);

		}
		v.addRole(e -> {
			String roleName = v.getRoleName();
			try {
				validInputName(roleName);
				Role r = new Role(roleName);
				r.setChangeable(v.isRoleChangeable());
				if (roleName != "" && c.addRole(r)) {
					v.addRoleToComboBox(roleName);
					v.addRolesList(roleName, 8);
					v.showAlert("Role added successfully!");
					// add role to company array list and combo box
					System.out.println(r.toString());
				} else {
					v.showAlert("This role already exists!");
				}
			} catch (NameException e1) {
				v.showAlert("must contain letters only");
			}

		});
		for (int i = 0; i < c.getAllDepartments().size(); i++) {
			v.addDepartmentsList(c.getAllDepartments().get(i).getDepartmentName(), 8);

		}
		v.addDepartment(e -> {
			String DepartmentName = v.getDepartmentName();
			try {
				validInputName(DepartmentName);
				Department d = new Department(DepartmentName);
				d.setChangeable(v.isDepartmentChangeable());
				d.setSynchronizable(v.isDepartmentSynchronizable());
				if (DepartmentName != "" && c.addDepartment(d)) {
					v.addDepartmentToComboBox(DepartmentName);
					v.addDepartmentsList(DepartmentName, 8);
					System.out.println(d.toString());
					v.showAlert("Department added successfully!");
					// add Department to company array list
				} else {
					v.showAlert("This Department already exists!");
				}

			} catch (NameException e1) {
				v.showAlert("must contain letters only");
			}
		});

		v.changeWorkTypeDepartment(e -> {
			try {
				String departmentName = v.getDepartmentToChangeWorkType();
				if (c.getSpecificDepartment(departmentName).isChangeable()) {
					int startingHour = 8;
					String workType = "Normal";
					// get working type

					if (v.rbPreferenceEarlyD.isSelected()) {
						String startingHour2 = v.getNewStartingHourForDepartment();
						validInputStartingHour(startingHour2);
						startingHour = Integer.parseInt(startingHour2);
						workType = "Start early";

					} else if (v.rbPreferenceHomeD.isSelected()) {
						workType = "Work from home";

					} else if (v.rbPreferenceLaterD.isSelected()) {
						String startingHour2 = v.getNewStartingHourForDepartment();
						validInputStartingHour(startingHour2);
						startingHour = Integer.parseInt(startingHour2);
						workType = "Start later";
					}
					for (int i = 0; i < c.getAllDepartments().size(); i++) {
						if (c.getAllDepartments().get(i).getDepartmentName().equals(departmentName)) {
							c.getAllDepartments().get(i).changeWorkType(workType, startingHour);
							c.getAllDepartments().get(i).setStartingHour(startingHour);
						}
						for (int j = 0; j < c.getAllDepartments().get(i).getAllRoles().size(); j++) {
							for (int k = 0; k < c.getAllRoles().size(); k++) {
								if (c.getAllDepartments().get(i).getAllRoles().get(j).equals(c.getAllRoles().get(k))) {
									c.getAllRoles().get(k).changeWorkType(workType, startingHour);
									c.getAllRoles().get(k).setStartingHour(startingHour);
								}
							}
						}

					}
					for (int k = 0; k < c.getAllEmployees().size(); k++) {
						if (c.getAllEmployees().get(k).getDepartment().equalsIgnoreCase(departmentName)) {
							c.getAllEmployees().get(k).setManagerDecision(workType, startingHour);
						}
					}

					System.out.println(c.toString());

					// updates employees list
					v.removeEmployeeList();
					updateEmployeeList();

					//updates roles list
					v.removeRolesList();
					updateRolesList();
					// updates departments list
					v.removeDepartmentsList();
					updateDepartmentsList();
				} else
					v.showAlert("this department cannot be changed");
			} catch (StartingHourException e2) {
				v.showAlert("New starting hour must be between 0 - 24");
			}
		});
		v.changeWorkTypeRole(e ->

		{
			try {
				String roleName = v.getRoleToChangeWorkType();
				if (c.getSpecificRole(roleName).isChangeable()) {
					int startingHour = 8;
					String workType = "Normal";
					// get working type

					if (v.rbPreferenceEarlyR.isSelected()) {
						String startingHour2 = v.getNewStartingHourForRoles();
						validInputStartingHour(startingHour2);
						startingHour = Integer.parseInt(startingHour2);
						workType = "Start early";

					} else if (v.rbPreferenceHomeR.isSelected()) {
						workType = "Work from home";

					} else if (v.rbPreferenceLaterR.isSelected()) {
						String startingHour2 = v.getNewStartingHourForRoles();
						validInputStartingHour(startingHour2);
						startingHour = Integer.parseInt(startingHour2);
						workType = "Start later";
					}
					for (int i = 0; i < c.getAllDepartments().size(); i++) {
						for (int j = 0; j < c.getAllDepartments().get(i).getAllRoles().size(); j++) {
							if (c.getAllDepartments().get(i).getAllRoles().get(j).getRoleName()
									.equalsIgnoreCase(roleName)) {
								c.getAllDepartments().get(i).getAllRoles().get(j).changeWorkType(workType,
										startingHour);
								c.getAllDepartments().get(i).getAllRoles().get(j).setStartingHour(startingHour);

							}
						}
					}
					for (int k = 0; k < c.getAllEmployees().size(); k++) {
						if (c.getAllEmployees().get(k).getRole().equalsIgnoreCase(roleName)) {
							c.getAllEmployees().get(k).setManagerDecision(workType, startingHour);

						}
					}
					for (int i = 0; i < c.getAllRoles().size(); i++) {
						if (c.getAllRoles().get(i).getRoleName().equalsIgnoreCase(roleName))
							c.getAllRoles().get(i).changeWorkType(workType, startingHour);
						c.getAllRoles().get(i).setStartingHour(startingHour);

					}

					System.out.println(c.toString());

					// updates employees list
					v.removeEmployeeList();
					updateEmployeeList();

					// updates roles list
					v.removeRolesList();
					updateRolesList();

				} else
					v.showAlert("this role cannot be changed");
			} catch (StartingHourException e2) {
				v.showAlert("Insert numbers only");
			}
		});
		v.CalculateProfits(e -> {
			try {
				validInputSalary(v.getProfitPerWorkerPerHour());
				v.removePreviousProfits();
				double profitPerHour = Double.parseDouble(v.getProfitPerWorkerPerHour());
				for (Employee emp : c.getAllEmployees()) {
					v.addProfitToEmployeeProfitList(emp.getName(), emp.profitPerEmployee() * profitPerHour);
				}
				v.addProfitToCompanyList(c.profitPerCompany() * profitPerHour);

				for (Department d : c.getAllDepartments()) {
					v.addProfitToDepartmentsList(d.getDepartmentName(), d.profitPerDepartment() * profitPerHour);
				}

			} catch (SalaryException e1) {
				v.showAlert("must contains numbers only");
			}
		});

	}

	private void updateComboBoxes() {
		for (Role r : c.getAllRoles()) {
			v.addRoleToComboBox(r.getRoleName());
		}

		for (Department d : c.getAllDepartments()) {
			v.addDepartmentToComboBox(d.getDepartmentName());
		}

	}

	private void updateRolesList() {
		for (Role r : c.getAllRoles())
			v.addRolesList(r.getRoleName(), r.getStartingHour());

	}

	private void updateDepartmentsList() {
		for (Department d : c.getAllDepartments())
			v.addDepartmentsList(d.getDepartmentName(), d.getStartingHour());

	}

	private void checkDepartmentRole(Department d, Role r) throws ChangeUnchangeableException {
		if (d.isChangeable() && r.isChangeable()) {
			if (d.isSynchronizable())
				if (d.getStartingHour() != r.getStartingHour()) {
					r.setStartingHour(d.getStartingHour());
					v.removeRolesList();
					updateRolesList();
				}
			if (d.isSynchronizable() && d.isChangeable() && !r.isChangeable())
				throw new ChangeUnchangeableException();
		} else if ((!d.isChangeable() && r.isChangeable()) || (d.isChangeable() && !r.isChangeable()))
			throw new ChangeUnchangeableException();
	}

	private void validInputStartingHour(String startingHour2) throws StartingHourException {
		if (!startingHour2.matches("[0-9]+")) {
			throw new StartingHourException();
		} else if (Integer.parseInt(startingHour2) <= 0 || Integer.parseInt(startingHour2) >= 24) {
			throw new StartingHourException();
		}

	}

	private void validInputSalary(String salary) throws SalaryException {
		if (!salary.matches("[0-9]+")) {
			throw new SalaryException();
		} else if (Integer.parseInt(salary) < 0)
			throw new SalaryException();

	}

	private void validInputAge(String age) throws AgeException {
		if (!age.matches("[0-9]+")) {
			throw new AgeException();
		} else if (Integer.parseInt(age) < 16 || Integer.parseInt(age) > 80)
			throw new AgeException();

	}

	private void validInputName(String name) throws NameException {
		if (name.length() == 0 && !name.contains("[a-zA-Z]+"))
			throw new NameException();

	}

	public void validInputID(String id) throws IDException {
		if (id.length() != 9 || !id.matches("[0-9]+")) {
			throw new IDException();
		}

	}

	public void updateEmployeeList() {
		for (int i = 0; i < c.getAllEmployees().size(); i++) {
			String paymentMethod = c.getAllEmployees().get(i).getPaymentMethod();
			if (c.getAllEmployees().get(i) instanceof EmployeeSalesSalary) {
				v.addEmployeeList(c.getAllEmployees().get(i).getName(), c.getAllEmployees().get(i).getId(),
						c.getAllEmployees().get(i).getAge(), paymentMethod, c.getAllEmployees().get(i).getBaseSalary(),
						((EmployeeSalesSalary) c.getAllEmployees().get(i)).getPercentageOfSales(),
						c.getAllEmployees().get(i).getRole(), c.getAllEmployees().get(i).getDepartment(),
						c.getAllEmployees().get(i).getPreference().getStartHour(),
						c.getAllEmployees().get(i).getPreference().getWorktype());
			} else {
				v.addEmployeeList(c.getAllEmployees().get(i).getName(), c.getAllEmployees().get(i).getId(),
						c.getAllEmployees().get(i).getAge(), paymentMethod, c.getAllEmployees().get(i).getBaseSalary(),
						0, c.getAllEmployees().get(i).getRole(), c.getAllEmployees().get(i).getDepartment(),
						c.getAllEmployees().get(i).getPreference().getStartHour(),
						c.getAllEmployees().get(i).getPreference().getWorktype());
			}
		}

	}

}
