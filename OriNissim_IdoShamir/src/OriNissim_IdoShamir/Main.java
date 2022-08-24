package OriNissim_IdoShamir;


import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch();
	}

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		View theView = new View(primaryStage);
		Company c = new Company("Company Effeciency Demonstration");
		CompanyController controller = new CompanyController(c,theView);


	}
}
