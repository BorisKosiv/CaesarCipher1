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

        Alphabet alphabet = new Alphabet(alphabetDetected);
        CaesarCipher caesarCipher = new CaesarCipher(alphabet);

        if (command.equals("ENCRYPT")) {
            int shiftKey = Integer.parseInt(args[2]);
            String encryptedText = caesarCipher.Encrypt(message, shiftKey);
            fileService.write("[ENCRYPTED]", path, encryptedText);
        } else if  (command.equals("DECRYPT")) {
            int shiftKey = Integer.parseInt(args[2]);
            String decryptedText = caesarCipher.Decrypt(message, shiftKey);
            fileService.write("[DECRYPTED]", path, decryptedText );
        } else if (command.equals("BRUTE_FORCE")) {
             Integer findKey = caesarCipher.brute_FORCE(message);
        }

        }

    }

}
