package MyDatabaseApplication;

import java.util.Scanner;

public class Player {
    Scanner scan = new Scanner(System.in);

    private String name;
    private String country;
    private int age;
    private double height;
    private String club;
    private String position;
    private String jersey;
    private long salary;

    //CONSTRUCTOR TO ADD A NEW PLAYER
    public Player() {

        System.out.println("Enter player name: ");
        this.name = scan.nextLine();

        System.out.println("Enter player country: ");
        this.country = scan.nextLine();

        System.out.println("Enter player age: ");
        this.age = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter player height: ");
        this.height = scan.nextDouble();
        scan.nextLine();

        System.out.println("Enter player club name: ");
        this.club = scan.nextLine();

        System.out.println("Enter player position: ");
        this.position = scan.nextLine();

        System.out.println("Enter player jersey number: ");
        this.jersey = scan.nextLine();

        System.out.println("Enter player salary: ");
        this.salary = scan.nextLong();
        scan.nextLine();
    }


    //CONSTRUCTOR WITH PARAMETERS
    public Player(String name, String country, int age, double height, String club, String position, String jersey, long salary) {
        this.salary = salary;
        this.jersey = jersey;
        this.position = position;
        this.club = club;
        this.height = height;
        this.age = age;
        this.country = country;
        this.name = name;
    }


    //TO STRING
    @Override
    public String toString() {
        return "Player Name: " + name + "\n Country: " + country + "\n Age: " + age + "\n Height: " + height +
                "\n Club: " + club + "\n Position: " + position + "\n Jersey: " + jersey + "\n Salary: " + salary + "\n";
    }


    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getJersey() {
        return jersey;
    }

    public void setJersey(String jersey) {
        this.jersey = jersey;
    }


    //CODE ENDS HERE
}
