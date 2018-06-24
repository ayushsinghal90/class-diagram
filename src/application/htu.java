package application;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;

public class htu {
	Stage hse;
	 public void huse() {
		 hse= new Main().getstage();			
		 hse.setTitle("ABOUT");
		 Insets pad = new Insets(10,10,10,10);
		 
			HBox wel1 = new HBox();
		    wel1.setAlignment(Pos.CENTER);
			Label wlc = new Label("Creation Guide");
			wel1.getChildren().add(wlc);
			GridPane.setConstraints(wel1,0,1);
			
			
			VBox wel2 = new VBox();
			wel2.setPadding(pad);
			wel2.setSpacing(20);
			wel2.setAlignment(Pos.CENTER);
			Label info = new Label("1.This Class Diagram Creator uses a common directory link\n"
					     + "2.All file saving and class Diagram creation in Stored in directory itself\n"
					     + "3.All code should have seprate class files in java txt\n"
					     + "4.This program will create a esttimated class Diagram\n"
					     + "5.No compilation service is provided from our side in editor\n");
			info.setMaxSize(450, 200);
			info.setWrapText(true);
			Label pres = new Label("Press Any Key To Continue");
			wel2.getChildren().addAll(info,pres);
			GridPane.setConstraints(wel2,0,7);
			
			GridPane start = new GridPane();
			start.setPadding(pad);
			start.setVgap(8);
			start.setHgap(8);
			start.setAlignment(Pos.CENTER);
			start.getChildren().addAll(wel1,wel2);
			Scene scene =new Scene(start,500,300);
			scene.setOnKeyTyped((e)-> {
				 hse.fireEvent(new WindowEvent(hse,WindowEvent.WINDOW_CLOSE_REQUEST));
			});
			hse.setScene(scene);
			hse.initModality(Modality.APPLICATION_MODAL);
			hse.show();
	 }
}
