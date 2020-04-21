package szyfr;
public class Cipher {
    /**
     * function encrypt takes value of
     * @param plainText, then it moves counter of each letter(in ASCII array) by
     * @param shift and
     * @return moved letters us a string as they are encrypted now
     */
    public static String encrypt (String plainText, int shift) {
        if(shift>26){
            shift = shift%26;
        }
        else if(shift<0){
            shift = (shift%26)+ 26;
        }

        String cipherText = "";
        int length = plainText.length();
        for (int i = 0; i<length; i++){
            char ch = plainText.charAt(i);
            if(Character.isLetter(ch)){
                if(Character.isLowerCase(ch)){
                    char c = (char)(ch+shift);
                    if(c>'z'){
                        cipherText += (char)(ch - (26-shift));
                    }
                    else{
                        cipherText += c;
                    }
                }
                else if(Character.isUpperCase(ch)){
                    char c = (char)(ch+shift);
                    if(c>'Z'){
                        cipherText += (char)(ch - (26-shift));
                    }
                    else{
                        cipherText += c;
                    }
                }
            }
            else{
                cipherText += ch;
            }
        }
        return cipherText;
    }

    /**
     * function decrypt takes value of
     * @param plainText and moves counter of each letter inversely then encrypt function using
     * @param shift and
     * @return decrypted string
     */
    public static String decrypt (String plainText, int shift) {
        if(shift>26){
            shift = shift%26;
        }
        else if(shift<0){
            shift = (shift%26)+ 26;
        }

        String cipherText = "";
        int length = plainText.length();
        for (int i = 0; i<length; i++){
            char ch = plainText.charAt(i);
            if(Character.isLetter(ch)){
                if(Character.isLowerCase(ch)){
                    char c = (char)(ch-shift);
                    if(c<'a'){
                        cipherText += (char)(ch + (26-shift));
                    }
                    else{
                        cipherText += c;
                    }
                }
                else if(Character.isUpperCase(ch)){
                    char c = (char)(ch-shift);
                    if(c<'A'){
                        cipherText += (char)(ch + (26-shift));
                    }
                    else{
                        cipherText += c;
                    }
                }
            }
            else{
                cipherText += ch;
            }
        }
        return cipherText;
    }
}