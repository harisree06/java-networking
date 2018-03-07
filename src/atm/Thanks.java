package atm;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Thanks extends JFrame {
	Container container=getContentPane();
	 String welcomeString = "THANKS FOR USING ATM";
	 JLabel welcome=new JLabel(welcomeString);
	 Thanks()
	    {
	       //Calling methods inside constructor.
	        setLayoutManager();
	        setLocationAndSize();
	        addComponentsToContainer();
	 
	    }
	   public void setLayoutManager()
	   {
	       container.setLayout(null);
	   }
	   public void setLocationAndSize()
	   {
	       //Setting location and Size of each components using setBounds() method.
		   welcome.setBounds(180,100,250,30);
	 
	 
	   }
	   public void addComponentsToContainer()
	   {
	      //Adding each components to the Container
		   container.add(welcome);
	   }

}
