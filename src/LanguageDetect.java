public class LanguageDetect {

    public static String detectLanguage(String text, String alphabetEN, String alphabetUA) {
        int UA_CharsCount  = countChars(text, alphabetUA);
        int EN_CharCount = countChars(text, alphabetEN);
        int maxCount = Math.max(UA_CharsCount, EN_CharCount);
        if (maxCount == UA_CharsCount) {
            return "UA";
        } else if (maxCount == EN_CharCount) {
            return "EN";
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
