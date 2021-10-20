package Requete;
import http.server.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.nio.*;
import java.nio.file.Paths;
import java.util.List;
import http.server.WebServer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class doOptions {

  public static void doMethod(PrintWriter out){

     // Send the HTML page
     // Send the headers
      Date aujourdhui = new Date();
      SimpleDateFormat formater = new SimpleDateFormat("'le' dd/MM/yyyy 'Ã ' hh:mm:ss");
      out.println("HTTP/1.0 200 OK");
      out.println("Date: "+ formater.format(aujourdhui));
      out.println("Server: Bot");
      out.print("lnAccess-Control-Allow-Origin: http://foo.example/");
      out.print("Access-Control-Allow-Methods: POST, GET, OPTIONS, HEAD, PUT");
      out.print("Access-Control-Allow-Headers:Content-Type");
      out.print("Access-Control-Allow-Headers:Content-Type");
      out.print("Vary: Accept-Encoding, Origin");
      out.print("Content-Encoding: gzip");
      out.print("Content-Length: 0");
      out.print("Keep-Alive: timeout=2, max=100");
      out.print("Connection: Keep-Alive");
      out.print("Content-Type: text/html ");
      out.println("");
      out.flush();

  }
}
