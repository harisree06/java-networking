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

public class TotalBalance extends JFrame implements ActionListener {

	 Container container=getContentPane();
	 JLabel finalBalance=new JLabel("YOUR FINAL BALANCE IS:");
	 JLabel transaction=new JLabel("Do you need any more transaction");
	 JButton yes=new JButton("Yes");
	 JButton no=new JButton("No");
	 private AccountDTO myAcc = new AccountDTO();
	 private ObjectInputStream input;
	 private ObjectOutputStream output;
	 TotalBalance(ObjectInputStream in, ObjectOutputStream out, AccountDTO acc)
	    {
	       //Calling methods inside constructor.
	        setLayoutManager();
	        setLocationAndSize();
	        addComponentsToContainer();
	        addActionEvent();
	        this.myAcc = acc;
	        this.input = in;
	        this.output = out;
	        this.finalBalance.setText("YOUR AVAILABLE BALANCE IS:" +this.myAcc.getAvailableBalance());
	        
	 
	    }
	   public void setLayoutManager()
	   {
	       container.setLayout(null);
	   }
	   public void setLocationAndSize()
	   {
	       //Setting location and Size of each components using setBounds() method.
		   finalBalance.setBounds(50,50,250,30);
		   transaction.setBounds(50,100,250,30);
		   yes.setBounds(50,150,100,50);
		   no.setBounds(200,150,100,50);
	 
	 
	   }
	   public void addComponentsToContainer()
	   {
	      //Adding each components to the Container
		   container.add(finalBalance);
	       container.add(transaction);
	       container.add(yes);
	       container.add(no);
	   }
	   public void addActionEvent()
	   {
	      //adding Action listener to components
		   yes.addActionListener(this);
		   no.addActionListener(this);
	       
	   }
	 
	    public void actionPerformed(ActionEvent e) {
	    	 
	    	
	        if (e.getSource() == yes) {
	        	 ChooseOperation frame=new ChooseOperation(this.input, this.output, this.myAcc);
	             frame.setTitle("Choose operation Form");
	             frame.setVisible(true);
	             frame.setBounds(10,10,500,500);
	             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	             frame.setResizable(false);
	        }
	        if (e.getSource() == no) {
	        	
	        	 Thanks frame=new Thanks();
	             frame.setTitle("Choose operation Form");
	             frame.setVisible(true);
	             frame.setBounds(10,10,500,500);
	             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	             frame.setResizable(false);
	        }
	    }

}
