import java.util.Locale;
import java.util.Scanner;
import java.lang.String;

public class ProjectCrypto {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        String message = input.nextLine();
        String encryptedMessage = groupify(
                caesarify(
                        normalize(message)
                , 2)
        , 2)
        System.out.println(encryptedMessage);
    }

    public static String normalize(String text){
        String temp = "";
        temp = text.replaceAll("[\\s.,:;'!?()\"]","");
        temp = temp.toUpperCase();

        return temp;
    }

    public static String caesarify(String text, int shift){
        if(shift > 26){
            shift = shift%26;
        } else if (shift < 0){
            shift = (shift%26)+26;
        }

        String encryptedText = "";
        int length = text.length();

        for(int i = 0; i < length; i++){
            char ch = text.charAt(i);
            char c = (char)(ch+shift);
            if(c > 'Z'){
                encryptedText += (char)(ch - (26-shift));
            }
            if(c < 'Z'){
                encryptedText += c;
            }
        }

        return encryptedText;
    }

    public static String groupify(String text, int c) {
        String groupedText = "";
        int length = text.length();
        for(int i = 0; i < length; i++){
            if(i % c == 0 && i != 0){
                groupedText += " ";
            }
            groupedText += text.charAt(i);
        }

        int count = 0;
        for(int i = groupedText.lastIndexOf(" "); i < groupedText.length(); i++){
            ++count;
        }
        for(int i = c-count; i >= 0; i--){
            groupedText += 'x';
        }

    return groupedText;
    }
}
