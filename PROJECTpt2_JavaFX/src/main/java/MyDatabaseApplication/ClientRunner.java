package MyDatabaseApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientRunner {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientRunner() {
        try {
            socket = new Socket("localhost", 12345);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connected to the server.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the server.");
        }
    }


    public String sendMessage(String message) {
        StringBuilder serverResponse = new StringBuilder();

        try {
            out.println(message);
            out.flush();

            String line;
            while ((line = in.readLine()) != null) {
                if (line.equals("END")) {
                    break;
                }
                else{
                    serverResponse.append(line).append("\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Error communicating with server.";
        }

        return serverResponse.toString();
    }

    public boolean isConnected() {
        return socket != null && socket.isConnected();
    }


    public void close() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

