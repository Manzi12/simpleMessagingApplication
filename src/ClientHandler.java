import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) throws IOException {
        clientSocket = socket;
        out = new PrintWriter(clientSocket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void run(){
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
