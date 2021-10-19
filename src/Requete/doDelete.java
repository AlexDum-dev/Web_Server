package Requete;
import http.server.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.nio.*;
import java.nio.file.Paths;
import java.util.List;
import http.server.WebServer;
import java.nio.file.*;


public class doDelete {

  public static void doMethod(String[] head, BufferedReader in, PrintWriter out){
    // Send the headers
     out.println("HTTP/1.0 200 OK");
     out.println("Content-Type: text/html");
     out.println("Server: Bot");
     // this blank line signals the end of the headers
     out.println("");
     // Send the HTML page
     FileSystem fs = FileSystems.getDefault();
     try{
       Path path = fs.getPath(".."+  head[1]);
       System.out.println(".."+  head[1]);
       Files.deleteIfExists(path);

     }
      catch (IOException x) {
           // File permission problems are caught here.
          System.err.println(x);
     }
  }
}