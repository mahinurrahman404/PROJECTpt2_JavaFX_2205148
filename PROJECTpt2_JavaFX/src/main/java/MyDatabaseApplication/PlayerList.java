package MyDatabaseApplication;

import java.util.*;

public class PlayerList {
    private final List<Player> players;
    private final Map<String, List<String>> countries = new HashMap<>();
    private int player_number;

    //Constructor
    PlayerList() {
        players = new ArrayList<>();
        player_number = 0;
    }

    //Main add player function
    void addPlayer(Player player) {
        boolean mark = true;
        for(int i = 0 ; i < players.size() ; i++) {
            if(player.getName().equals(this.players.get(i).getName())) {
                mark = false;
                break;
            }
        }
        if(!mark){
            System.out.println("Player with this name already exists");
        }
        else {
            //Adds to the list
            players.add(player);
            player_number++;
            //Adds to the country map
            if (countries.containsKey(player.getCountry())) {
                countries.get(player.getCountry()).add(player.getName());
            } else {
                List<String> List = new ArrayList<>(); //we make a new list for the newfound country
                List.add(player.getName()); // add one player
                countries.put(player.getCountry(), List); //add the combo to the map
            }

        }
    }


    int getSize(){
        return player_number;
    }

    Player getPlayer(int index){
        return players.get(index);
    }


    boolean valid_club(String club){
        boolean valid = false;

        for(int i = 0; i < player_number; i++) {
            if (players.get(i).getClub().equalsIgnoreCase(club)) {
                valid = true;
                break;
            }
        }

            return valid;
    }



    List<Player> AvailablePlayers(String club){//complete
        List<Player> result = new ArrayList<>();
        for(int i = 0; i < this.player_number; i++){
            if(this.players.get(i).getClub().equalsIgnoreCase(club)) {
                result.add(this.players.get(i));
            }
        }
        return result;
    }

    public String isMyPlayer(String name, String username) {
        for(int i = 0; i < this.player_number; i++){
            if(this.players.get(i).getClub().equalsIgnoreCase(username) && this.players.get(i).getName().equalsIgnoreCase(name)) {
                return this.players.get(i).getName();
            }
        }
        return "false";
    }

    public void TransferOwnership(String name, String club) {
        for(int i = 0; i < this.player_number; i++){
            if(this.players.get(i).getName().equalsIgnoreCase(name)) {
                this.players.get(i).setClub(club);
                break;
            }
        }
    }


    //MAIN MENU DEF
    void AddPlayer(){ //complete
        Scanner scan = new Scanner(System.in);
        System.out.println("\nAdd a player");
        //code
        Player temp = new Player();
        this.addPlayer(temp);

        System.out.println("Press 'Enter' to continue ");
        scan.nextLine();
    }








    //SEARCH SUBMENU DEF
    List<Player> name_search(String name){//complete
        List<Player> result = new ArrayList<>();
        for(int i = 0; i < player_number; i++){
            if(this.players.get(i).getName().equalsIgnoreCase(name)){
                result.add(this.players.get(i));
                break;
            }
        }
        return result;
    }

    List<Player> club_country_search(String country, String club){//complete
        List<Player> result = new ArrayList<>();
        for(int i = 0; i < this.player_number; i++){
            if(this.players.get(i).getCountry().equalsIgnoreCase(country)){
                if(this.players.get(i).getClub().equalsIgnoreCase(club) || club.equalsIgnoreCase("ANY")) {
                    result.add(this.players.get(i));
                }
            }
        }
        return result;
    }

    List<Player> position_search(String position){//complete
        List<Player> result = new ArrayList<>();
        for(int i = 0; i < player_number; i++){
            if(this.players.get(i).getPosition().equalsIgnoreCase(position)){
                result.add(this.players.get(i));
            }
        }
        return result;
    }

    List<Player> salary_search(long salary_start, long salary_end){//complete

        List<Player> result = new ArrayList<>();
        for(int i = 0; i < player_number; i++){
            if(this.players.get(i).getSalary() >= salary_start && this.players.get(i).getSalary() <= salary_end){
                result.add(this.players.get(i));
            }
        }
        return result;
    }

    Map<String, List<String>> country_wise_count(){
        return countries;
    }




    //CLUB SEARCH DEF
    List<Player> max_salary(String club_name){
        List<Player> result = new ArrayList<>();
        long max_salary = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getSalary() > max_salary && players.get(i).getClub().equalsIgnoreCase(club_name)) {
                max_salary = players.get(i).getSalary();
            }
        }
        for (int i = 0; i < player_number; i++) {
            if (this.players.get(i).getSalary() == max_salary  && players.get(i).getClub().equalsIgnoreCase(club_name)) {
                result.add(this.players.get(i));
            }
        }
        return result;
    }

    List<Player> max_age(String club_name){
        List<Player> result = new ArrayList<>();
        int max_age = 0;
        for(int i = 0; i < players.size(); i++) {
            if (players.get(i).getAge() > max_age && players.get(i).getClub().equalsIgnoreCase(club_name)) {
                max_age = players.get(i).getAge();
            }
        }
        for (int i = 0; i < player_number; i++) {
            if (this.players.get(i).getAge() == max_age && players.get(i).getClub().equalsIgnoreCase(club_name)) {
                result.add(this.players.get(i));
            }
        }
        return result;
    }

    List<Player> max_height(String club_name){
        List<Player> result = new ArrayList<>();
        double max_height = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getHeight() > max_height && players.get(i).getClub().equalsIgnoreCase(club_name)) {
                max_height = players.get(i).getHeight();
            }
        }
        for(int i = 0; i < player_number; i++){
            if(this.players.get(i).getHeight() == max_height && players.get(i).getClub().equalsIgnoreCase(club_name)) {
                result.add(this.players.get(i));
            }
        }
        return result;
    }

    long yearly_salary(String club_name){
        long total_weekly_salary = 0;
        for(int i = 0; i < player_number; i++) {
            if (players.get(i).getClub().equalsIgnoreCase(club_name)) {
                total_weekly_salary += players.get(i).getSalary();
            }
        }
        total_weekly_salary *= 52;
        return total_weekly_salary;
    }


    //CODE ENDS HERE
}