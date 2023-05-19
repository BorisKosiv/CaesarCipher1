public class CaesarCipher {
    private static final String alphabetEN = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String alphabetUA = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЮЯ";
    public String encryptDecrypt(String command, String message, int shiftKey) {
        String alphabet;
        String whichIsLanguage = LanguageDetect.detectLanguage(message, alphabetEN, alphabetUA);
        if (whichIsLanguage == "UA"){
            alphabet = alphabetUA;
        } else if (whichIsLanguage == "EN"){
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
            if (command.equals("encrypt")){
                if (charPosition >= 0) {
                    int keyVal = (shiftKey + charPosition) % lengthAlphabet;
                    replaceVal = alphabet.charAt(keyVal);
                } else {
                    replaceVal = c;
                }
                outputText += replaceVal;
            } else if (command.equals("decrypt")){
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

}
