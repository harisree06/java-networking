package atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.swing.JFrame;

import account.dto.AccountDTO;

public class AtmUI {
		
	AccountDTO acc = new AccountDTO();
	public void displayUI(ObjectInputStream in, ObjectOutputStream out) {
		
		 LoginFrame frame = new LoginFrame(in, out);
	      frame.setTitle("Login Form");
	      frame.setVisible(true);
	      frame.setBounds(10,10,500,500);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setResizable(false);
		
	     
  	
	}
	
	public void displayOperations(ObjectInputStream in, ObjectOutputStream out) {
		
		 try {
				acc = (AccountDTO) in.readObject();
				System.out.println(acc.getMessage());
				System.out.println("The balance now is: "+acc.getAvailableBalance());
				if (!(acc.getMessage().matches("INVALID USER!!")) ) {
				 	ChooseOperation frame1=new ChooseOperation(in, out , acc);
		            frame1.setTitle("Choose operation Form");
		            frame1.setVisible(true);
		            frame1.setBounds(10,10,500,500);
		            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            frame1.setResizable(false);
				}
				else {
					 InvalidUser frame = new InvalidUser(in, out );
					    frame.setTitle("Invalid User");
			            frame.setVisible(true);
			            frame.setBounds(10,10,500,500);
			            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			            frame.setResizable(false);
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	
	public void displayDepositForm(ObjectInputStream in, ObjectOutputStream out) throws ClassNotFoundException, IOException {
				acc = (AccountDTO) in.readObject();
				System.out.println("The balance now is: "+acc.getAvailableBalance());
				TotalBalance frame=new TotalBalance(in, out ,acc );
				frame.setTitle("Deposit Form");
				frame.setVisible(true);
				frame.setBounds(10,10,500,500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				
			
		
	}

}
