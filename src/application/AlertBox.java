package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
	  Stage window = new Main().getstage();
	  boolean ans;
	  Insets pad = new Insets(10,10,10,10);
    public boolean display(String msg) {
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Alert");
        Label label = new Label();
        label.setText(msg);
        label.setTextAlignment(TextAlignment.CENTER);
        HBox h =new HBox(10);
        h.setAlignment(Pos.CENTER);
        Button yb = new Button("yes");
        yb.setOnAction((e )->{ 
        	ans = true;
        window.close();});
        Button nb = new Button("no");
        nb.setOnAction((e )->{ 
        	ans = false;
        window.close();});
        h.getChildren().addAll(yb,nb);
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(pad);
        layout.getChildren().addAll(label, h);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout,180,130);
        window.setScene(scene);
        window.showAndWait();
        return ans;
    }

}