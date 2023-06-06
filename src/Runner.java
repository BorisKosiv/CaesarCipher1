import java.io.IOException;

public class Runner {
FileService fileService;

    public Runner( FileService fileService) {

        this.fileService = fileService;
    }

    public void run(String[] args) throws IOException {
    if (args.length > 0 ) {
        String command = (args[0]).toUpperCase();
        String path = args[1];
        String message = fileService.read(path);
        String alphabetDetected = LanguageDetect.detectLanguage(message);
        int shiftKey = 0;
        try {
            shiftKey = Integer.parseInt(args[2]);
        } catch (Exception e) {
            System.out.println("Brute_force");
        }
        Alphabet alphabet = new Alphabet(alphabetDetected);
        CaesarCipher caesarCipher = new CaesarCipher(alphabet);
        CountOccurrenceOfChars countOccurrenceOfChars = new CountOccurrenceOfChars(alphabet);

        if (command.equals("ENCRYPT")) {
            String encryptedText = caesarCipher.EnDecrypt(message, shiftKey);
            fileService.write("[ENCRYPTED]", path, encryptedText);
        } else if  (command.equals("DECRYPT")) {
            String decryptedText = caesarCipher.EnDecrypt(message, -shiftKey);
            fileService.write("[DECRYPTED]", path, decryptedText );
        } else if (command.equals("BRUTE_FORCE")) {
             Character charOccurMax = countOccurrenceOfChars.countChars(message);
             int findKey = caesarCipher.brute_FORCE(charOccurMax);
             System.out.println("Key value: " + findKey);
        }

      }

    }

}
