import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server listening on port " + PORT + "...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage = in.readLine();
            System.out.println("Client: " + clientMessage);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from Server!");

            socket.close();
            System.out.println("Hello message sent. Closing server.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
