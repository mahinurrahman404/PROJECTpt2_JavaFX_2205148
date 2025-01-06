package MyDatabaseApplication;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;



public class ServerRunner {
    public static void main() {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server initiated. \nWaiting for connection...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New Client Connected to the Server");
                new Thread(() -> runClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                if (message.equals("GET_AVAILABLE_PLAYERS")) {
                    String fileContent = readFile();
                    out.println(fileContent);
                    out.println("END");
                    out.flush();
                }

                else if (message.startsWith("SELL_PLAYER")) {
                    String playerName = message.substring("SELL_PLAYER ".length());
                    boolean sellprompt = appendToFile(playerName);

                    if (sellprompt) {
                        out.println("Player successfully added to PlayerMarket.");
                    } else {
                        out.println("Player already added to PlayerMarket.");
                    }
                    out.println("END");
                    out.flush();
                }
                else if (message.startsWith("BUY_PLAYER")) {
                    String playerName = message.substring("BUY_PLAYER ".length());
                    boolean buyprompt = removeFromFile(playerName);

                    if (buyprompt) {
                        out.println("Player successfully purchased" + "\n" + "Ownership Transferred");
                    } else {
                        out.println("Player not found in PlayerMarket.");
                    }
                    out.println("END");
                    out.flush();
                }
                else {
                    out.println("Server: " + message.toUpperCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static String readFile() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/PlayerMarket.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file.";
        }
        return content.toString();
    }

    public static boolean appendToFile(String playerName) {

        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/PlayerMarket.txt"));

            for (String line : lines) {
                if (line.trim().equalsIgnoreCase(playerName)) {
                    return false;
                }
            }

            try (FileWriter writer = new FileWriter("src/main/resources/PlayerMarket.txt", true)) {
                writer.append(playerName).append("\n");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    private static boolean removeFromFile(String playerName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/PlayerMarket.txt"));
            boolean removed = lines.removeIf(line -> line.trim().equalsIgnoreCase(playerName));

            if (removed) {
                Files.write(Paths.get("src/main/resources/PlayerMarket.txt"), lines);
            }
            return removed;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
