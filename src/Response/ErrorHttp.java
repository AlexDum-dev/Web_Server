package Response;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.print.attribute.standard.PrinterName;

public class ErrorHttp {

    public ErrorHttp(){

    }

    public void send404(PrintWriter out) throws IOException{
        out.println("HTTP/1.0 404 Not Found");
        out.println("");
        out.flush();
    }

    public void send500(PrintWriter out) throws IOException{
        out.println("HTTP/1.0 500 Not Found");
        out.println("");
        out.flush();
    }
    
}
