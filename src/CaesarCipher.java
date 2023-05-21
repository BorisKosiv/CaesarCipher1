public class CaesarCipher {
    private static final String alphabetEN = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String alphabetUA = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЮЯ";
    public String encryptDecrypt(String command, String message, int shiftKey) {
        String alphabet;
        String whichIsLanguage = LanguageDetect.detectLanguage(message, alphabetEN, alphabetUA);
        if (whichIsLanguage.equals("UA")){
            alphabet = alphabetUA;
        } else if (whichIsLanguage.equals("EN")){
            alphabet = alphabetEN;
        } else {
            alphabet = "";
        }
        int lengthAlphabet = alphabet.length();
        String outputText = "";
        char replaceVal;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int charPosition = alphabet.indexOf(c);
            if (command.equals("ENCRYPT")){
                if (charPosition >= 0) {
                    int keyVal = (shiftKey + charPosition) % lengthAlphabet;
                    replaceVal = alphabet.charAt(keyVal);
                } else {
                    replaceVal = c;
                }
                outputText += replaceVal;
            } else if (command.equals("DECRYPT")){
                if (charPosition >= 0) {
                    int keyVal = (charPosition - shiftKey) % lengthAlphabet;
                    if (keyVal < 0) {
                        keyVal = (lengthAlphabet + keyVal);
                    }
                    replaceVal = alphabet.charAt(keyVal);
                } else {
                    replaceVal = c;
                }
                outputText += replaceVal;
            }
        }
        return outputText;
    }
    public Integer brute_FORCE(String message, String charOccurMax){
   int keyVal = 0;
        return  Integer.valueOf(keyVal);
    }
}
