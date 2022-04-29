/*
* Purpose: decrypt messages
* Author: Madeline Vande Hey
* Date: 4/19/22
*/
public class Decryption extends Encryption{

    private String[] cipher;
    public Decryption(String[] cipher){
        this.cipher = cipher;
    }

    public static void decrypt(String cipher, String[] cipherAlph, String[] alph){
        cipher = cipher.toLowerCase();
        String decrypt = "";
        int beginIndex = 0;
        int endIndex = 1;

        for(int f = 0; f < cipher.length(); f++){
            if(cipher.substring(beginIndex, endIndex).equals(" ")){
                decrypt += " ";
            }
            else{
                for(int i = 0; i < alph.length; i++){
                    if(cipherAlph[i].toLowerCase().equals(cipher.substring(beginIndex, endIndex))){
                        decrypt += alph[i];
                    }
                }
            }

            beginIndex++;
            endIndex++;
        }

        System.out.println("Decrypted message: " + decrypt);
    }
}
