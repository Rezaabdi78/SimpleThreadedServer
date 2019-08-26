import java.util.Scanner;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapitalizeClient {
    public static void main(String[] args)throws IOException{
        try(var socket = new Socket("127.0.0.1",59898)) {
            System.out.println("Enter lines of text and Ctrl+D or +C for exit");
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(),true);
            while (scanner.hasNextLine()){
                out.println(scanner.nextLine());
                System.out.println(in.nextLine());
            }
        }
    }
}
