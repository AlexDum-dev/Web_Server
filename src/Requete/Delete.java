package Requete;
import java.io.*;
public class Delete {

    public Delete(){

    }

    public void doDelete(String ressource){
        File file;
        try {
            file = new File(".."+ressource);
            file.delete();
        } catch (Exception e) {
            System.out.println("[doDelete] : impossible d'ouvrir un fichier");
        }
    }    
}
