package Chat;

import java.io.*;
import java.net.*;
import java.util.Scanner; 

public class ServerSide {

 public static void main(String[] args) {
  System.out.println("EchoServer started."); 
     try {
       ServerSocket s = new ServerSocket(8008); 
       Socket incoming = s.accept(); 

       System.out.println("Connected to: " + incoming.getInetAddress() + " at port: " + incoming.getLocalPort()); 
       
       BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream())); 
       PrintWriter out = new PrintWriter(new OutputStreamWriter(incoming.getOutputStream())); 
       
       String strCli = "";
       String strSer = "";
       @SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
       
       while(!strSer.equals("bye")) {
        System.out.println("Reading the Message from Client");
        strCli = in.readLine();
        System.out.println("client says: " + strCli);
        
        System.out.println("Write the message for client");
        strSer = scan.nextLine();
        
        out.println(strSer);
        out.flush();   
    }
       in.close();
       out.close();
       incoming.close(); 
       s.close();
     } catch (Exception e) {
       System.out.println("Error: " + e); 
     }
     System.out.println("EchoServer stopped."); 
 }
}

