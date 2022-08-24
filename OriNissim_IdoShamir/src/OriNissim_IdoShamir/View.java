package OriNissim_IdoShamir;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
	// all tabs
	TabPane tPaneCompany = new TabPane();
	Tab tWelcomeTab = new Tab("System introduction");
	Tab tAddEmployee = new Tab("Add an employee");
	Tab tAddRole = new Tab("Add a role");
	Tab tAddDepartment = new Tab("Add a department");
	Tab tChangeWorkType = new Tab("Change work type");
	Tab tShowData = new Tab("Profits/losses");

	// introduction tab
	private BorderPane bpIntro = new BorderPane();
	private VBox vbIntro = new VBox(10);
	private Label introTitle = new Label("Welcome to company efficiency demonstration system");
	private Label msg = new Label(
			"The data input in this system is built to work in a specific way:\nFirst , enter roles and departments"
					+ " and then enter employees that are assigned to those roles and departments."
					+ "\nYou can change departments and roles setting even after you create them."
					+ "\nThe program referes to losses as negative profits."
					+ "\n\nTo save and exit the program, press the button below.");

	private Button btSaveAndExit = new Button("Save and exit");
	
	// add employee tab
	private BorderPane bpEmployee = new BorderPane();
	ToggleGroup radioButtonGroupPreferences = new ToggleGroup();
	private VBox vbEmployeeLeft = new VBox(10);
	private VBox vbEmployeeRight = new VBox(10);
	private Label EmployeeTitle = new Label("add an Employee");
	private Label lblSalaryAmount = new Label("Enter amount: ");
	private Button addEmployee = new Button("Add an Employee");
	private Label lblselectRole = new Label("Select role for the employee");
	ComboBox<String> cbSelectRole = new ComboBox<String>();
	private Label lblIdEmployee = new Label("Id (9 digits) ");
	private TextField tfIdEmployee = new TextField();
	private Label lblFirstNameEmployee = new Label("First Name ");
	private TextField tfFirstNameEmployee = new TextField();
	private Label lblEmployeePreferences = new Label("What is your work preference ? ");
	private HBox hPaneRadioButtonsPreferences = new HBox();
	public RadioButton rbPreferenceEarly = new RadioButton("Start early");
	public RadioButton rbPreferenceLater = new RadioButton("Start later");
	public RadioButton rbPreferenceNormal = new RadioButton("Start normal (08:00)");
	public RadioButton rbPreferenceHome = new RadioButton("Work from home");
	private Label lblStartHour = new Label("Enter new starting hour ");
	private TextField tfStartHour = new TextField();
	private Label lblAgeEmployee = new Label("How old is the employee? (16 - 80)");
	private TextField tfAgeEmployee = new TextField();
	private Label lblSalary = new Label("Salary payment method ");
	ToggleGroup radioButtonGroupSalary = new ToggleGroup();
	private HBox hPaneRadioButtonsSalary = new HBox();
	public RadioButton rbSalaryBasic = new RadioButton("Basic Salary");
	public RadioButton rbSalarybyHour = new RadioButton("Salary by the hour");
	public RadioButton rbSalarySales = new RadioButton("Basic Salary with sales bonus");
	private TextField tfSalary = new TextField();
	private Label lblSalesPercentage = new Label("Sales bonus ");
	private TextField tfSalesBonus = new TextField();
	private Label lblSelectDepartment = new Label("Select a department for the employee");
	private ComboBox<String> cbSelectDepartment = new ComboBox<String>();
	private Label lblEmployeeListTitle = new Label("current employees:");
	// add role tab
	private BorderPane bpRole = new BorderPane();
	private VBox vbRoleLeft = new VBox(10);
	private VBox vbRoleRight = new VBox(10);
	private Label roleTitle = new Label("add a role: ");
	private Label lblRoleName = new Label("Enter role name: ");
	private TextField tfRoleName = new TextField();
	private Button btAddRole = new Button("add Role");
	private Label lblRolesListTitle = new Label("current roles:");
	private CheckBox cbRoleChangeable = new CheckBox("is Role's starting hour Changeable?");

	// add Department tab
	private BorderPane bpDepartment = new BorderPane();
	private VBox vbDepartmentLeft = new VBox(10);
	private VBox vbDepartmentRight = new VBox(10);
	private Label DepartmentTitle = new Label("add a department: ");
	private Label lblDepartmentName = new Label("Enter department name: ");
	private TextField tfDepartmentName = new TextField();
	private Button btAddDepartment = new Button("add Department");
	private Label lblDepartmentListTitle = new Label("Current departments: ");
	private CheckBox cbDepartmentSynchronizable = new CheckBox("is Department's starting hour Synchronized?");
	private CheckBox cbDepartmentChangeable = new CheckBox("is Department's starting hour Changeable?");

	// change work type tab
	private BorderPane bpChangeWorkType = new BorderPane();
	private VBox vbChangeTypeDepartment = new VBox(30);
	private VBox vbChangeTypeRole = new VBox(30);
	private Label lblSelectDepartmentToChange = new Label("Select department:");
	private Label lblSelectRoleToChange = new Label("Select role:");
	private Label lblChangeEmployeesDeps = new Label("Change employees work type to:");
	private Label lblChangeEmployeesRoles = new Label("Change employees work type to:");

	// - change work type toggle groups for roles (R) and departments (D)
	ToggleGroup radioButtonGroupPreferencesD = new ToggleGroup();
	private HBox hPaneRadioButtonsPreferencesD = new HBox(5);
	public RadioButton rbPreferenceEarlyD = new RadioButton("Start early");
	public RadioButton rbPreferenceLaterD = new RadioButton("Start later");
	public RadioButton rbPreferenceNormalD = new RadioButton("Start normal (08:00)");
	public RadioButton rbPreferenceHomeD = new RadioButton("Work from home");

	ToggleGroup radioButtonGroupPreferencesR = new ToggleGroup();
	private HBox hPaneRadioButtonsPreferencesR = new HBox(5);
	public RadioButton rbPreferenceEarlyR = new RadioButton("Start early");
	public RadioButton rbPreferenceLaterR = new RadioButton("Start later");
	public RadioButton rbPreferenceNormalR = new RadioButton("Start normal (08:00)");
	public RadioButton rbPreferenceHomeR = new RadioButton("Work from home");

	private Label lblNewHourDepartment = new Label("Enter new starting hour:");
	private Label lblNewHourRoles = new Label("Enter new starting hour:");

	private TextField tfNewHourDepartments = new TextField();
	private TextField tfNewHourRoles = new TextField();

	private ComboBox<String> cbDepartments = new ComboBox<String>();
	private ComboBox<String> cbRoles = new ComboBox<String>();
	private Button btApplyChangeToRoles = new Button("Apply");
	private Button btApplyChangeToDepartments = new Button("Apply");

	// profits/losses tab:

	private GridPane gpProfits = new GridPane();
	private VBox vbEmployeeProfit = new VBox(10);
	private VBox vbDepartmentProfit = new VBox(10);
	private VBox vbTotalCompanyProfits = new VBox(10);
	private VBox vbProfitPerHourByUser = new VBox(10);
	private HBox hbProfits = new HBox(200);
	private Button btCalcProfits = new Button("Calculate profits");
	private Label lblProfitsTitle = new Label("Company profits/Losses");
	private Label lblEmployeeProfits = new Label("Profits \nper employee:");
	private Label lblDepartmentProfits = new Label("Profits \nper deprtment:");
	private Label lblCompanyProfits = new Label("Total \ncompany profits:");
	private Label lblEnterProfit = new Label("Enter profit \nper hour for each worker:");
	private TextField tfEnterProfit = new TextField();

	public View(Stage primaryStage) {
		
		

		// welcome tab setup

		bpIntro.setPadding(new Insets(30));
		introTitle.setStyle("-fx-font-family: TRON; -fx-font-size: 22; -fx-font-style: italic; -fx-font-weight:"
				+ " bold; -fx-border-color: red; -fx-border-width: 0 0 2 0;");
		msg.setPadding(new Insets(30));
		bpIntro.setTop(introTitle);
		msg.setStyle("-fx-font-family: TRON; -fx-font-size: 16; -fx-font-style: italic;");
		vbIntro.getChildren().add(msg);
		bpIntro.setBottom(btSaveAndExit);
		bpIntro.setLeft(vbIntro);
		tWelcomeTab.setContent(bpIntro);
		
		// add employee tab setup:
		bpEmployee.setPadding(new Insets(30));
		EmployeeTitle
				.setStyle("-fx-font-family: TRON; -fx-font-size: 16; -fx-font-style: italic; -fx-font-weight: bold;"
						+ " -fx-border-color: black; -fx-border-width: 0 0 2 0;");
		bpEmployee.setTop(EmployeeTitle);
		rbPreferenceEarly.setToggleGroup(radioButtonGroupPreferences);
		rbPreferenceLater.setToggleGroup(radioButtonGroupPreferences);
		rbPreferenceNormal.setToggleGroup(radioButtonGroupPreferences);
		rbPreferenceHome.setToggleGroup(radioButtonGroupPreferences);
		rbSalaryBasic.setToggleGroup(radioButtonGroupSalary);
		rbSalarybyHour.setToggleGroup(radioButtonGroupSalary);
		rbSalarySales.setToggleGroup(radioButtonGroupSalary);
		hPaneRadioButtonsSalary.getChildren().addAll(rbSalaryBasic, rbSalarybyHour, rbSalarySales);
		hPaneRadioButtonsPreferences.getChildren().addAll(rbPreferenceEarly, rbPreferenceLater, rbPreferenceNormal,
				rbPreferenceHome);

		tfAgeEmployee.setPromptText("age must be between 16 and 80");
		tfFirstNameEmployee.setPromptText("letters only");
		tfIdEmployee.setPromptText("numbers only and length of 9 digits");
		tfStartHour.setPromptText("Insert a number between 0 - 24 ..");
		tfSalary.setPromptText("Insert positive numbers only, 0 and higher");
		tfSalesBonus.setPromptText("Insert positive numbers only, 0 and higher");
		vbEmployeeLeft.getChildren().addAll(lblFirstNameEmployee, tfFirstNameEmployee, lblIdEmployee, tfIdEmployee,
				lblAgeEmployee, tfAgeEmployee, lblEmployeePreferences, hPaneRadioButtonsPreferences, lblStartHour,
				tfStartHour, lblSalary, hPaneRadioButtonsSalary, lblSalaryAmount, tfSalary, lblSalesPercentage,
				tfSalesBonus, lblselectRole, cbSelectRole, lblSelectDepartment, cbSelectDepartment, addEmployee);
		lblStartHour.setVisible(false);
		tfStartHour.setVisible(false);
		rbPreferenceEarly.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblStartHour.setVisible(rbPreferenceEarly.isSelected());
				tfStartHour.setVisible(rbPreferenceEarly.isSelected());

			}
		});
		rbPreferenceLater.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblStartHour.setVisible(rbPreferenceLater.isSelected());
				tfStartHour.setVisible(rbPreferenceLater.isSelected());

			}
		});
		rbPreferenceNormal.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblStartHour.setVisible(rbPreferenceEarly.isSelected());
				tfStartHour.setVisible(rbPreferenceEarly.isSelected());

			}
		});
		rbPreferenceHome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblStartHour.setVisible(rbPreferenceEarly.isSelected());
				tfStartHour.setVisible(rbPreferenceEarly.isSelected());

			}
		});
		// function for inserting label and text field according to user choice
		lblSalesPercentage.setVisible(false);
		tfSalesBonus.setVisible(false);
		rbSalarySales.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				lblSalesPercentage.setVisible(rbSalarySales.isSelected());
				tfSalesBonus.setVisible(rbSalarySales.isSelected());

			}
		});
		rbSalaryBasic.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				lblSalesPercentage.setVisible(rbSalarySales.isSelected());
				tfSalesBonus.setVisible(rbSalarySales.isSelected());

			}
		});
		rbSalarybyHour.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				lblSalesPercentage.setVisible(rbSalarySales.isSelected());
				tfSalesBonus.setVisible(rbSalarySales.isSelected());

			}
		});
		lblEmployeeListTitle.setStyle("-fx-font-family: TRON; -fx-font-size: 16; -fx-font-style: italic;"
				+ " -fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 0 0 2 0;");
		vbEmployeeRight.getChildren().add(lblEmployeeListTitle);

		bpEmployee.setLeft(vbEmployeeLeft);
		bpEmployee.setRight(vbEmployeeRight);
		tAddEmployee.setContent(bpEmployee);

		// function for inserting label and text field according to user choice

		// add role tab setup:
		tfRoleName.setPromptText("Letters only..");
		bpRole.setPadding(new Insets(30));
		roleTitle.setStyle("-fx-font-family: TRON; -fx-font-size: 16; -fx-font-style: italic;"
				+ " -fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 0 0 2 0;");
		vbRoleLeft.getChildren().addAll(lblRoleName, tfRoleName, cbRoleChangeable, btAddRole);
		lblRolesListTitle.setStyle("-fx-font-family: TRON; -fx-font-size: 16; -fx-font-style: italic;"
				+ " -fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 0 0 2 0;");
		vbRoleRight.getChildren().add(lblRolesListTitle);

		bpRole.setRight(vbRoleRight);
		bpRole.setTop(roleTitle);
		bpRole.setLeft(vbRoleLeft);
		tAddRole.setContent(bpRole);
		// -----------------------------------------

		// add Department tab setup:
		tfDepartmentName.setPromptText("Letters only..");
		bpDepartment.setPadding(new Insets(30));
		DepartmentTitle.setStyle("-fx-font-family: TRON; -fx-font-size: 16; -fx-font-style: italic;"
				+ " -fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 0 0 2 0;");
		vbDepartmentLeft.getChildren().addAll(lblDepartmentName, tfDepartmentName, 
				cbDepartmentChangeable, cbDepartmentSynchronizable, btAddDepartment);

		lblDepartmentListTitle.setStyle("-fx-font-family: TRON; -fx-font-size: 16; -fx-font-style: italic;"
				+ " -fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 0 0 2 0;");
		vbDepartmentRight.getChildren().add(lblDepartmentListTitle);

		// visibility of "new starting hour" text field and label for both departments
		// and roles columns
		rbPreferenceEarlyD.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblNewHourDepartment.setVisible(rbPreferenceEarlyD.isSelected());
				tfNewHourDepartments.setVisible(rbPreferenceEarlyD.isSelected());

			}
		});
		rbPreferenceLaterD.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblNewHourDepartment.setVisible(rbPreferenceLaterD.isSelected());
				tfNewHourDepartments.setVisible(rbPreferenceLaterD.isSelected());

			}
		});
		rbPreferenceNormalD.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblNewHourDepartment.setVisible(rbPreferenceEarlyD.isSelected());
				tfNewHourDepartments.setVisible(rbPreferenceEarlyD.isSelected());

			}
		});
		rbPreferenceHomeD.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblNewHourDepartment.setVisible(rbPreferenceEarlyD.isSelected());
				tfNewHourDepartments.setVisible(rbPreferenceEarlyD.isSelected());
			}
		});

		rbPreferenceEarlyR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblNewHourRoles.setVisible(rbPreferenceEarlyR.isSelected());
				tfNewHourRoles.setVisible(rbPreferenceEarlyR.isSelected());

			}
		});
		rbPreferenceLaterR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblNewHourRoles.setVisible(rbPreferenceLaterR.isSelected());
				tfNewHourRoles.setVisible(rbPreferenceLaterR.isSelected());

			}
		});
		rbPreferenceNormalR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblNewHourRoles.setVisible(rbPreferenceEarlyR.isSelected());
				tfNewHourRoles.setVisible(rbPreferenceEarlyR.isSelected());

			}
		});
		rbPreferenceHomeR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblNewHourRoles.setVisible(rbPreferenceEarlyR.isSelected());
				tfNewHourRoles.setVisible(rbPreferenceEarlyR.isSelected());
			}
		});

		bpDepartment.setRight(vbDepartmentRight);
		bpDepartment.setTop(DepartmentTitle);
		bpDepartment.setLeft(vbDepartmentLeft);

		tAddDepartment.setContent(bpDepartment);
		// -------------------------------------------------

		// change work type tab setup:
		vbChangeTypeDepartment.setPadding(new Insets(30));
		vbChangeTypeRole.setPadding(new Insets(30));

		tfNewHourRoles.setVisible(false);
		tfNewHourRoles.setPromptText("Insert a number between 0 - 24 ..");
		tfNewHourDepartments.setPromptText("Insert a number between 0 - 24 ..");
		tfNewHourDepartments.setVisible(false);

		// radio buttons toggle groups:
		rbPreferenceEarlyD.setToggleGroup(radioButtonGroupPreferencesD);
		rbPreferenceLaterD.setToggleGroup(radioButtonGroupPreferencesD);
		rbPreferenceNormalD.setToggleGroup(radioButtonGroupPreferencesD);
		rbPreferenceHomeD.setToggleGroup(radioButtonGroupPreferencesD);
		hPaneRadioButtonsPreferencesD.getChildren().addAll(rbPreferenceEarlyD, rbPreferenceLaterD, rbPreferenceHomeD,
				rbPreferenceNormalD);

		rbPreferenceEarlyR.setToggleGroup(radioButtonGroupPreferencesR);
		rbPreferenceLaterR.setToggleGroup(radioButtonGroupPreferencesR);
		rbPreferenceNormalR.setToggleGroup(radioButtonGroupPreferencesR);
		rbPreferenceHomeR.setToggleGroup(radioButtonGroupPreferencesR);
		hPaneRadioButtonsPreferencesR.getChildren().addAll(rbPreferenceEarlyR, rbPreferenceLaterR, rbPreferenceHomeR,
				rbPreferenceNormalR);

		// fonts to titles:
		lblSelectDepartmentToChange.setStyle("-fx-font-family: TRON; -fx-font-size: 18; -fx-font-style: italic;"
				+ " -fx-font-weight: bold; -fx-border-color: black ;-fx-border-width: 0 0 2 0;");
		lblSelectRoleToChange.setStyle("-fx-font-family: TRON; -fx-font-size: 18; -fx-font-style: italic;"
				+ " -fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 0 0 2 0;");

		// add nodes to tab
		vbChangeTypeDepartment.getChildren().addAll(lblSelectDepartmentToChange, cbDepartments, lblChangeEmployeesDeps,
				hPaneRadioButtonsPreferencesD, lblNewHourDepartment, tfNewHourDepartments, btApplyChangeToDepartments);
		vbChangeTypeRole.getChildren().addAll(lblSelectRoleToChange, cbRoles, lblChangeEmployeesRoles,
				hPaneRadioButtonsPreferencesR, lblNewHourRoles, tfNewHourRoles, btApplyChangeToRoles);
		bpChangeWorkType.setLeft(vbChangeTypeDepartment);
		bpChangeWorkType.setRight(vbChangeTypeRole);

		tChangeWorkType.setContent(bpChangeWorkType);
		// --------------------------------------------

		// Profits/Losses tab setup
		// title
		lblProfitsTitle.setStyle("-fx-font-family: TRON; -fx-font-size: 18; -fx-font-style: italic;"
				+ " -fx-font-weight: bold; -fx-border-color: black ;-fx-border-width: 0 0 2 0;");

		// label text style
		lblEmployeeProfits.setStyle("-fx-font-family: TRON; -fx-font-size: 18; -fx-font-style: italic;"
				+ " -fx-font-weight: bold; -fx-border-color: black ;-fx-border-width: 0 0 2 0;");
		lblDepartmentProfits.setStyle("-fx-font-family: TRON; -fx-font-size: 18; -fx-font-style: italic;"
				+ " -fx-font-weight: bold; -fx-border-color: black ;-fx-border-width: 0 0 2 0;");
		lblCompanyProfits.setStyle("-fx-font-family: TRON; -fx-font-size: 18; -fx-font-style: italic;"
				+ " -fx-font-weight: bold; -fx-border-color: black ;-fx-border-width: 0 0 2 0;");

		// vboxes set up
		vbEmployeeProfit.getChildren().addAll(lblEmployeeProfits);
		vbProfitPerHourByUser.getChildren().addAll(lblProfitsTitle, lblEnterProfit, tfEnterProfit, btCalcProfits);
			
		vbDepartmentProfit.getChildren().addAll(lblDepartmentProfits);

		vbTotalCompanyProfits.getChildren().addAll(lblCompanyProfits);
		hbProfits.setPadding(new Insets(30));
		gpProfits.setHgap(200);
		hbProfits.getChildren().addAll(vbProfitPerHourByUser, vbEmployeeProfit,vbDepartmentProfit,vbTotalCompanyProfits);
		gpProfits.add(hbProfits, 0, 0);
		tShowData.setContent(gpProfits);

		tPaneCompany.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		tPaneCompany.getTabs().addAll(tWelcomeTab, tAddRole, tAddDepartment, tAddEmployee, tChangeWorkType, tShowData);
		// adding tabs

		Scene scene = new Scene(tPaneCompany);
		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Company efficiency demonstraion system");
		primaryStage.setResizable(true);
		primaryStage.setAlwaysOnTop(false);
		primaryStage.show();
	}


	public boolean isDepartmentSynchronizable() {
		return cbDepartmentSynchronizable.isSelected();
	}

	public void addEmployee(EventHandler<ActionEvent> e) { // method to handle "add Employee" button event
		addEmployee.setOnAction(e);
	}

	public String getID() {
		return tfIdEmployee.getText();
	}

	public String getStartingHour() {
		return tfStartHour.getText();
	}

	public String getName() {
		return tfFirstNameEmployee.getText();
	}

	public String getAge() {
		return tfAgeEmployee.getText();
	}

	public String getRole() {
		return cbSelectRole.getValue();
	}

	public String getDepartment() {
		return cbSelectDepartment.getValue();
	}

	public String getBaseSalary() {
		return tfSalary.getText();
	}

	public String getPercentageOfSales() {
		return tfSalesBonus.getText();
	}

	public void showAlert(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert!");
		alert.setContentText(msg);
		alert.showAndWait();
	}

	public void addRole(EventHandler<ActionEvent> e) {
		btAddRole.setOnAction(e);
	}

	public void addDepartment(EventHandler<ActionEvent> e) {
		btAddDepartment.setOnAction(e);
	}

	public String getRoleName() {
		return tfRoleName.getText();
	}

	public void addRoleToComboBox(String roleName) {
		cbSelectRole.getItems().add(roleName);
		cbRoles.getItems().add(roleName);
	}

	public void setCbSelectRole(ComboBox<String> cbSelectRole) {
		this.cbSelectRole = cbSelectRole;
	}

	public String getDepartmentName() {
		return tfDepartmentName.getText();
	}

	public void changeWorkTypeDepartment(EventHandler<ActionEvent> e) {
		btApplyChangeToDepartments.setOnAction(e);
	}

	public void changeWorkTypeRole(EventHandler<ActionEvent> e) {
		btApplyChangeToRoles.setOnAction(e);
	}
	 

	public void addDepartmentToComboBox(String departmentName) {
		cbSelectDepartment.getItems().add(departmentName);
		cbDepartments.getItems().add(departmentName);
	}

	// a method to send messages to the user

	public void addEmployeeList(String name, int id, int age, String paymentMethod, int baseSalary, int salesBonus,
			String role, String department, int startingHour, String workType) {
		if (salesBonus == 0) {
			Label label = new Label("- Name: " + name + " , id: " + id + " , age: " + age + " , department: "
					+ department + " , role: " + role + " , preference: " + workType + " , salary: " + baseSalary
					+ " , Starts work at: " + startingHour + ":00" + ", payment method: " + paymentMethod);
			label.setStyle("-fx-font-family: STIXIntegralsUpD; -fx-font-size: 14; -fx-font-style: italic;");
			vbEmployeeRight.getChildren().add(label);
		} else {
			Label label = new Label("- Name: " + name + " , id: " + id + " , age: " + age + " , department: "
					+ department + " , role: " + role + " , preference: " + workType + " , salary: " + baseSalary
					+ " , sales bonus: " + salesBonus + " , Starts work at: " + startingHour + ":00"
					+ ", payment method: " + paymentMethod);
			label.setStyle("-fx-font-family: STIXIntegralsUpD; -fx-font-size: 14; -fx-font-style: italic;");
			vbEmployeeRight.getChildren().add(label);
		}
	}
	// add details of new employee to list

	public void addRolesList(String roleName, int startingHour) {
		Label label = new Label("- role title: " + roleName +" ,starting hour: " + startingHour);
		label.setStyle("-fx-font-family: STIXIntegralsUpD; -fx-font-size: 14; -fx-font-style: italic;");
		vbRoleRight.getChildren().add(label);

	}

	public void addDepartmentsList(String departmentName, int startingHour) {
		Label label = new Label("- department name: " + departmentName+ " , starting hour: " + startingHour);
		label.setStyle("-fx-font-family: STIXIntegralsUpD; -fx-font-size: 14; -fx-font-style: italic;");
		vbDepartmentRight.getChildren().add(label);

	}
	
	public void saveAndExit(EventHandler<ActionEvent> e) {
		btSaveAndExit.setOnAction(e);
	}
	
	public String getDepartmentToChangeWorkType() {
		return cbDepartments.getValue();
	}

	public String getRoleToChangeWorkType() {
		return cbRoles.getValue();
	}

	public String getNewStartingHourForDepartment() {
		return tfNewHourDepartments.getText();
	}

	public String getNewStartingHourForRoles() {
		return tfNewHourRoles.getText();
	}

	public void removeEmployeeList() {
		vbEmployeeRight.getChildren().clear();
		vbEmployeeRight.getChildren().add(lblEmployeeListTitle);
	}
	
	public boolean isRoleChangeable() {
		return cbRoleChangeable.isSelected();
	}

	public boolean isDepartmentChangeable() {
		return cbDepartmentChangeable.isSelected();
	}

	public void CalculateProfits(EventHandler<ActionEvent> e) {
		btCalcProfits.setOnAction(e);
		
	}

	public String getProfitPerWorkerPerHour() {
		return tfEnterProfit.getText();
	}

	public void addProfitToEmployeeProfitList(String name, double profitPerEmployee) {
		Label label = new Label("- Employee name: \n" + name +"\nprofit: "+ profitPerEmployee + " ILS");
		label.setStyle("-fx-font-family: STIXIntegralsUpD; -fx-font-size: 14; -fx-font-style: italic;");
		vbEmployeeProfit.getChildren().add(label);

		
	}

	public void addProfitToCompanyList(double totalProfit) {
		Label label = new Label("Total company profits: \n"+ totalProfit+ " ILS");
		label.setStyle("-fx-font-family: STIXIntegralsUpD; -fx-font-size: 14; -fx-font-style: italic;");
		vbTotalCompanyProfits.getChildren().add(label);
	}

	public void addProfitToDepartmentsList(String departmentName, double profitPerDepartment) {
		Label label = new Label("- Department name: \n" + departmentName +"\nprofit: "+ profitPerDepartment+ " ILS");
		label.setStyle("-fx-font-family: STIXIntegralsUpD; -fx-font-size: 14; -fx-font-style: italic;");
		vbDepartmentProfit.getChildren().add(label);
	}

	public void removeDepartmentsList() {
		vbDepartmentRight.getChildren().clear();
		vbDepartmentRight.getChildren().add(lblDepartmentListTitle);
	}

	public void removeRolesList() {
		vbRoleRight.getChildren().clear();
		vbRoleRight.getChildren().add(lblRolesListTitle);
	}

	public void removePreviousProfits() {
		vbEmployeeProfit.getChildren().clear();
		vbEmployeeProfit.getChildren().add(lblEmployeeProfits);
		
		vbDepartmentProfit.getChildren().clear();
		vbDepartmentProfit.getChildren().add(lblDepartmentProfits);
		
		vbTotalCompanyProfits.getChildren().clear();
		vbTotalCompanyProfits.getChildren().add(lblCompanyProfits);
	}

	

}
