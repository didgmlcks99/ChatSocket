package Chat;

import java.io.*;
import java.net.*;
import java.util.Scanner; 

public class ClientSide {
 
 public static void main(String[] args) {
  try {
        String host;
        if (args.length>0) {
          host=args[0];
        } else {
          host="localhost";
        }

        Socket socket=new Socket(host, 8008);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        String strCli = "";
        String strSer = "";
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        
        // send data to the server
        while(!strCli.equals("bye")) {
          System.out.println("Write a Message to Server");
          strCli = scan.nextLine();
          
          out.println(strCli);
          out.flush();
          
          System.out.println("Reading the Message from Server");
          strSer = in.readLine();
       System.out.println("Server says: " + strSer);
        }
        in.close();
        out.close();
        socket.close();
      } catch (Exception e) {
       System.out.println("Error: " + e); 
      }
  System.out.println("EchoServer stopped."); 
 }
 
}
