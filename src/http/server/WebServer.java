///A Simple Web Server (WebServer.java)

package http.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.crypto.spec.DESKeySpec;

import Requete.*;
import Response.*;
/**
 * Example program from Chapter 1 Programming Spiders, Bots and Aggregators in
 * Java Copyright 2001 by Jeff Heaton
 * 
 * WebServer is a very simple web-server. Any request is responded with a very
 * simple web-page.
 * 
 * @author Jeff Heaton
 * @version 1.0
 */
public class WebServer {

  /**
   * WebServer constructor.
   */
  protected void start() {
    ServerSocket s;
    System.out.println("Webserver starting up on port 3000");
    System.out.println("(press ctrl-c to exit)");
    try {
      // create the main server socket
      s = new ServerSocket(3000);
    } catch (Exception e) {
      System.out.println("Error: " + e);
      return;
    }

    System.out.println("Waiting for connection");
    for (;;) {
      try {
        // wait for a connection
        Socket remote = s.accept();
        // remote is now the connected socket
        System.out.println("Connection, sending data.");
        BufferedReader in = new BufferedReader(new InputStreamReader(
            remote.getInputStream()));
        PrintWriter out = new PrintWriter(remote.getOutputStream());

        String url = in.readLine();
        System.out.println("URL : "+url);
        String[] headerSplited = url.split(" ");
        String httpType = headerSplited[0];
        System.out.println("Type de la requete http "+httpType);
        String ressource = headerSplited[1];
        System.out.println("Ressource : "+ressource);
        String extension = null;
        try {
          extension = ressource.split("\\.")[1]; // \\. car just "." in regex means any character
          System.out.println("Extension du fichier "+extension);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {

        }  





        
        String body = new String();

        // read the data sent. We basically ignore it,
        // stop reading once a blank line is hit. This
        // blank line signals the end of the client HTTP
        // headers.
        int contentLentgh = 0;
        String str = ".";
        while (str != null && !str.equals("")){
          str = in.readLine();
          System.out.println(str);
          if (str.startsWith("Content-Length"))
          {
            contentLentgh = Integer.parseInt(str.substring("Content-Length: ".length()));
            System.out.println("Content Length : " + contentLentgh);
          }
        }
        
        if(httpType.equals("POST")){
          System.out.println("POST method detected");
          StringBuilder res = new StringBuilder();
          char c;
          for (int i=0; i<contentLentgh; i++)
          {
            try {
              c = (char) in.read();
              res.append(c);
            }
            catch (Exception e)
            {

            }
            
          }
          System.out.println(res);
          body = res.toString();
          
        }
 
                 
        switch (httpType) {

            case "GET":
              System.out.println("Dans le case get");
              Get get = new Get();
              get.doGet(remote,ressource,extension);
              break;

            case "POST":
              System.out.println("Doing the post...");
              Post post = new Post();
              post.doPost(out, body);
              System.out.println("Response of post has been sent");
              break;
            case "HEAD":
              Head.doMethod(in, out,ressource,extension);
              break;
            case "DELETE":
              //Delete delete = new Delete();
              //delete.doDelete(ressource);
              doDelete.doMethod(headerSplited, in, out);
              break;
            case "OPTIONS":
              //Delete delete = new Delete();
              //delete.doDelete(ressource);
              doOptions.doMethod(out);
              break;
            default:
              ErrorHttp error = new ErrorHttp();
              error.send500(out);
              break;
        }
        
        remote.close();
      } catch (Exception e) {
        System.out.println("Error: " + e);
      }
    }
  }

  /**
   * Start the application.
   * 
   * @param args
   *            Command line parameters are not used.
   */
  public static void main(String args[]) {
    WebServer ws = new WebServer();
    ws.start();
  }
}

