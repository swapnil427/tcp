import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
    public static final int PORT = 9090;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Waiting for file request on port " + PORT + "...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // Receive requested filename
            String filename = reader.readLine();
            System.out.println("Requested file: " + filename);

            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File not found!");
                socket.close();
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            OutputStream out = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytes;

            while ((bytes = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytes);
            }

            System.out.println("File sent successfully.");
            fis.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
