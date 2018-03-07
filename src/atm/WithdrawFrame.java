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
import javax.swing.JTextField;

import account.dto.AccountDTO;

public class WithdrawFrame extends JFrame implements ActionListener {

	String welcomeString = "WITHDRAW";
    Container container=getContentPane();
    JLabel welcome=new JLabel(welcomeString);

    JLabel availableBalanceLabel=new JLabel("AVAILABLE BALANCE");
    JLabel amountLabel=new JLabel("ENTER THE AMOUNT");
  
    JTextField availableBalanceText=new JTextField();
    JTextField amountText=new JTextField();
    JButton withdrowButton=new JButton("WITHDROW");
    //JButton depositButton=new JButton("DEPOSIT");
	 private AccountDTO myAcc = new AccountDTO();
	 private ObjectInputStream input;
	 private ObjectOutputStream output;
 
    WithdrawFrame(ObjectInputStream in, ObjectOutputStream out, AccountDTO userAcc)
    {
       //Calling methods inside constructor.
    
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.myAcc = userAcc;
       
        this.availableBalanceText.setText(String.valueOf(userAcc.getAvailableBalance()));
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
	   welcome.setBounds(150,100,150,30);
	
	   availableBalanceLabel.setBounds(50,200,150,30);
	   amountLabel.setBounds(50,250,150,30);
	   availableBalanceText.setBounds(200,200,150,30);
	   availableBalanceText.setEditable(false);
	   amountText.setBounds(200,250,150,30);
	   withdrowButton.setBounds(150,300,150,30);
 
 
   }
   public void addComponentsToContainer()
   {
      //Adding each components to the Container
	   container.add(welcome);
      
       container.add(availableBalanceLabel);
       container.add(amountLabel);
       
       container.add(availableBalanceText);
       container.add(amountText);
       container.add(withdrowButton);
   }
   public void addActionEvent()
   {
      //adding Action listener to components
	   withdrowButton.addActionListener(this);
       
   }
 
    public void actionPerformed(ActionEvent e) {
    	
    	this.setVisible(false);
    	//Coding Part of withdrowButton button
        if (e.getSource() == withdrowButton) {
            String totalBalance;
            String availableBalance;
            String amount;
            amount = amountText.getText();
          
            System.out.println(amount);
            this.myAcc.setWithdrawAmt(Double.valueOf(amount));
            try {
            	 System.out.println("the value before writing to server"+this.myAcc.getAvailableBalance());
				this.output.writeObject(myAcc);
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            AtmUI ui = new AtmUI();
            try {
				ui.displayDepositForm(this.input, this.output);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
}
