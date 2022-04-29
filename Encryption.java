/*
* Purpose: encrypt messages
* Author: Madeline Vande Hey
* Date: 4/19/22
*/

public class Encryption{
    public static int shift;
    public static String [] ALPH = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    //cipher alphabet
    public static String[] cipher = new String[26];

    public Encryption(){
    }

    public static String[] getAlph(){
        return ALPH;
    }

    public static String[] getCipher(){
        return cipher;
    }

    public static int getShift(){
        return shift;
    }

    public static void setShift(int s){
        shift = s;
    }

    public static void cipherAlph(String[] cipher, int shift){
        int move = 0;
        int slide = 0;
        for(int i = shift; i < ALPH.length; i++){
            if(i == shift) {
                cipher[move] = ALPH[i];
                move++;
            }
            else if (i < 26){
                cipher[move] = ALPH[i];
                move++;
            } 
        }
        for(int i = move; i < cipher.length; i++){
            cipher[i] = ALPH[slide];
            slide++;
        }
    }

    public static String encryptMes(String mes){
        mes = mes.toLowerCase();
        String cryptMes = "";
        int beginIndex = 0;
        int endIndex = 1;

        for(int f = 0; f < mes.length(); f++){
            if(mes.substring(beginIndex, endIndex).equals(" ")){
                cryptMes += " ";
            }
            else{
                for(int i = 0; i < cipher.length; i++){
                    if(ALPH[i].toLowerCase().equals(mes.substring(beginIndex, endIndex))){
                        cryptMes += cipher[i];
                    }
                }
            }

            beginIndex++;
            endIndex++;
        }
        return cryptMes;
    }
}