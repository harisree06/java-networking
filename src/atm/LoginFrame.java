package atm;

import javax.swing.*;

import account.dto.AccountDTO;
import account.dto.BankDatabase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
 
public class LoginFrame extends JFrame implements ActionListener {
	
	
	AccountDTO account = new AccountDTO();
	String welcomeString = "WELCOME TO ATM";
    Container container=getContentPane();
    JLabel welcome=new JLabel(welcomeString);
    JLabel customerIdLabel=new JLabel("CUSTOMER ID");
    JLabel pinLabel=new JLabel("PIN");
    JTextField customerIdField=new JTextField();
    JTextField pinField=new JTextField();
    JButton loginButton=new JButton("LOGIN");
    private ObjectInputStream input;
    private ObjectOutputStream output;
    AccountDTO acc = new AccountDTO();
  

 
    public LoginFrame(ObjectInputStream in, ObjectOutputStream out)
    {
    	   //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.input = in;
        this.output = out;
 
    }
   public void setLayoutManager()
   {
       container.setLayout(null);
   }
   public void setLocationAndSize()
   {
       //Setting location and Size of each components using setBounds() method.
	   welcome.setBounds(100,100,150,30);
       customerIdLabel.setBounds(50,150,100,30);
       pinLabel.setBounds(50,220,100,30);
       customerIdField.setBounds(150,150,150,30);
       pinField.setBounds(150,220,150,30);
       loginButton.setBounds(150,300,100,30);
 
 
   }
   public void addComponentsToContainer()
   {
      //Adding each components to the Container
	   container.add(welcome);
       container.add(customerIdLabel);
       container.add(pinLabel);
       container.add(customerIdField);
       container.add(pinField);
       container.add(loginButton);
   }
   public void addActionEvent()
   {
      //adding Action listener to components
       loginButton.addActionListener(this);
       
   }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.println("test");
    	//Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            int customerId;
            int password;
            customerId = Integer.parseInt(customerIdField.getText());
            password = Integer.parseInt(pinField.getText());
            
            account.setAccountNumber(customerId);
            account.setPin(password);
            try {
				this.output.writeObject(account);
				
			
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                      
    			
            this.setVisible(false);
//            Creating object of ChooseOperation class and setting some of its properties
            AtmUI display = new AtmUI();
            
            display.displayOperations(this.input , this.output);
          
        }
    }
}
 