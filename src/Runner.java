import java.io.IOException;

public class Runner {
CaesarCipher caesarCipher;
FileService fileService;

CountOccurrenceOfChars countOccurrenceOfChars;

    public Runner(CaesarCipher caesarCipher, FileService fileService, CountOccurrenceOfChars countOccurrenceOfChars) {
        this.caesarCipher = caesarCipher;
        this.fileService = fileService;
        this.countOccurrenceOfChars = countOccurrenceOfChars;
    }
    public void run(String[] args) throws IOException {
    if (args.length > 0 ) {
        String command = (args[0]).toUpperCase();
        String path = args[1];
        int shiftKey = Integer.parseInt(args[2]);
        String typeCommand = "";

        String message = fileService.read(path);
        String cipherUncipherText = caesarCipher.encryptDecrypt(command, message, shiftKey);
        if (command.equals("ENCRYPT")) {
            String cypherUncypherText = caesarCipher.encryptDecrypt(command, message, shiftKey);
            typeCommand = "[ENCRYPTED]";
        } else if  (command.equals("DECRYPT")) {
            String cipherUncypherText = caesarCipher.encryptDecrypt(command, message, shiftKey);
            typeCommand = "[DECRYPTED]";
        } else if (command.equals("BRUTE_FORCE")) {
            int index = 0;
            String charOccurMax = countOccurrenceOfChars.countOccurrenceOfChars(message, index);
            //String findKey = caesarCipher.brute_FORCE(message, charOccurMax);
        }
        fileService.write(typeCommand, path, cipherUncipherText );
        }

    }

}
