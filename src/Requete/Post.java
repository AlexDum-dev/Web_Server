package Requete;

import java.io.*;

public class Post {

    public Post()
    {

    }

    public void doPost(PrintWriter out, String ressource) throws IOException{
        
        
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");

        out.println("<!doctype html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Post Display</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>A POST request has been received</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Key</th>");
        out.println("<th>Value</th>");
        out.println("</tr>");

        String[] pairs = ressource.split("&");
        for (String pair : pairs)
        {
            out.println("<tr>"); 
            String[] kv = pair.split("=");
            out.println("<td>");            
            out.println(kv[0]);
            out.println("</td>");
            out.println("<td>");            
            out.println(kv[1]);
            out.println("</td>");
            out.println("</tr>"); 
        }


        out.println("</table>");
        out.println("</body>");
        out.println("</html>");


    }


}