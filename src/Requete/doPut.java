package Requete;
import http.server.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.nio.*;
import java.nio.file.Paths;
import java.util.List;
import http.server.WebServer;


public class doPut {

  public static void doMethod(String[] head, BufferedReader in, PrintWriter out, String extension,int contentLength){

     // Send the HTML page
     StringBuffer st = new StringBuffer();
     BufferedWriter buffWriter;
     try{
       buffWriter = new BufferedWriter(new FileWriter(".."+ head[1]));
       for (int i = 0; i < contentLength; i++) {
             int c = in.read();
             if (c!=-1)
                   buffWriter.write(c);
       }
       buffWriter.close();

     } catch(IOException e){
         e.printStackTrace();
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
           System.out.println("Cas d'un fichier jpeg");
           out.println("Content-Type: audio/mpeg");
           break;
       default:
           break;
      }
      out.println("Server: Bot");
      out.println("Content-Length: "+ st.length());
      // this blank line signals the end of the headers
      out.println("");
      out.println(st.toString());
      out.flush();
}
}