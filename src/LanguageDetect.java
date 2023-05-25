public class LanguageDetect {
    private static final String alphabetEN = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String alphabetUA = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЮЯ";


    public static String detectLanguage(String text) {
        int UA_CharsCount  = countChars(text, alphabetUA);
        int EN_CharCount = countChars(text, alphabetEN);
        int maxCount = Math.max(UA_CharsCount, EN_CharCount);
        if (maxCount == UA_CharsCount) {
            return alphabetUA;
        } else if (maxCount == EN_CharCount) {
            return alphabetEN;
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
