package Requete;
import http.server.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.nio.*;
import java.nio.file.Paths;
import java.util.List;
import http.server.WebServer;


public class Head {

  public static void doMethod(BufferedReader in, PrintWriter out,String ressource){
      System.out.println("[Head] Ressource : "+ressource);

     // this blank line signals the end of the headers
     out.println("");
     // Send the HTML page
     BufferedReader buffReader;
     StringBuffer st = new StringBuffer();
     try{
       buffReader = new BufferedReader(new FileReader(".."+ressource));
       String line;
       int c;
       while((c=buffReader.read())!= -1){
         st.append(c);
       }
       buffReader.close();
     } catch(IOException e){
         e.printStackTrace();
     }
     // Send the headers
      out.println("HTTP/1.0 200 OK");
      out.println("Content-Type: text/html");
      out.println("Server: Bot");
      out.println("Content-Length: "+ st.length());
  }
}