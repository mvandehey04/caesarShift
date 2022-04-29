/*
* Purpose: encrypt and decrypt messages using a Caesar shift
* Author: Madeline Vande Hey
* Date: 4/19/22
*/
import java.util.*;

public class CaesarTester {
    public static void main(String args[]){
        // get scanner and prompt for shift
        Scanner scan = new Scanner (System.in);
        System.out.println("Please enter a shift value from 0 to 25");

        // collect user input and set shift
        String value = scan.nextLine();
        Encryption.setShift(Integer.parseInt(value));

        // if the value chosen is not within range
        if(Encryption.getShift() < 0 || Encryption.getShift() > 26) System.out.println("Please enter a shift within the range. (0-25)");

        // create cipher alphabet
        Encryption.cipherAlph(Encryption.getCipher(), Encryption.getShift());

        // print normal alphabet
        for(int i = 0; i < Encryption.getAlph().length; i++){
            // print a at edge of screen
            if(i == 0) System.out.print(Encryption.getAlph()[i]);
            else System.out.printf("%4s", Encryption.getAlph()[i]);
        }

        // print cipher alphabet
        System.out.println();
        for(int i = 0; i < Encryption.getCipher().length; i++){
            // print first letter at edge of screen
            if(i == 0) System.out.print(Encryption.getCipher()[i]);
            else System.out.printf("%4s", Encryption.getCipher()[i]);
        }

        // ask for encryption or decryption or quit
        System.out.println("\n Type 'E' to encrypt a message, type 'D' if you'd like to decrypt a message, or enter 'quit' if you'd like to quit.");
        String crypt = scan.nextLine();

        // check for correct user input
        if(!crypt.toLowerCase().equals("e") && !crypt.toLowerCase().equals("d")) System.out.println("Please enter 'E' or 'D'");

        // check for quit 
        else if(crypt.toLowerCase().equals("quit")){
            scan.close();
        }

        // check for encryption
        else if(crypt.toLowerCase().equals("e")){
            System.out.println("\nEnter a message to encrypt... [ type 'quit' once you're finished encrypting messges ]");
            String message = scan.nextLine();

            // check no quit
            while(!message.equals("quit")){
                System.out.println("Encrypted message: " + Encryption.encryptMes(message));
                System.out.println("\nEnter another message or type 'quit'");
                message = scan.nextLine();
            }

            // close scanner after encrypting
            scan.close();
        }

        else if(crypt.toLowerCase().equals("d")){
            System.out.println("Enter your encrypted message...");
            String message = scan.nextLine();
            Decryption.decrypt(message, Encryption.getCipher(), Encryption.getAlph());
            scan.close();
        }

    }

}
