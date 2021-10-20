package Requete;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.imageio.ImageIO;

import java.io.IOException;


public class Get {
    
    public Get(){

    }

    public void doGet(Socket s, String ressource, String extension) throws IOException {
        PrintWriter out = new PrintWriter(s.getOutputStream());
        BufferedOutputStream outBuffStream = new BufferedOutputStream(s.getOutputStream());;
        FileReader testReader = null;
        try {
            testReader = new FileReader(".."+ressource);
        } catch (FileNotFoundException e) {
            System.out.println("Impossible to open file");
            out.println("HTTP/1.0 404 Not Found");
            out.println("");
            out.flush();
            return;
        }
        testReader.close();
        File file = new File(".."+ressource);

        int fileLength =(int) file.length();
        
        System.out.println(".."+ressource);       

        // Send the response
        // Send the headers
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Length: "+ Integer.toString(fileLength));
        switch (extension) {
            case "html":
                out.println("Content-Type: text/html"); 
                break;
            case "jpeg":
                System.out.println("Cas d'un fichier jpeg");
                out.println("Content-Type: image/jpeg");        
                break;

            case "mp3":
                System.out.println("Cas d'un fichier audio mp3");
                out.println("Content-Type: audio/mpeg");        
                break;
                
        
            default:
                break;
        }
                
        out.println("Server: Bot");
        out.println("");
        out.flush();
        try {
            byte[] fileData = readData(file);
            outBuffStream.write(fileData);
            outBuffStream.flush();
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }

    /**
     * Read file by putting in bytes.
     * this allows to make no difference between text/audio/
     * @param file
     * @return
     * @throws IOException
     */
    public byte[] readData(File file) throws IOException {
        int lengthFile = (int) file.length();
        FileInputStream dataStream = null;
        byte[] dataArray = new byte[lengthFile];
        try {
            dataStream = new FileInputStream(file);
            dataStream.read(dataArray);
        } finally {
            if (dataStream != null) dataStream.close();
        }
        System.out.println(dataArray);
        return dataArray;
    }

}
