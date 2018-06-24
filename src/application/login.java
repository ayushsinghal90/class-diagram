package application;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;

public class login {
	Stage login;
	usertb utb = new usertb();
	user u = new user();
	DropShadow DS = new DropShadow(5.0, Color.RED);
	public void log()
	{
		Stage login= new Main().getstage();
		login.setTitle("Login");
		Insets pad = new Insets(10,10,10,10);
		 BorderPane mn = new BorderPane();
         mn.setPadding(pad);
         
         HBox hb = new HBox();
     	 hb.setPadding(new Insets(10,10,10,30));
         hb.setAlignment(Pos.CENTER);
         Label Head = new Label("CLASS DIAGRRAM CREATOR");
         hb.getChildren().add(Head);
         mn.setTop(hb);
         
         GridPane root = new GridPane();
			root.setPadding(pad);
			root.setVgap(8);
			root.setHgap(8);
			root.setAlignment(Pos.CENTER);
			Label Usern = new Label("username");
			GridPane.setConstraints(Usern,0,0);
			TextField urn = new TextField();
			GridPane.setConstraints(urn,1,0);
			Label pass = new Label("Password");
			GridPane.setConstraints(pass,0,1);
			
			PasswordField pai = new PasswordField();
			pai.setPromptText("passwod");
			GridPane.setConstraints(pai,1,1);
			
			HBox root1 = new HBox();
			root1.setSpacing(8);
			Button li = new Button("LOG IN");
			li.setOnAction((e)->
			{
				    u.setusername(urn.getText());
				    if(utb.chexuser(u))
				    {
				    	u.setpassword(pai.getText());
				    	if(utb.authenticate(u))
				    	{
								  login.close();
								  new work().wrk(u);
				    	}
				    	else {
				    		pai.setEffect(DS);
				    	}
				    }
				    
				    else {
				        urn.setEffect(DS);
				    }
			});
			Button su = new Button("SIGN UP");
			su.setOnAction((e)-> {
				  login.close();
				  new signup().sig();
				}
			);
			
			Button ex = new Button("EXIT");
			root1.getChildren().addAll(li,su,ex);
			GridPane.setValignment(root1,VPos.CENTER);
			GridPane.setConstraints(root1,1,3);
			
			root.getChildren().addAll(Usern,urn,pass,pai,root1);
			mn.setCenter(root);
			
            login.setScene(new Scene(mn,300,200));
            login.show();
	}
}
