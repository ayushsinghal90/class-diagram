package application;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.effect.*;
import javafx.scene.paint.*;

public class signup {
	String s = "acdefghijklmnopQrstuvwxyz ";
	usertb utb = new usertb();
	user u = new user();
	DropShadow DS = new DropShadow(5.0, Color.RED);
	
	public void sig()
	{
		Stage signup= new Main().getstage();
		signup.setTitle("Login");
		Insets pad = new Insets(10,10,10,10);
		 BorderPane mn = new BorderPane();
         mn.setPadding(pad);
         
         HBox hb = new HBox();
     	 hb.setPadding(new Insets(30,10,10,30));
         hb.setAlignment(Pos.CENTER);
         Label Head = new Label("CLASS DIAGRRAM CREATOR");
         hb.getChildren().add(Head);
         mn.setTop(hb);
         
         GridPane root = new GridPane();
			root.setPadding(pad);
			root.setVgap(8);
			root.setHgap(8);
			root.setAlignment(Pos.CENTER);
			Label nm = new Label("Name");
			GridPane.setConstraints(nm,0,0);
			TextField nme = new TextField();
			nme.setPromptText("Ayush");
			GridPane.setConstraints(nme,1,0);
			nme.setOnKeyTyped((e)->
			{
				String c=e.getCharacter();
			    if((!s.contains(c))&&(!s.toUpperCase().contains(c)))
			    { e.consume(); }
			});
			
			Label ur = new Label("username");
			GridPane.setConstraints(ur,0,1);
			TextField urn = new TextField();
			urn.setPromptText("funkycreator");
			GridPane.setConstraints(urn,1,1);
			urn.setOnKeyTyped((e)->{urn.setEffect(null);
			});
			
			Label em = new Label("Email");
			GridPane.setConstraints(em,0,2);
			TextField ema = new TextField();
			ema.setPromptText("xyz@Classdiagram.com");
			GridPane.setConstraints(ema,1,2);
			
			Label co = new Label("Contact No.");
			GridPane.setConstraints(co,0,3);
			TextField con = new TextField();
			con.setPromptText("9888668887");
			GridPane.setConstraints(con,1,3);
			con.setOnKeyTyped((e)->
			{
				con.setEffect(null);
				String c=e.getCharacter();
			    if(!"1234567890".contains(c))
			    { e.consume(); }
			    c = con.getText();
			    if(c.length()>9)
			    { e.consume(); }
			});
			
			Label fp = new Label("Password");
			GridPane.setConstraints(fp,0,4);
			PasswordField fps = new PasswordField();
			fps.setPromptText("passwod");
			GridPane.setConstraints(fps,1,4);
			
			Label cp = new Label("Confirm Password");
			GridPane.setConstraints(cp,0,5);
			PasswordField cps = new PasswordField();
			cps.setPromptText("Above Passwod");
			GridPane.setConstraints(cps,1,5);
			cps.setOnKeyTyped((e)->{cps.setEffect(null);
			});
			
			HBox root1 = new HBox();
			root1.setSpacing(8);
			Button su = new Button("SIGN UP");
			su.setOnAction((e)->
			{
				    u.setusername(urn.getText());
				    u.setcno(con.getText());
				    if(utb.chexcno(u)||utb.chexuser(u))
				    {
				    	e.consume();
				    	if(utb.chexcno(u))
				    		con.setEffect(DS);
				    	if(utb.chexuser(u))
				    		urn.setEffect(DS);
				    	if(cps.getText().equals(fps.getText()))
				    		cps.setEffect(DS);
				    }
				    
				    else {
				    	if(cps.getText().equals(fps.getText()))
				    	{
				    u.setEmail(ema.getText());
				    u.setname(nme.getText());
				    u.setpassword(cps.getText());
				    utb.addUser(u);
				    signup.close();
				     new work().wrk(u);
					
				    	}
				    	else
				    		cps.setEffect(DS);
				    }
			});
			
			Button ex = new Button("EXIT");
			root1.getChildren().addAll(su,ex);
			
		
			GridPane.setValignment(root1,VPos.CENTER);
			GridPane.setConstraints(root1,1,6);
			
			root.getChildren().addAll(nm,nme,ur,urn,em,ema,co,con,fp,fps,cp,cps,root1);
			mn.setCenter(root);
			signup.setScene(new Scene(mn,400,400));
			signup.show();	
	}
}
