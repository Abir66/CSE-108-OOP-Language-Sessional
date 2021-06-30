import java.util.Scanner;

public class PlayerAdder {

    static Scanner scn = new Scanner(System.in);

    public static void addPlayer(){

        System.out.print("Enter player name : ");
        String playerName = InputChecker.string();
        Player player = Database.mainDatabase.searchPlayer(playerName);
        if(player != null){
            System.out.println("Player with name " + playerName + " already exists");
            player.showPlayerInfo();
            return;
        }

        System.out.print("Enter Club: ");
        String clubName = InputChecker.string();
        Club club = Database.mainDatabase.searchClub(clubName);
        if (club != null && club.playerCount()==7){
            System.out.println(clubName + " already has 7 players\n");
            return;
        }

        double salary, height;
        int age, number;

        System.out.print("Enter Country : ");
        String countryName = InputChecker.string();

        System.out.print("Enter age : ");
        age = InputChecker.positiveInt(0,-1,"Age cannot be negative. Please enter a valid number :  ");

        System.out.print("Enter height : ");
        height = InputChecker.positiveDouble("Height cannot be negative. Please enter a valid number: ");

        System.out.print("Enter position : ");
        //String positionName = InputChecker.string();
        String[] positions = {"Goalkeeper", "Forward", "Midfielder", "Defender"};
        String positionName = InputChecker.string(positions,"Please Enter a valid position: ");

        System.out.print("Enter Number : ");
        while (true){
            number = InputChecker.positiveInt(0,-1,"Position cannot be negative. Please enter a valid number: ");
            if (club == null) break;
            Player p = club.checkNumber(number);
            if (p==null) break;
            System.out.print("Number " + number + " is already assigned to "+ p.getName() + ".\nPlease enter a valid number: ");
        }

        System.out.print("Enter Salary : ");
        salary = InputChecker.positiveDouble("Salary cannot be negative. Please enter a valid number: ");

        Player p = new Player();
        Country country = Database.mainDatabase.addCountry(countryName);
        club = Database.mainDatabase.addClub(clubName);

        p.setName(playerName);
        p.setCountry(country);
        p.setClub(club);
        p.setAge(age);
        p.setHeight(height);
        p.setPosition(positionName);
        p.setNumber(number);
        p.setSalary(salary);
        Database.mainDatabase.addPlayer(p);

        System.out.println("\nPlayer added successfully");
        p.showPlayerInfo();
        System.out.println();
    }
}
