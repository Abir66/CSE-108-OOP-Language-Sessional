public class Main {

    public static void main(String[] args) throws Exception {
        Database.mainDatabase.readFromInputFile();
        System.out.println();
        Database.mainDatabase.showPlayerInfo();
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("Input the number associated with the commands to run that command.");
        System.out.println("To give more than one input in the search options use commas.");
        System.out.println("------------------------------------------------------------------\n");
        UserInput.takeInput();
        Database.mainDatabase.writeToInputFile();
    }
}
