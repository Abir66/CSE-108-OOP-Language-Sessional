import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    static int menu = 0;
    static int command = 0;
    static int[] commandCount = {4,6,5};
    static Scanner scn = new Scanner(System.in);

    static void showMenu(int menu){
        if(menu==0){
            System.out.println("Main Menu:");
            System.out.println("(1) Search Players");
            System.out.println("(2) Search Clubs");
            System.out.println("(3) Add Player");
            System.out.println("(4) Exit System");
        }
        else if(menu==1){
            System.out.println("Player Searching Options:");
            System.out.println("(1) By Player Name");
            System.out.println("(2) By Club and Country");
            System.out.println("(3) By Position");
            System.out.println("(4) By Salary Range");
            System.out.println("(5) Country-wise player count");
            System.out.println("(6) Back to Main Menu");
        }
        else if(menu==2){
            System.out.println("Club Searching Options:");
            System.out.println("(1) Player(s) with the maximum salary of a club");
            System.out.println("(2) Player(s) with the maximum age of a club");
            System.out.println("(3) Player(s) with the maximum height of a club");
            System.out.println("(4) Total yearly salary of a club");
            System.out.println("(5) Back to Main Menu");
        }
    }

    static void takeCommand(){
        String errorMessage = "Please give a valid integer between 1 and " + commandCount[menu] + " : ";
        command = InputChecker.positiveInt(1,commandCount[menu],errorMessage);
    }

    static void executeCommand(){

        if(menu==0) {
            if (command==1) menu = 1;
            else if (command==2) menu = 2;
            else if (command==3) PlayerAdder.addPlayer();
            else if (command==4) menu = 4;
        }

        else if(menu==1){

            if(command == 1){
                System.out.print("Enter a player Name: ");
                String[] tokens = InputChecker.removeDuplicates(InputChecker.string().split(","));
                List<Player> players = Database.mainDatabase.searchPlayer(tokens);
                if(players.isEmpty()) System.out.println("No such player with this name");
                else{
                    System.out.println();
                    for(Player p : players) p.showPlayerInfo();
                }
                System.out.println();
            }

            else if(command == 2){
                System.out.print("Enter country : ");
                String[] tokens = InputChecker.string().split(",");
                tokens = InputChecker.removeDuplicates(tokens);
                List<Country> countries = Database.mainDatabase.searchCountry(tokens);
                if(countries.isEmpty()) System.out.println("No such player with this country");
                else {
                    System.out.print("Enter club : ");
                    String s = InputChecker.string();
                    if (s.equalsIgnoreCase("any")){
                        System.out.println();
                        for(Country c : countries) c.showPlayerInfo();
                    }
                    else{
                        tokens = InputChecker.removeDuplicates(s.split(","));
                        List<Club> clubs = Database.mainDatabase.searchClub(tokens);
                        if(clubs.isEmpty()) System.out.println("No such player with this country and club");
                        else{
                            List<Player> players = new ArrayList();
                            for(Club c : clubs){
                                players.addAll(c.countryPlayers(countries));
                            }
                            if(players.isEmpty()) System.out.println("No such player with this country and club");
                            else {
                                System.out.println();
                                for (Player p : players) p.showPlayerInfo();
                            }
                        }
                    }
                }
                System.out.println();
            }

            else if(command == 3){
                System.out.print("Enter position: ");
                String[] tokens = InputChecker.string().split(",");
                tokens = InputChecker.removeDuplicates(tokens);
                List<Player> players = Database.mainDatabase.searchPlayerByPosition(tokens);
                if(players.size()==0) System.out.println("No such player with this position");
                else{
                    System.out.println();
                    for (Player p : players) p.showPlayerInfo();
                }
                System.out.println();
            }

            else if(command == 4){
                System.out.print("Enter the lower bound of the salary range: ");
                double low = InputChecker.positiveDouble("Salary cannot be negative. Please Enter a valid number: ");
                System.out.print("Enter the upper bound of the salary range: ");
                double high = InputChecker.positiveDouble("Salary cannot be negative. Please Enter a valid number: ");
                while (high<low){
                    System.out.print("Upper bound must be greater than or equal to lower bound. Please Enter a valid number: ");
                    high = InputChecker.positiveDouble("Salary cannot be negative. Please Enter a valid number: ");

                }
                List<Player> players = Database.mainDatabase.searchPlayerBySalary(low,high);
                if(players.size()==0) System.out.print("No such player with this weekly salary range");
                else{
                    System.out.println();
                    for (Player p : players) p.showPlayerInfo();
                }
                System.out.println();
            }

            else if(command == 5){
                System.out.println();
                Database.mainDatabase.showCountryWiseCount();
                System.out.println();
            }

            else if(command == 6){
                menu = 0;
            }
        }

        else if(menu==2){

            if(command == 1){
                System.out.print("Enter club name: ");
                String[] tokens = InputChecker.string().split(",");
                tokens = InputChecker.removeDuplicates(tokens);
                List<Club> clubs = Database.mainDatabase.searchClub(tokens);
                if(clubs.isEmpty()) System.out.println("No such club with this name\n");
                else {
                    System.out.println();
                    List<Player> players= Database.mainDatabase.maxSalaryPlayersFromClub(clubs);
                    for (Player p : players) p.showPlayerInfo();
                    System.out.println();
                }
            }

            else if(command == 2){
                System.out.print("Enter club name: ");
                String[] tokens = InputChecker.string().split(",");
                tokens = InputChecker.removeDuplicates(tokens);
                List<Club> clubs = Database.mainDatabase.searchClub(tokens);
                if(clubs.isEmpty()) System.out.println("No such club with this name\n");
                else {
                    System.out.println();
                    List<Player> players= Database.mainDatabase.maxAgePlayersFromClub(clubs);
                    for (Player p : players) p.showPlayerInfo();
                    System.out.println();
                }
            }

            else if(command == 3){
                System.out.print("Enter club name: ");
                String[] tokens = InputChecker.string().split(",");
                tokens = InputChecker.removeDuplicates(tokens);
                List<Club> clubs = Database.mainDatabase.searchClub(tokens);
                if(clubs.isEmpty()) System.out.println("No such club with this name\n");
                else {
                    System.out.println();
                    List<Player> players= Database.mainDatabase.maxHeightPlayersFromClub(clubs);
                    for (Player p : players) p.showPlayerInfo();
                    System.out.println();
                }
            }

            else if(command == 4){
                System.out.print("Enter club name: ");
                String[] tokens = InputChecker.string().split(",");
                tokens = InputChecker.removeDuplicates(tokens);
                List<Club> clubs = Database.mainDatabase.searchClub(tokens);
                if(clubs.isEmpty()) System.out.println("No such club with this name\n");
                else {
                    System.out.println();
                    for(Club club: clubs){
                        System.out.printf("Total yearly salary of %-20s : ", club.getName());
                        System.out.printf("    %.1f $\n",club.totalYearlySalary());
                    }
                    System.out.println();
                }
            }

            else if(command == 5){
                menu = 0;
            }
        }
    }

    public static void takeInput(){
        while (menu!=4){
            showMenu(menu);
            takeCommand();
            executeCommand();
        }
    }
}
