package network;
// MyMultiServer.java
// A server that uses multithreading to handle
// any number of clients.



import java.io.*;
import java.net.*;

import account.dto.AccountDTO;
import account.dto.BankDatabase;

class MyServerOne extends Thread {
  private Socket socket;

  private BankDatabase bankDatabase = new BankDatabase();
  private boolean userAuthenticated; 
  ObjectInputStream in;
  ObjectOutputStream out;
  AccountDTO userAccount = new AccountDTO();
  AccountDTO userDemo = null;
  
  public MyServerOne(Socket s) throws IOException {
    socket = s;
     out = new ObjectOutputStream(socket.getOutputStream());
    // Output is automatically flushed
    // by PrintWriter:
     in = new ObjectInputStream(socket.getInputStream());
   
    // Enable auto-flush:
    
    // If any of the above calls throw an
    // exception, the caller is responsible for
    // closing the socket. Otherwise the thread
    // will close it.
    start(); // Calls run()
  }
  public void run() {
    try {
      while (true) {
      
    	 AccountDTO accountVerify = (AccountDTO) in.readObject();
    	
    	 System.out.println("the value after  writing to server"+accountVerify.getAvailableBalance());
        System.out.println("Got custId as");
        System.out.println(accountVerify);
        
        BankDatabase accList = new BankDatabase();
		if (accList.authenticateUser(accountVerify))
		{	
			
			userAccount = accList.getAccount(accountVerify.getAccountNumber());
			/*if(userDemo == null) {
				 userAccount = accList.getAccount(accountVerify.getAccountNumber());
				 userDemo = userAccount;	
			}
			else {
				userAccount = accountVerify;
				
			}*/
		
			
			 if(accountVerify.getWithdrawAmt() > 0.0) {
				 userAccount = accList.debit(accountVerify);
			 } else if(accountVerify.getDepositAmt() > 0.0)
			 {
				 userAccount = accList.credit(accountVerify);
			 }
			 //userAccount = accList.getAccount(accountVerify.getAccountNumber());	
				userAccount.setMessage("VALID USER!!");
		}
		else {
			
			
			userAccount.setMessage("INVALID USER!!");
			
		}
		 System.out.println("The balance now is: "+userAccount.getAvailableBalance());
		out.writeObject(userAccount);

      }
    } catch (IOException e) {
    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
      try {
        socket.close();
      } catch(IOException e) {}
    }
  }
}

public class MyMultiServer {
  static final int PORT = 8080;
  public static void main(String[] args)
      throws IOException {
    ServerSocket s = new ServerSocket(PORT);
    System.out.println("Server Started");
    try {
      while(true) {
        // Blocks until a connection occurs:
        Socket socket = s.accept();
        try {
          new MyServerOne(socket);
        } catch(IOException e) {
          // If it fails, close the socket,
          // otherwise the thread will close it:
          socket.close();
        }
      }
    } finally {
      s.close();
    }
  }
}