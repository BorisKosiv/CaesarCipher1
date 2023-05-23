public class LanguageDetect {

    public static String detectLanguage(String text){ //, String alphabetEN, String alphabetUA) {
        int UA_CharsCount  = countChars(text, CaesarCipher.alphabetUA);
        int EN_CharCount = countChars(text, CaesarCipher.alphabetEN);
        int maxCount = Math.max(UA_CharsCount, EN_CharCount);
        if (maxCount == UA_CharsCount) {
            return CaesarCipher.alphabetUA;
        } else if (maxCount == EN_CharCount) {
            return CaesarCipher.alphabetEN;
        } else {
            return "NOTdetected";
        }
    }
    private static int countChars(String text, String alphabet) {
        int countChars = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int charPosition = alphabet.indexOf(c);
            if (charPosition >= 0){
                countChars++ ;
            }
        }
    return countChars;
    }

}
