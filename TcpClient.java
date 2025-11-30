import java.io.*;
import java.net.Socket;

public class TcpClient {
    public static final int PORT = 8080;

    public static void main(String[] args) {
        String serverIp = "127.0.0.1";   // Change if needed

        try (Socket socket = new Socket(serverIp, PORT)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from Client!");
            System.out.println("Hello message sent.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String reply = in.readLine();
            System.out.println("Server: " + reply);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
