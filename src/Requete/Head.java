package Requete;
import http.server.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.nio.*;
import java.nio.file.Paths;
import java.util.List;

import http.server.WebServer;
import Response.*;


public class Head {

  public static void doMethod(BufferedReader in, PrintWriter out,String ressource,String extension){
      System.out.println("[Head] Ressource : "+ressource);

     // this blank line signals the end of the headers
     out.println("");
     // Send the HTML page
     BufferedReader buffReader;
     StringBuffer st = new StringBuffer();
     int compteur = 0;
     try{
       buffReader = new BufferedReader(new FileReader(".."+ressource));
       String line;
       int c;
       while((c=buffReader.read())!= -1){
         st.append(c);
         compteur++;
       }
       buffReader.close();
     } catch(IOException e){
         e.printStackTrace();
         ErrorHttp error = new ErrorHttp();
         try {
          error.send404(out);
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
     }
     // Send the headers
    
    out.println("HTTP/1.0 200 OK");
    switch (extension) {
      case "html":
          out.println("Content-Type: text/html"); 
          break;
      case "jpeg":
          System.out.println("Cas d'un fichier jpeg");
          out.println("Content-Type: image/jpeg");        
          break;

      case "mp3":
          
  
      default:
          break;
    } 
    
    out.println("Server: Bot");
    out.println("Content-Length: "+ compteur);
    out.println("");
    out.flush();
  }
}