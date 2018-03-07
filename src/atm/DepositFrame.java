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

public class DepositFrame extends JFrame implements ActionListener {
	String welcomeString = "DEPOSIT";
    Container container=getContentPane();
    JLabel welcome=new JLabel(welcomeString);
    JLabel amountLabel=new JLabel("ENTER THE AMOUNT");
    JTextField amountText=new JTextField();
    JButton depositButton=new JButton("DEPOSIT");
    AccountDTO myAcc = new AccountDTO();
    private ObjectInputStream input;
	private ObjectOutputStream output;

    DepositFrame(ObjectInputStream in, ObjectOutputStream out, AccountDTO userAcc)
    {
       //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.myAcc = userAcc;
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
	   welcome.setBounds(150,50,200,30);
	   amountLabel.setBounds(50,100,150,30);
	   amountText.setBounds(200,100,150,30);
	   depositButton.setBounds(150,150,100,30);
 
 
   }
   public void addComponentsToContainer()
   {
      //Adding each components to the Container
	   container.add(welcome);
       container.add(amountLabel);
       container.add(amountText);
       container.add(depositButton);
   }
   public void addActionEvent()
   {
      //adding Action listener to components
	   depositButton.addActionListener(this);
       
   }
 
    public void actionPerformed(ActionEvent e) {
  
    	//Coding Part of depositButton button
        if (e.getSource() == depositButton) {
            String amount;
            amount = amountText.getText();
            System.out.println(amount);
            

            System.out.println(amount);
            this.myAcc.setDepositAmt(Double.valueOf(amount));
            try {
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
