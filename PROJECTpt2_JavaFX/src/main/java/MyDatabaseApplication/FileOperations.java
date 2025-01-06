package MyDatabaseApplication;

import java.io.*;

public class FileOperations {



    //Players Input From .txt File
    static void Get_Inputs_Text(PlayerList IPL) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/players.txt"));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] in = line.split(",");

            String player_name = in[0];
            String player_country = in[1];
            int player_age = Integer.parseInt(in[2]);
            double player_height = Double.parseDouble(in[3]);
            String player_club = in[4];
            String player_position = in[5];
            String player_jersey = in[6];
            long player_salary = Long.parseLong(in[7]);

            Player temp = new Player(player_name,player_country,player_age,player_height,player_club,player_position,player_jersey,player_salary);
            IPL.addPlayer(temp);
        }
    }


    //Players Save Back to .txt File
    public static void Save_Players_Info(PlayerList IPL) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/players.txt"))) {
            for (int i = 0; i < IPL.getSize(); i++) {
                Player player = IPL.getPlayer(i);
                bw.write(player.getName() + "," + player.getCountry() + "," +
                        player.getAge() + "," + player.getHeight() + "," +
                        player.getClub() + "," + player.getPosition() + "," +
                        player.getJersey() + "," + player.getSalary() + "\n");
            }
        }
    }


}
