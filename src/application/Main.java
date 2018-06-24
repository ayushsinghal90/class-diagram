package application;
	
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;


public class Main extends Application {
   Stage primaryStage;
	public void start(Stage t) {
		primaryStage = t;
		Insets pad = new Insets(10,10,10,10);
		try {
			primaryStage = getstage();
			primaryStage.setTitle("CLASS DIAGRAM");
		
			HBox wel1 = new HBox();
		    wel1.setAlignment(Pos.CENTER);
			Label wlc = new Label("Welcome to Class Diagram creator.");
			wel1.getChildren().add(wlc);
			GridPane.setConstraints(wel1,0,1);
			
			
			VBox wel2 = new VBox();
			wel2.setPadding(pad);
			wel2.setSpacing(20);
			wel2.setAlignment(Pos.CENTER);
			Label why = new Label("Why Class Diagram");
			Label info = new Label("The class diagram is the main building block of object-oriented modelling."
					     + "It is used for general conceptual modelling of the systematic of the application,"
					     + "and for detailed modelling translating the models into programming code."
					     + "Class diagrams can also be used for data modeling.The classes in a class "
					     + "diagram represent both the main elements, interactions in the application,"
					     + "and the classes to be programmed.\n");
			info.setMaxSize(450, 200);
			info.setWrapText(true);
			Label pres = new Label("Press Any Key To Continue");
			wel2.getChildren().addAll(why,info,pres);
			GridPane.setConstraints(wel2,0,7);
			
			GridPane start = new GridPane();
			start.setPadding(pad);
			start.setVgap(8);
			start.setHgap(8);
			start.setAlignment(Pos.CENTER);
			start.getChildren().addAll(wel1,wel2);
			Scene scene =new Scene(start,500,300);
			scene.setOnKeyTyped((e)-> {
				 primaryStage.close();
				 new login().log();
			});
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    public Stage getstage()
    {
    	Stage common = new Stage();
    	common.setResizable(false);
		common.setOpacity(0.93);
		common.centerOnScreen();
    	return common;
    }
	public static void main(String[] args) {
		launch(args);
	}
}
