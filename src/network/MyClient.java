// MyClient.java
// Very simple client that just sends
// lines to the server and reads lines
// that the server sends.

package network;

import java.net.*;

import account.dto.AccountDTO;
import atm.AtmUI;

import java.io.*;

public class MyClient {
	
	 static Object acc = new AccountDTO();
  public static void main(String[] args)
      throws IOException {

    // Passing null to getByName() produces the
    // special "Local Loopback" IP address, for
    // testing on one machine w/o a network:

    InetAddress addr = InetAddress.getByName(null);

    // Alternatively, you can use
    // the address or name:
    // InetAddress addr =
    // InetAddress.getByName("127.0.0.1");
    // InetAddress addr =
    // InetAddress.getByName("localhost");

    System.out.println("addr = " + addr);
    Socket socket = new Socket(addr, MyServer.PORT);

    // Guard everything in a try-finally to make
    // sure that the socket is closed:

    try {
      System.out.println("socket = " + socket);
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      // Output is automatically flushed
      // by PrintWriter:
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
      AtmUI display = new AtmUI();
     
     display.displayUI(in , out);
 		
    // socket.close();
      	
    } catch(Exception e) {
    }
}
}