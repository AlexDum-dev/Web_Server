package Requete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;


public class Get {
    
    public Get(){

    }

    public void doGet(PrintWriter out, String ressource) throws IOException{
        BufferedReader conversationInfos = null;
        System.out.println(".."+ressource);
        try {
            conversationInfos = new BufferedReader(new FileReader(".."+ressource));
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ouverure du fichier");
        }
        
        String infoConversationLine;
        String[] infos;

        // Send the response
        // Send the headers
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        // this blank line signals the end of the headers
        out.println("");

        while((infoConversationLine = conversationInfos.readLine()) != null){
            out.println(infoConversationLine);
        }

        out.flush();
    }
}
