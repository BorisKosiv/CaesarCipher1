public class CaesarCipher  {
    Alphabet alphabet;

    public CaesarCipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public String Encrypt(String message, int shiftKey) {

        int lengthAlphabet = alphabet.length();
        String outputText = "";
        char replaceVal;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int charPosition = alphabet.indexOf(c);

            if (charPosition >= 0) {
                int keyVal = (shiftKey + charPosition) % lengthAlphabet;
               replaceVal = alphabet.charAt(keyVal);
            } else {
                replaceVal = c;
            }
            outputText += replaceVal;
        }
        return outputText;
    }

    public String Decrypt(String message, int shiftKey) {
        int lengthAlphabet = alphabet.length();
        String outputText = "";
        char replaceVal;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int charPosition = alphabet.indexOf(c);
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
        return outputText;
        }

    public Integer brute_FORCE(String message) {
        String alphabet = LanguageDetect.detectLanguage(message);
        double[] englishFrequencies = {0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.0228, 0.02015, 0.06094, 0.06,
                0.00153, 0.00772, 0.04025, 0.02406, 0.06749, 0.7507, 0.01929, 0.00095, 0.05987, 0.06327, 0.08056,
                0.02758, 0.00978, 0.02360, 0.00150, 0.01974, 0.00074};

        char charOccurMax = CountOccurrenceOfChars.countChars( message, alphabet);
        int keyVal = 0;
        int charPosition = alphabet.indexOf(charOccurMax);
        return Integer.valueOf(keyVal);
    }


}