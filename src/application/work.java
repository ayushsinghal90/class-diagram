package application;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.stage.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import java.io.*;
import javafx.stage.FileChooser.*;
import java.util.*;

public class work {
	usertb utb = new usertb();
	user ut;
	DropShadow DS = new DropShadow(5.0, Color.RED);
	Insets pad = new Insets(10,10,10,10);
	TabPane tp;
	TextField fn;
	Button a,cs;
	BorderPane mn = new BorderPane();
	MenuItem save,cut,copy,paste;
	String path = null;
	File sf;
	

	
	public void wrk(user u)
	{
		
		ut = u;
		Stage work= new Main().getstage();
		work.setResizable(true);
		work.setTitle("CLASS DIAGRRAM CREATOR");
		  
		MenuBar mb = new MenuBar();
         
         Menu fileMenu = new Menu("File");
         MenuItem nw =new MenuItem("New");
         MenuItem open = new MenuItem("Open");
         save = new MenuItem("Save");
         MenuItem exit = new MenuItem("Exit");
         open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
         nw.setAccelerator(KeyCombination.keyCombination("shortcut+N"));
         save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
         exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));
         exit.setOnAction((e)->{
        	if(!mn.getChildren().contains(a)&&!tp.getTabs().isEmpty()) 
        	{
        		if(new AlertBox().display("Are you srue\nData will not be saved"))
        			work.close();
        	}
        	else
        	work.close();
         });
         work.setOnCloseRequest((e)->{
        	 if(!mn.getChildren().contains(a)&&!tp.getTabs().isEmpty()) 
         	{
         		if(!new AlertBox().display("Are you srue\nData will not be saved"))
         			e.consume();
         	}
         });
         fileMenu.getItems().addAll(nw,open, save,new SeparatorMenuItem(), exit);
         mb.getMenus().add(fileMenu);
          
          Menu optionsMenu = new Menu("Options");
          copy = new MenuItem("Copy");
          cut = new MenuItem("Cut");
          paste = new MenuItem("Paste");
          MenuItem cp = new MenuItem("Change directory");
          copy.setAccelerator(KeyCombination.keyCombination("shortcut+c"));
          cut.setAccelerator(KeyCombination.keyCombination("shortcut+x"));
          paste.setAccelerator(KeyCombination.keyCombination("shortcut+v"));
          cp.setAccelerator(KeyCombination.keyCombination("shortcut+d"));
          cp.setOnAction((cpt)->{
        	  path = getpt();
          });
         optionsMenu.getItems().addAll(copy,cut,paste,cp);
         mb.getMenus().add(optionsMenu);
         
         Menu helpMenu = new Menu("Help");
         MenuItem about = new MenuItem("About");
         about.setOnAction((e)->{
        	  new htu().huse(); 
         });
         helpMenu.getItems().add(about);
         mb.getMenus().add(helpMenu);
         mn.setTop(mb);
         
         HBox hb = new HBox();
     	 hb.setPadding(new Insets(10,10,10,10));
     	 hb.setAlignment(Pos.TOP_RIGHT);
     	 cs = new Button("Create Class Diagram");
     	 cs.setOnAction((e)->{
     		createcd(); 
     	 });
     	 hb.getChildren().add(cs);
     	 mn.setBottom(hb);
     	 
     	 tp = new TabPane();
         a =new Button("Add new edit window");
         a.setOnAction((e)->{     	
        	create();
         });
         mn.setCenter(a);
      
         nw.setOnAction((e)->
         { 
        	 create();
         });
         open.setOnAction((e)->{
        	 pick();
         });
     
            work.setScene(new Scene(mn,1000,600));
            work.show();
            htu j = new htu();
            j.huse();
            j.hse.setOnCloseRequest((e)->{
            	path=u.getpath();
            	j.hse.close();
            	if(path==null)
            	{
            		path=getpt();
            	}
            });
    }
	
	public void create() {
		if(path==null) {
		       path = getpt();
			}
		if(path!=null) {
		 Stage ask =new Main().getstage();
    	 ask.setTitle("New");
    	 BorderPane ak = new BorderPane();
    	 GridPane g = new GridPane();
    	 g.setPadding(pad);
			 g.setVgap(8);
			 g.setHgap(8);
			 g.setAlignment(Pos.CENTER);
			Label f = new Label("File Name");
			GridPane.setConstraints(f,0,0);
			fn = new TextField("New text");
			GridPane.setConstraints(fn,1,0);
			HBox g1 = new HBox();
		g1.setSpacing(8);
		Button cr = new Button("Create");
			cr.setOnAction((ae)->{
			    tabcre();
			    if(mn.getChildren().contains(a))
	        	{
	            		mn.getChildren().remove(2);   
	                    mn.setCenter(tp);
	        	}
			    ask.close();
			});
			Button ex = new Button("EXIT");
			ex.setOnAction((e)->{
				ask.close();
			});
		g1.getChildren().addAll(cr,ex);
		GridPane.setValignment(g1,VPos.CENTER);
		GridPane.setConstraints(g1,1,3);
		g.getChildren().addAll(f,fn,g1);
		ak.setCenter(g);
		ask.setScene(new Scene(ak,300,200));
	    ask.initModality(Modality.APPLICATION_MODAL);
        ask.show();
		}
	}
	
	public void tabcre() {
		String p;
		if(fn.getText().endsWith(".java"))
		{
			 p= path+"\\"+fn.getText();
		}
		else {
			p= path+"\\"+fn.getText()+".java";
		}
		Tab t = new Tab(fn.getText());
		t.setClosable(true);
		TextArea tx = new TextArea();
		
		t.setContent(tx);
		t.selectedProperty().addListener((e)->{
			t.setOnCloseRequest((h)->{
				if(new AlertBox().display("Do you want to save your edit"))
					{save.fire(); }
			});
			save.setOnAction((s)->{
				try {
				FileWriter fw = new FileWriter(p);
				fw.write(tx.getText());
				fw.flush();
				fw.close();			
				}
				catch(Exception i) {}
			});
			cut.setOnAction((c)->{
			    tx.cut();
		    });
			paste.setOnAction((pa)->{
				tx.paste();
			});
			copy.setOnAction((co)->{
				tx.copy();
		    });
		});	
		tp.getTabs().add(t);
	} 
	public void pick()
	{
		if(path==null) {
		       path = getpt();
			}
		FileChooser f = new FileChooser();
		f.getExtensionFilters().addAll(new ExtensionFilter("java files","*.java"));
		f.setInitialDirectory(new File(path));
		File fo = f.showOpenDialog(null);
		if(fo.exists())
		{
		Tab t = new Tab(fo.getName());
		t.setClosable(true);
		TextArea tx = new TextArea();
		
		try {
			Scanner txt = new Scanner(fo.getAbsoluteFile());
		String text = txt.useDelimiter("\\A").next();
	    tx.setText(text);
	    txt.close();
		}
		catch(Exception tk) {}
		t.setContent(tx);
		t.selectedProperty().addListener((e)->{
			t.setOnCloseRequest((h)->{
				if(new AlertBox().display("Do you want to save your edit"))
					{save.fire(); }
				if(tp.getTabs().isEmpty()) {
					mn.getChildren().remove(2);   
                    mn.setCenter(a);
				}
				
			});
			save.setOnAction((s)->{
				String p = path+"\\"+fo.getName();
				try {
				FileWriter fw = new FileWriter(p);
				fw.write(tx.getText());
				fw.flush();
				fw.close();
				}
				catch(Exception i) {}
			});
			cut.setOnAction((c)->{
			    tx.cut();
		    });
			paste.setOnAction((pa)->{
				tx.paste();
			});
			copy.setOnAction((co)->{
				tx.copy();
		    });
		});	
		 if(mn.getChildren().contains(a))
     	{
         		mn.getChildren().remove(2);   
                 mn.setCenter(tp);
     	}
		tp.getTabs().add(t);
		}
	}
	public String getpt()
	{
		DirectoryChooser f =new DirectoryChooser();
		f.setTitle("choose a directory to save yor files");
		sf=f.showDialog(null);
		if(sf.getAbsolutePath()!=null) {
			  ut.setpath(sf.getAbsolutePath());
	     	  utb.updpth(ut);
		}
		return sf.getAbsolutePath();
	}
	
	public void createcd()
	{
		/*FilenameFilter fif = new FilenameFilter() {
			public boolean accept(File f,String n)
			{
				if(n.endsWith(".java"))
				 return true;
				else 
					return false;
			}
		};*/
		
	}
}
