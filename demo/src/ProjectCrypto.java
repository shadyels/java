import java.util.Scanner;
import java.lang.String;

public class ProjectCrypto {
    public static void main(String[] args){

        System.out.print("text to normalize: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        System.out.println(normalize(text));
    }

    public static String normalize(String text){
        text = text.replaceAll("[^a-zA-Z0-9]","");
        text = text.replace(" ", "");
        text = text.toUpperCase();

        return text;
    }
}
