package atm;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InvalidUser extends JFrame implements ActionListener{

			String invalid_user = "Sorry!Invalid User. Please try again";
			Container container=getContentPane();
			JLabel error = new JLabel(invalid_user);
			JButton try_again = new JButton("Try again");
			 private ObjectInputStream input;
			 private ObjectOutputStream output;

			public InvalidUser(ObjectInputStream in, ObjectOutputStream out) {
					// TODO Auto-generated constructor stub
			container.setLayout(null);
			error.setBounds(100,100,350,30);
			try_again.setBounds(150,300,100,30);
			container.add(error);
			container.add(try_again);	
			this.input = in;
			this.output = out;
			 try_again.addActionListener(this);


			
		}
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				this.setVisible(false);
				AtmUI display = new AtmUI();
			     display.displayUI(this.input , this.output);
				
			}

}
