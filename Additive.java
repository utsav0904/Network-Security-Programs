import java.util.Scanner;

public class Additive
{
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
 
    public static String encrypt(String plain, int key)
    {
        plain = plain.toLowerCase();
        String cipher = "";
        for (int i = 0; i < plain.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(plain.charAt(i));
            int keyVal = (key + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipher += replaceVal;
        }
        return cipher;
    }
 
    public static String decrypt(String cipher, int key)
    {
        cipher = cipher.toLowerCase();
        String plain = "";
        for (int i = 0; i < cipher.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(cipher.charAt(i));
            int keyVal = (charPosition - key) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plain += replaceVal;
        }
        return plain;
    }
 
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String message = new String();
        message = sc.next();
        System.out.println(encrypt(message, 3));
        System.out.println(decrypt(encrypt(message, 3), 3));
        sc.close();
    }
}

