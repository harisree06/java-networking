package atm;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import account.dto.AccountDTO;

public class ChooseOperation extends JFrame implements ActionListener {
	
	 Container container=getContentPane();
	 String welcomeString = "CHOOSE YOUR TRANSACTION";
	 JLabel welcome=new JLabel(welcomeString);
	 JButton withdrowButton=new JButton("WITHDROW");
	 JButton depositButton=new JButton("DEPOSIT");
	 JButton balanceButton = new JButton("Balance");
	 private AccountDTO myAcc = new AccountDTO();
	 AccountDTO acc = new AccountDTO();
	 private ObjectInputStream input;
	 private ObjectOutputStream output;
	 ChooseOperation(ObjectInputStream in, ObjectOutputStream out, AccountDTO acc)
	    {
	       //Calling methods inside constructor.
		 	
	        setLayoutManager();
	        setLocationAndSize();
	        addComponentsToContainer();
	        addActionEvent();
	        this.myAcc = acc;
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
		   welcome.setBounds(180,100,250,30);
		   withdrowButton.setBounds(50,150,200,50);
		   depositButton.setBounds(275,150,200,50);
		   balanceButton.setBounds(175, 300, 200, 50);
	 
	 
	   }
	   public void addComponentsToContainer()
	   {
	      //Adding each components to the Container
		   container.add(welcome);
	       container.add(withdrowButton);
	       container.add(depositButton);
	       //container.add(balanceButton);
	   }
	   public void addActionEvent()
	   {
	      //adding Action listener to components
		   withdrowButton.addActionListener(this);
		   depositButton.addActionListener(this);
	       balanceButton.addActionListener(this);
	   }
	 
	    public void actionPerformed(ActionEvent e) {
	    	
	    	
	    	this.setVisible(false);
	        if (e.getSource() == withdrowButton) {
	        	 //Creating object of WithdrawFrame class and setting some of its properties
	            WithdrawFrame frame=new WithdrawFrame(this.input, this.output, this.myAcc);
	            frame.setTitle("Withdrow Form");
	            frame.setVisible(true);
	            frame.setBounds(10,10,500,500);
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setResizable(false);
	        }
	        if (e.getSource() == depositButton) {
	        	
	        	 //Creating object of DepositFrame class and setting some of its properties
	            DepositFrame frame=new DepositFrame(this.input, this.output, this.myAcc);
	            frame.setTitle("Deposit Form");
	            frame.setVisible(true);
	            frame.setBounds(10,10,500,500);
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setResizable(false);
	        }
	        if (e.getSource() == balanceButton) {
	        	
	        	try {
					acc = (AccountDTO) this.input.readObject();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("The balance now is: "+acc.getAvailableBalance());
				TotalBalance frame=new TotalBalance(this.input, this.output ,acc );
				frame.setTitle("Deposit Form");
				frame.setVisible(true);
				frame.setBounds(10,10,500,500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
	        	
	        	 
	        }
	    }

}
