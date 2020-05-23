import java.util.Scanner;

public class CommandReader {
    private static final Scanner scanner=new Scanner(System.in);
    public static int readNumber(String massage){
        System.out.println(massage);
        return Integer.parseInt(scanner.nextLine());
    }
    public static String readString(String massage){
        System.out.println(massage);
        return scanner.nextLine();
    }
    public static double readDoubleNumber(String massage) {
        System.out.println(massage);
        return Double.parseDouble(scanner.nextLine());
    }
}
