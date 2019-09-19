import java.util.Locale;
import java.util.Scanner;
import java.lang.String;

public class ProjectCrypto {
    public static void main(String[] args){
        System.out.print("Write Down a message to encrypt: ");
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        String message = input.nextLine();
        System.out.print("Parameter Shift: ");
        int shift = input.nextInt();
        System.out.print("Parameter Group: ");
        int group = input.nextInt();
        String encryptedMessage = groupify(
                caesarify(
                        normalize(message)
                , shift)
        , group);
        System.out.println("encrypting...");
        System.out.println(encryptedMessage);

        String s = ungroupify(encryptedMessage);

        System.out.println("Decrypting Message...");
        System.out.print("Decrypted Message: ");
        System.out.println(decrypt(s, shift));

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

    public static String ungroupify (String text){
        String deGrouped = deGrouped = text.replaceAll(" ", "");
        for (int i = 0; i < deGrouped.length(); i++){
            char ch = deGrouped.charAt(i);
            if(Character.isLowerCase(ch)){
                deGrouped = deGrouped.replace(ch,' ');
            };
        }
        return deGrouped;
    }

    public static String decrypt (String text, int shift){
        if(shift > 26){
            shift = shift%26;
        } else if (shift < 0){
            shift = (shift%26)+26;
        }

        String decrypted = "";
        int length = text.length();

        for(int i = 0; i < length; i++){
            char ch = text.charAt(i);
            char c = (char)(ch-shift);
            if(c > 'Z'){
                decrypted += (char)(ch - (26-shift));
            }
            if(c < 'Z'){
                decrypted += c;
            }
        }
        return decrypted;
    }
}
