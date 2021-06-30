import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputChecker {

    static Scanner scn = new Scanner(System.in);

    public static double positiveDouble(){ return positiveDouble("");}

    public static int positiveInt(int low, int high){return positiveInt(low,high,"");}

    public static double positiveDouble(String errorMessage){
        double d = 0;
        int l = errorMessage.length();
        boolean isDone = false;
        while (!isDone){
            try{
                d = scn.nextDouble();
                if(d>0) isDone = true;
                else{
                    if(l!=0)System.out.print(errorMessage);
                    else System.out.print("Please enter a valid Number: ");
                }
            }
            catch (InputMismatchException e){
                System.out.print("Please enter a valid Number: ");
                scn.next();
            }
        }
        return d;
    }

    public static int positiveInt(int low, int high, String errorMessage){
        int i=0, l = errorMessage.length();
        boolean isDone = false;
        while (!isDone){
            try{
                i = scn.nextInt();
                if(i >= low && (high==-1 || i<=high)) isDone = true;
                else{
                    if(l!=0)System.out.print(errorMessage);
                    else System.out.print("Please enter a valid integer : ");
                }
            }
            catch (InputMismatchException e){
                System.out.print("Please enter a valid integer : ");
                scn.next();
            }
        }
        return i;
    }

    /**
     * Keeps taking strings until it finds a nonempty string.
     * Removes leading and trailing whitespaces as well as extra whitespaces between words
     * @return
     */
    public static String string(){
        while (true){
            String s = scn.nextLine().strip().replaceAll(" +", " ");;
            if (s.length()!=0) return s;
        }
    }

    public static String[] removeDuplicates(String[] tokens){
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].strip();
        }
        return Arrays.stream(tokens).distinct().toArray(String[]::new);
    }

    public static String string(String[] strings, String errorMessage){
        while (true){
            String string = string();
            for (String s : strings){
                if (s.equalsIgnoreCase(string.strip())) return s;
            }
            System.out.print(errorMessage);
        }
    }

}
