// MyServer.java
// Very simple server that just
// echoes whatever the client sends.

package network;

import java.io.*;
import java.net.*;

import account.dto.AccountDTO;

public class MyServer {
  // Choose a port outside of the range 1-1024:
  public static final int PORT = 8080;
  public static void main(String[] args)
      throws IOException, ClassNotFoundException {
    ServerSocket s = new ServerSocket(PORT);
    System.out.println("Started: " + s);
    try {
      // Blocks until a connection occurs:
      Socket socket = s.accept();
      try {
        System.out.println(
          "Connection accepted: "+ socket);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        // Output is automatically flushed
        // by PrintWriter:
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        
        AccountDTO accountVerify = (AccountDTO) in.readObject();
        
        System.out.println("Echoing: " + accountVerify);
        /*while (true) {
          String str = in.readLine();
          if (str.equals("END")) break;
          System.out.println("Echoing: " + str);
          out.println(str);
        }*/
      // Always close the two sockets...
      } finally {
        System.out.println("closing...");
        socket.close();
      }
    } finally {
      s.close();
    }
  }
}