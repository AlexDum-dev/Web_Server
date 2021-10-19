package Requete;
import java.io.*;
import java.nio.file.*;


public class Delete {

    public Delete(){

    }

    public void doDelete(String ressource){
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("../"+ressource);
        try {
            boolean isDeleted = Files.deleteIfExists(path);
            System.out.println(isDeleted);
        } catch (Exception e) {
            System.out.println("[doDelete] : impossible d'ouvrir un fichier");
        }

    }    
}
