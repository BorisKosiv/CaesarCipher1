import java.io.IOException;

public class Runner {
CaesarCipher caesarCipher;
FileService fileService;


    public Runner(CaesarCipher caesarCipher, FileService fileService) {
        this.caesarCipher = caesarCipher;
        this.fileService = fileService;
         }
    public void run(String[] args) throws IOException {
    if (args.length > 0 ) {
        String command = (args[0]).toUpperCase();
        String path = args[1];
        String message = fileService.read(path);

        if (command.equals("ENCRYPT")) {
            int shiftKey = Integer.parseInt(args[2]);
            String encryptedText = caesarCipher.encryptDecrypt(command, message, shiftKey);
            fileService.write("[ENCRYPTED]", path, encryptedText);
        } else if  (command.equals("DECRYPT")) {
            int shiftKey = Integer.parseInt(args[2]);
            String decryptedText = caesarCipher.encryptDecrypt(command, message, shiftKey);
            fileService.write("[DECRYPTED]", path, decryptedText );
        } else if (command.equals("BRUTE_FORCE")) {
             Integer findKey = caesarCipher.brute_FORCE(message);
        }

        }

    }

}
