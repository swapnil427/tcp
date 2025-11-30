import java.io.*;
import java.net.Socket;

public class TcpFileClient {
    public static final int PORT = 9090;

    public static void main(String[] args) {
        String serverIp = "127.0.0.1";       // Change if needed
        String filename = "sample.txt";      // Requested file

        try (Socket socket = new Socket(serverIp, PORT)) {

            // Send filename
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(filename);

            // Prepare received file
            InputStream in = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream("received_" + filename);

            byte[] buffer = new byte[1024];
            int bytes;

            while ((bytes = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytes);
            }

            fos.close();
            System.out.println("File received and saved as received_" + filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

